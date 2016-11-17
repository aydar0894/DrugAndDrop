<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <@security.authentication property="principal.username" var="username"/>
    <@security.authentication property="principal.role" var="role"/>
</@security.authorize>

<header>
    <div class="col-lg-3 col-lg-offset-9 userside">
    <#if username??>
        <p>${username}  <a href="/logout">Sign out</a></p>
    <#else>
        <p><a href="/login">Sign in</a> <a href="/registration">Sign up</a></p>
    </#if>
    </div>
</header>