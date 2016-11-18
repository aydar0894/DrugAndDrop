<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>
    <#if RequestParameters.sucss??>
        <div id="success-alert" class="alert alert-success col-md-4 col-md-offset-4" role="alert">Book is done!</div>
    <script>
        $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
            $("#success-alert").slideUp(500);
        });
    </script>
    </#if>
<div class="col-md-4 col-md-offset-4">

    <div ng-app="BookingApp2" ng-cloak>
        <md-content layout-padding>
            <@sf.form action="/booking/hotel_search" method="post" modelAttribute="form">

                <div ng-controller="AppCtrl" layout-gt-xs="row">

                    <md-input-container>
                        <label>From</label>
                        <md-datepicker required ng-model="fromDate" id="fromDatePicker"></md-datepicker>
                        <@sf.errors path="from" cssClass="danger"/>
                    </md-input-container>

                    <input type="hidden" name="1" value="hi!">

                    <md-input-container>
                        <label>To</label>
                        <md-datepicker required ng-model="toDate" id="toDatePicker"></md-datepicker>
                        <@sf.errors path="to" cssClass="danger"/>
                    </md-input-container>
                </div>

                <div layout-gt-sm="row">
                    <md-input-container class="md-block" flex-gt-sm>
                        <label>City</label>
                        <input required name="city" ng-model="somefield" ng-minlength="3">
                        <div ng-messages="userForm.city.$error">
                            <div ng-message="required">This is required.</div>
                        </div>
                        <@sf.errors path="city" cssClass="danger"/>
                    </md-input-container>
                </div>

                <div layout-gt-sm="row">
                    <md-input-container class="md-block" flex-gt-sm>
                        <label>Money</label>
                        <input name="money" ng-model="money">
                    </md-input-container>
                </div>

                <md-input-container class="md-block">
                    <label>Quantity of people</label>
                    <input required name="quantity" ng-model="user.quantity" type="number" step="1" ng-minlength="1">
                    <div ng-messages="userForm.quantity.$error">
                        <div ng-message="required">This is required.</div>
                    </div>
                    <@sf.errors path="quantity" cssClass="danger"/>
                </md-input-container>

                <md-button type="submit" class="md-raised md-primary">Go!</md-button>
            </@sf.form>

    </div>
    <script>angular.module('BookingApp2', ['ngMaterial']).controller('AppCtrl', function ($scope, $element) {
        $scope.myDate = new Date();

        var myDatePicker = angular.element($element[0].querySelector('#fromDatePicker'));
        var myDatePickerInputContainer = angular.element(myDatePicker[0].children[1]);
        var myDatePickerInput = angular.element(myDatePickerInputContainer[0].children[0]);
        myDatePickerInput.attr("name", "from");

        myDatePicker = angular.element($element[0].querySelector('#toDatePicker'));
        myDatePickerInputContainer = angular.element(myDatePicker[0].children[1]);
        myDatePickerInput = angular.element(myDatePickerInputContainer[0].children[0]);
        myDatePickerInput.attr("name", "to");

    });
    ;

    </script>
</#macro>

<@main title="Search"/>