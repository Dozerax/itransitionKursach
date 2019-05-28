<#import "parts/common.ftl" as comm>

<@comm.page>
    <h3>User name : ${username}</h3>
    <button class="btn btn-primary" onclick="location.href='/myComposition'">My composition</button>
    ${message?ifExists}
    <form method="post">
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
        <button class="btn btn-success mr-2" type="submit">Save</button>
    </form>
</@comm.page>