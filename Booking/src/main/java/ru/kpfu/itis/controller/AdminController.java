package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.form.StaffForm;
import ru.kpfu.itis.model.Hotel;
import ru.kpfu.itis.model.Rent;
import ru.kpfu.itis.model.Staff;
import ru.kpfu.itis.repository.HotelRepository;
import ru.kpfu.itis.repository.RentRepository;
import ru.kpfu.itis.repository.StaffRepository;
import ru.kpfu.itis.service.StaffService;

import java.util.List;

/**
 * Created by Ilgiz on 17.11.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StaffService staffService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(Model model) {
        return "/admin/index";
    }

    @RequestMapping(value = "/getAllRents")
    public String getAllRents(Model model) {
        List<Rent> rents = rentRepository.findAll();
        model.addAttribute("rents", rents);
        return "/admin/rent-list";
    }

    @RequestMapping(value = "/getAllHotels")
    public String getAllHotels(Model model) {
        List<Hotel> hotels = hotelRepository.findAll();
        model.addAttribute("hotels", hotels);
        return "/admin/hotel-list";
    }

    @RequestMapping(value = "/getAllStaffs")
    public String getAllStaffs(Model model) {
        List<Staff> staffs = staffRepository.findAll();
        model.addAttribute("staffs", staffs);
        model.addAttribute("form", new StaffForm());
        return "/admin/staffs-list";
    }

    @RequestMapping(value = "/addStaff", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String addStuff(@ModelAttribute(value = "form") @Validated StaffForm staff, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            staffService.addStaff(staff);
        } else
            model.addAttribute("form", staff);
        return "redirect:/admin/";
    }
}
