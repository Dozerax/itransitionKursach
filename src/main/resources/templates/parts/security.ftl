<#assign
know = Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    username = user.getUsername()
    isAdmin = user.isAdmin()
    userId = user.getId()
    >
<#else>
    <#assign
    username = ""
    isAdmin = false
    userId = 0
    >
</#if>