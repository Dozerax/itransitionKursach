<#include "security.ftl">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Fanfik</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/login">Authentication</a>
            </li>
                <li class="nav-item">
                    <a class="nav-link" href="/userList/profile">My profile</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Composition
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/allComposition">All composition</a>
                        <a class="dropdown-item" href="/myComposition">My Composition</a>
                        <a class="dropdown-item" href="/compositionCreate">Create new Composition</a>
                    </div>
                </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/userList">UserList</a>
                </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3">${username}</div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button class="btn btn-primary" type="submit">Exit</button>
        </form>
    </div>
</nav>