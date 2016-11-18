<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <@security.authentication property="principal.username" var="username"/>
    <@security.authentication property="principal.role" var="role"/>
</@security.authorize>

<header>
<#if username??>
    <div class="col-lg-8 col-lg-offset-1">
        <#if role == "ROLE_ADMIN">
            <a class="admin-link" href="/admin/">ADMIN PANEL</a>
        </#if>
    </div>

<div class="col-lg-2 userside">

    <p>${username}  <a href="/logout">Sign out</a></p>
<#else>
    <div class="col-lg-3 col-lg-offset-9 userside">

    <p><a href="/login">Sign in</a> <a href="/registration">Sign up</a></p>
</div>

</#if>
</header>