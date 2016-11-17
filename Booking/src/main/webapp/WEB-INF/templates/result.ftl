<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>


<div ng-app="BookingApp" ng-cloak class="container">

    <#include "hotel-list.ftl"/>

</div>
<script>angular.module('BookingApp', ['ngMaterial']);

</script>
</#macro>
<@main title="Serach Result"/>
