<#import "parts/common.ftl" as comm>
<@comm.page>
    <h3>Edit user</h3>
    <form action="/userList" method="post">
        <div class="form-row">
            <label for="colFormLabel" class="col-form-label col-form-label">User name : </label>
            <input type="text" name="username" class="col-sm-3 mb-2 form-control" value="${user.username}">
        </div>
        <div>
        <#list roles as role>
            <div <div class="form-check form-check-inline">
                <label class="form-check-label">
                    <input type="checkbox" class="form-check-input" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
                </label>
            </div>
        <#else>
            Roles not found
        </#list>
        </div>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-success mr-2 mt-2">Save</button>
    </form>
</@comm.page>