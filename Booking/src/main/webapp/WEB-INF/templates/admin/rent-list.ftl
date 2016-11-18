<table class="table table-striped">
    <caption>Rents:</caption>
    <tr>
        <th>Rent id</th>
        <th>Hotel Name</th>
        <th>Total price</th>
        <th>Number</th>
        <th>Username</th>
        <th>Arrival date</th>
        <th>Date of departure</th>
    </tr>

<#list rents as rent>
    <tr>
        <td>${rent.id}</td>
        <td>${rent.hId.name}</td>
        <td>${rent.totalPrice}</td>
        <td>${rent.nId.number}</td>
        <td>${rent.cId.custName}</td>
        <td>${rent.arrivalDate}</td>
        <td>${rent.dateOfDeparture}</td>
    </tr>
</#list>
</table>

