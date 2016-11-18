<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<@sf.form action="/admin/addStaff" method="post" modelAttribute="form">
<div>
    <div class="form-group col-md-6">
        <label for="name">Name</label>
        <@sf.input path="name" id="name" cssClass="form-control" placeholder="Name"/>
        <@sf.errors path="name"/>
    </div>

    <div class="form-group col-md-6">
        <label for="salary">Salary</label>
        <@sf.input path="salary" id="salary" cssClass="form-control" placeholder="Salary"/>
        <@sf.errors path="salary"/>
    </div>
</div>

<div>
    <div class="form-group col-md-6">
        <label for="dateOfBirth">Birthday</label>
        <@sf.input path="dateOfBirth" id="dateOfBirth" cssClass="form-control" type="date"/>
        <@sf.errors path="dateOfBirth"/>
    </div>
    <div class="form-group col-md-6">
        <label for="hId">Hotel id</label>
        <@sf.input path="hId" id="hId" cssClass="form-control" placeholder="Hotel id"/>
        <@sf.errors path="hId"/>
    </div>
</div>

<div>
    <div class="form-group col-md-6">
        <label for="position">Position</label>
        <@sf.input path="position" id="position" cssClass="form-control" placeholder="Position"/>
        <@sf.errors path="position"/>
    </div>

    <div class="form-group col-md-6">
        <label for="phone">Phone</label>
        <@sf.input path="phone" id="phone" cssClass="form-control" placeholder="Phone"/>
        <@sf.errors path="phone"/>
    </div>
</div>

<div class="col-md-offset-9">
    <button type="submit" class="btn btn-default">Submit</button>
</div>
</@sf.form>


<#--<div class="form-group">-->
<#--<label for="to" class="">To</label>-->
<#--<@sf.input path="to" id="to" cssClass="form-control" type="date" placeholder="To" />-->
<#--<@sf.errors path="to"/>-->
<#--</div>-->

