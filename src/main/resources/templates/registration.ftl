<#import "parts/common.ftl" as comm>
<@comm.page>

    ${message?ifExists}
    <form action="/registration" method="post">
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
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email :</label>
            <div class="col-sm-5">
                <input type="email" name="email" class="form-control" placeholder="name@email.com" value="${email!''}"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary mr-2" type="submit">Sign up</button>
    </form>

</@comm.page>