package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.form.SearchForm;
import ru.kpfu.itis.model.Booking;
import ru.kpfu.itis.model.HotelNumber;
import ru.kpfu.itis.model.Search;
import ru.kpfu.itis.service.BookingService;
import ru.kpfu.itis.service.HotelNumberService;
import ru.kpfu.itis.service.SearchService;
import ru.kpfu.itis.util.BookingValidator;
import ru.kpfu.itis.util.SearchFormToSearchTransformer;
import ru.kpfu.itis.util.SearchFormValidator;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Controller
@SessionAttributes("search")
@RequestMapping(value = "/booking")
public class BookingController {

    Validator searchFormValidator = new SearchFormValidator();
    Validator bookingValidator = new BookingValidator();

    @Autowired
    private BookingService bookingService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private HotelNumberService numberSrvice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(Model model) {

        model.addAttribute("form", new SearchForm());
        return "search";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String getRegistrationPage(Model model, @ModelAttribute Search search) {
        List<HotelNumber> hotelNumbers;
        if (search == null)
            hotelNumbers = new ArrayList();
        else
            hotelNumbers = searchService.search(search);
        model.addAttribute("hotelNumbers", hotelNumbers);
        return "result";
    }

    @RequestMapping(value = "/hotel_search", method = RequestMethod.POST)
    public String getIndex(@ModelAttribute("form") @Validated SearchForm form, BindingResult result, Model model,
                           HttpSession session) {
        if (result.hasErrors()) {
            return "search";
        }

        searchFormValidator.validate(form, result);
        if (result.hasErrors()) {
            return "search";
        }

        Search sessionSearch = (Search) session.getAttribute("search");
        Search search = SearchFormToSearchTransformer.transform(form);

        if (sessionSearch == null)
            session.setAttribute("search", search);
        else sessionSearch = search;
        return "redirect:/booking/result";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/booking/{id}", method = RequestMethod.GET)
    public String getBooking(@PathVariable("id") String numberId, Model model, @ModelAttribute Search search) {
        if (search == null) {
            return "redirect:/booking/";
        }
        HotelNumber hotelNumber = numberSrvice.findById(numberId);
        model.addAttribute("hotelNumber", hotelNumber);
//        model.addAttribute("search", search);
        return "booking";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/booking/{id}", method = RequestMethod.POST)
    public String booking(@ModelAttribute("form") SearchForm form, BindingResult result, @PathVariable("id") String numberId, @RequestParam("name") String name,
                          @RequestParam("surname") String surname,
                          @RequestParam("burthDay") String birthDay, Model model, @ModelAttribute Search search) {
        HotelNumber number = numberSrvice.findById(numberId);
        //// FIXME: 15.11.2016
        String sex = "Male";
        Booking booking = new Booking();
        booking.setArrivalDate(search.getFrom());
        booking.setDateOfDeparture(search.getTo());
        booking.sethId(number.getHotel().getId());
        booking.setPaymentForm(0);
        booking.setnId(number.getId());
        booking.setTotalPrice(number.getPrice() * search.getDayCount());

        int male = sex.equals("Male") ? 1 : 0;
        booking.setGender(male);
        booking.setCustName(name + " " + surname);
        booking.setBirthDay(birthDay);

        bookingValidator.validate(booking, result);
        if (result.hasErrors()) {
            model.addAttribute("hotelNumber", number);
            return "/booking/" + numberId;
        }

        bookingService.save(booking);
        return "redirect:/?sucss=\"true\"";
    }
}
