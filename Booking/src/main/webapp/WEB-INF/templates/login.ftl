<#include "main-template.ftl"/>
<#macro m_body>

<div ng-app="BookingApp" ng-cloak class="col-md-4 col-md-offset-4">
    <form action="/login/process" method="post" class="login">
        <div class="form-group">
            <label for="exampleInputEmail1">Login</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Login" name="username">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" type="password" class="form-control" id="exampleInputPassword1"
                   placeholder="Password"
                   name="pass">
        </div>
        <#if error??>
            <p>Incorrect login or password!</p>
        </#if>
        <md-button type="submit" class="md-raised md-primary">Log in</md-button>
    </form>


</div>
<script>angular.module('BookingApp', ['ngMaterial']);

</script>
</#macro>
<@main title="Login" customStyles=["resources/css/myStyles.css"]/>