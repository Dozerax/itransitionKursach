<#import "parts/common.ftl" as comm>
<@comm.page>
    ${message?ifExists}
    <form action="/login" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User name :</label>
            <div class="col-sm-5">
                <input type="text" name="username" class="form-control" placeholder="User name"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password :</label>
            <div class="col-sm-5">
                <input type="password" name="password" class="form-control" placeholder="Password"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary mr-2" type="submit">Sign in</button>
        <a href="/registration">Sign up</a>
    </form>
</@comm.page>