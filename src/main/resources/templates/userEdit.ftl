<#import "parts/common.ftl" as comm>
<@comm.page>
    <h5>Edit user</h5>
    <form action="/userList" method="post">
        <input type="text" name="username" class="col-sm-3 form-control" value="${user.username}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-primary mr-2">Save</button>
    </form>
</@comm.page>