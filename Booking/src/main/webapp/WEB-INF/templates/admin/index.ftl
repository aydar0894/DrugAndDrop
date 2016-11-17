<#include "../main-template.ftl"/>

<#macro m_body>

<div class="col-md-10 col-md-offset-1 admin-buttons">

    <div class="col-md-4">
        <div class="col-md-offset-4">

            <button id="rents-btn" class="btn btn-default">Rents</button>

        </div>
    </div>


    <div class="col-md-4">
        <div class="col-md-offset-4">

            <button id="hotel-btn" class="btn btn-default">Hotels</button>

        </div>
    </div>

    <div class="col-md-4">
        <div class="col-md-offset-4">

            <button id="staff-btn" class="btn btn-default">Staff</button>

        </div>
    </div>

</div>

<div id="js-data" class="col-md-offset-2 col-md-8 admin-date">
</div>


</#macro>

<@main title="Main" customScripts=["/resources/js/admin.js"] customStyles=["/resources/css/admin.css"]/>