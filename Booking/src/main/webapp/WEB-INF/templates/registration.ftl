<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>

<div ng-app="BookingApp" ng-cloak class="col-md-4 col-md-offset-4">

    <@sf.form action="/registration" method="post" modelAttribute="userform" class="login">
        <div class="form-group">
            <label for="username">Username</label>
            <@sf.input path="username" id="username" cssClass="form-control" placeholder="Логин"/>
            <@sf.errors path="username"/>
        </div>

        <div class="form-group">
            <label for="pass">Password</label>
            <@sf.input path="pass" id="pass" type="password" cssClass="form-control" placeholder="Пароль"/>
            <@sf.errors path="pass"/>
        </div>

        <div class="form-group">
            <label for="repassword">Take password again</label>
            <@sf.input path="repassword" id="repassword" type="password" cssClass="form-control" placeholder="Повторите пароль"/>
            <@sf.errors path="repassword"/>
        </div>

        <div class="form-group">
            <label for="email">email</label>
            <@sf.input path="email" id="email" cssClass="form-control" placeholder="Email"/>
            <@sf.errors path="email"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <@sf.input path="phone" id="phone" cssClass="form-control" placeholder="Phone"/>
            <@sf.errors path="phone"/>
        </div>

        <md-button type="submit" class="md-raised md-primary">Submit</md-button>
    </@sf.form>

</div>
<script>angular.module('BookingApp', ['ngMaterial']);

</script>
</#macro>
<@main title="Главная" customStyles=["resources/css/myStyles.css"]/>