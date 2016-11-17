<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>

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

        <#--<@sf.form action="/booking/search_hotels" method="post" modelAttribute="bookingform">-->

        <#--<div layout-gt-xs="row">-->

        <#--<md-input-container>-->
        <#--<label for="from">From</label>-->
        <#--<md-datepicker path="from" id="from" ng-model="fromDate"></md-datepicker>-->
        <#--<@sf.errors path="from"/>-->

        <#--</md-input-container>-->
        <#--<md-input-container>-->
        <#--<label for="to">To</label>-->
        <#--<md-datepicker path="to" id="to" ng-model="toDate"></md-datepicker>-->
        <#--<@sf.errors path="to"/>-->
        <#--</md-input-container>-->
        <#--</div>-->

        <#--<div layout-gt-sm="row">-->
        <#--<md-input-container class="md-block" flex-gt-sm>-->
        <#--<label for="city">City</label>-->
        <#--<input path="city" id="city" required name="city" ng-model="somefield" ng-minlength="3">-->
        <#--<div ng-messages="userForm.city.$error">-->
        <#--<div ng-message="required">This is required.</div>-->
        <#--</div>-->
        <#--<@sf.errors path="city"/>-->

        <#--</md-input-container>-->
        <#--</div>-->

        <#--<div layout-gt-sm="row">-->
        <#--<md-input-container class="md-block" flex-gt-sm>-->
        <#--<label for="money">Money</label>-->
        <#--<input ng-model="money" path="money" id="money" cssClass="form-control" placeholder="Money"/>-->
        <#--<@sf.errors path="money"/>-->
        <#--</md-input-container>-->
        <#--</div>-->

        <#--<md-input-container class="md-block">-->
        <#--<label for="quantity">Quantity of people</label>-->
        <#--<input name="quantity" ng-model="user.quantity" type="number" step="1" ng-minlength="1"-->
        <#--path="quantity" id="quantity" cssClass="form-control"-->
        <#--placeholder="Quantity of people"/>-->
        <#--<div ng-messages="userForm.quantity.$error">-->
        <#--<div ng-message="required">This is required.</div>-->
        <#--</div>-->
        <#--<@sf.errors path="quantity"/>-->

        <#--</md-input-container>-->

        <#--<md-button type="submit" class="md-raised md-primary">Go!</md-button>-->

        <#--<div class="form-group">-->
        <#--<label for="city" class="">Place</label>-->
        <#--<@sf.input path="city" id="city" cssClass="form-control" placeholder="Place" autofocus="true" />-->
        <#--<@sf.errors path="city"/>-->
        <#--</div>-->

        <#--<div class="form-group">-->
        <#--<label for="from" class="">From</label>-->
        <#--<@sf.input path="from" id="from" cssClass="form-control" type="date" placeholder="From" />-->
        <#--<@sf.errors path="from"/>-->
        <#--</div>-->

        <#--<div class="form-group">-->
        <#--<label for="to" class="">To</label>-->
        <#--<@sf.input path="to" id="to" cssClass="form-control" type="date" placeholder="To" />-->
        <#--<@sf.errors path="to"/>-->
        <#--</div>-->

        <#--<div class="form-group">-->
        <#--<label for="money" class="">Money</label>-->
        <#--<@sf.input path="money" id="money" cssClass="form-control" placeholder="Money" />-->
        <#--<@sf.errors path="money"/>-->
        <#--</div>-->

        <#--<div class="form-group">-->
        <#--<label for="quantity" class="">Quantity of people</label>-->
        <#--<@sf.input path="quantity" id="quantity" cssClass="form-control" placeholder="Quantity of people" />-->
        <#--<@sf.errors path="quantity"/>-->
        <#--</div>-->
        <#--&lt;#&ndash;<md-button type="submit" class="md-raised md-primary">Primary</md-button>&ndash;&gt;-->
        <#--<button type="submit" class="btn btn-default">Find it!</button>-->
        <#--</@sf.form>-->

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