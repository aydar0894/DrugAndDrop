<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>
<div class="book">

<div class="col-md-8 col-md-offset-2 ">

    <div ng-app="BookingApp1" ng-cloak>

        <md-content layout-padding>
            <label class="md-headline">Hotel name: ${hotelNumber.hotel.name}</label>
            <md-card-title-media>
                <md-card>
                    <img src="/resources/images/${hotelNumber.hotel.pictUrl}" class="md-card-image"
                         alt="image caption">
                </md-card>
            </md-card-title-media>
            <label class="md-subhead">Hotel discription:
                <p>Location: ${hotelNumber.hotel.hotelLocation} </p>
                <p>room №: ${hotelNumber.number} </p>
                <p>price(per day): ${hotelNumber.price}</p></label>

            <label class="md-subhead">Booking discription:
                <p>Arrivial date: ${search.from?datetime?string('dd-MM-yyyy')} </p>
                <p>Departure date: ${search.to?datetime?string('dd-MM-yyyy')} </p>
                <p>For ${search.peopleQuantity} people(s)</p>
                <p>total price: ${search.dayCount * hotelNumber.price}</p></label>
            <div>
                <form name="userForm" action="/booking/booking/${hotelNumber.id}" method="post">

                    <div ng-controller="BirthCtrl" layout-gt-xs="row">

                        <md-input-container>
                            <label>Your birthday</label>
                            <md-datepicker ng-model="user.submissionDate" id="birthDay"></md-datepicker>
                        </md-input-container>
                    </div>

                    <div layout-gt-sm="row">
                        <md-input-container class="md-block" flex-gt-sm>
                            <label>First name</label>
                            <input name="name" ng-model="user.firstName">
                        </md-input-container>

                        <md-input-container class="md-block" flex-gt-sm>
                            <label>Last name</label>
                            <input name="surname" ng-model="theMax">
                        </md-input-container>
                    </div>


                    <div layout-gt-sm="row">

                        <md-radio-group ng-model="data.group1" layout="row">

                            <md-radio-button name="gender" path="gender" value="Male" class="md-primary" checked="checked">Male</md-radio-button>
                            <md-radio-button name="gender" path="gender" value="Female">Female</md-radio-button>

                        </md-radio-group>
                    </div>


                    <md-button type="submit" class="md-raised md-primary">
                        Confirm!
                    </md-button>

                </form>
            </div>
        </md-content>
    </div>

    <script>angular.module('BookingApp1', ['ngMaterial']).controller('BirthCtrl', function ($scope, $element) {
        $scope.myDate = new Date();

        var myDatePicker = angular.element($element[0].querySelector('#birthDay'));
        var myDatePickerInputContainer = angular.element(myDatePicker[0].children[1]);
        var myDatePickerInput = angular.element(myDatePickerInputContainer[0].children[0]);
        myDatePickerInput.attr("name", "burthDay");
    });
    ;

    </script>
    </div>
</div>

</#macro>
<@main title="Booking" customStyles=["/resources/css/booking.css"]/>