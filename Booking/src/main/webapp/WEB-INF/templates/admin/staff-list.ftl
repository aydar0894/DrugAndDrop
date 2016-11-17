<@sf.form action="/admin/addStaff" method="post" modelAttribute="form">
<div class="form-group">
    <label for="username">Name</label>
    <@sf.input path="name" id="name" cssClass="form-control" placeholder="Name"/>
    <@sf.errors path="name"/>
</div>

<div class="form-group">
    <label for="pass">Salary</label>
    <@sf.input path="salary" id="salary" cssClass="form-control" placeholder="Salary"/>
    <@sf.errors path="salary"/>
</div>

<div class="form-group">
    <label for="hId">Hotel id</label>
    <@sf.input path="hId" id="hId" cssClass="form-control" placeholder="Hotel id"/>
    <@sf.errors path="hId"/>
</div>

<div class="form-group">
    <label for="email">Birthday</label>
    <@sf.input path="dateOfBirth" id="dateOfBirth" cssClass="form-control" placeholder="Birthday" type="date"/>
    <@sf.errors path="dateOfBirth"/>
</div>

<div class="form-group">
    <label for="pass">Position</label>
    <@sf.input path="position" id="position" cssClass="form-control" placeholder="Position"/>
    <@sf.errors path="position"/>
</div>

<div class="form-group">
    <label for="pass">Phone</label>
    <@sf.input path="phone" id="phone" cssClass="form-control" placeholder="Phone"/>
    <@sf.errors path="phone"/>
</div>

<button type="submit" class="btn btn-default">Submit</button>
</@sf.form>

<table class="table table-striped">
    <caption>Rents:</caption>
    <tr>
        <th>Rent id</th>
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
        <td>${staff.hotel.name}</td>
        <td>${staff.name}</td>
        <td>${staff.salary}</td>
        <td>${staff.dateOfBirth}</td>
        <td>${staff.position}</td>
        <td>${staff.phone}</td>
    </tr>
</#list>
</table>

