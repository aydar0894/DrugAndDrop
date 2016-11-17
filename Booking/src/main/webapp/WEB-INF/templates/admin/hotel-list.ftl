<table class="table table-striped">
    <caption>Hotels:</caption>
    <tr>
        <th>Hotel id </th>
        <th>Hotel Name</th>
        <th>Locatione</th>
        <th>Category</th>
    </tr>
<#list hotels as hotel>

    <tr>
        <td>${hotel.id}</td>
        <td>${hotel.name}</td>
        <td>${hotel.hotelLocation}</td>
        <td>${hotel.hotelCategory}</td>
    </tr>
</#list>
</table>

