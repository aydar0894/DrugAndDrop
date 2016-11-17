<#include "../main-template.ftl"/>

<#macro m_body>
<div class="container text-center" ng-app="BookingApp" ng-cloak>

    <div class="content-404">
        <md-card-title-text >

            <h1><b>OPPS!</b> We Couldn’t Find this Page</h1>
            <p>Uh... So it looks like you brock something. The page you are looking for has up and Vanished.</p>
            <h2><a href="/">Bring me back Home</a></h2>
        </md-card-title-text>
    </div>
</div>
<script>angular.module('BookingApp', ['ngMaterial']);

</script>
</#macro>

<@main title="404" customStyles=["resources/css/404.css"]/>