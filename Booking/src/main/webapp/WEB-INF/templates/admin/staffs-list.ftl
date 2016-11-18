<#include "staff-form.ftl"/>
<table class="table table-striped">
    <caption>Staff:</caption>
    <tr>
        <th>Staff id</th>
        <th>Hotel Name</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Birthday</th>
        <th>Position</th>
        <th>Phone</th>
    </tr>

<#list staffs as staff>
    <tr>
        <td>${staff.id}</td>
        <td>${staff.hId.name}</td>
        <td>${staff.name}</td>
        <td>${staff.salary}</td>
        <td>${staff.dateOfBirth}</td>
        <td>${staff.position.name}</td>
        <td>${staff.phone}</td>
    </tr>
</#list>
</table>

