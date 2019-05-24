<#import "parts/common.ftl" as comm>
<@comm.page>
    <h3>User list</h3>
    <table class="table table-bordered table-sm">
        <tr class="text-center">
            <th>id</th>
            <th>User name</th>
            <th>Email</th>
            <th>Access</th>
            <th>Activated</th>
            <th>Tools</th>
        </tr>
        <#list users as user>
            <tr class="text-center">
                <td>
                    <i>${user.id}</i>
                </td>
                <td>
                    <i>${user.username}</i>
                </td>
                <td>
                    <i>${user.email!''}</i>
                </td>
                <td>
                    <i><#list user.roles as role>${role}<#sep>, </#list>
                </td>
                <td>
                        ${user.active?c}
                </td>
                <td>
                    <div class="d-inline dropdown">
                        <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Tools
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <form method="post" action="/userList/baned">
                                <input type="hidden" name="id" value="${user.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <button class="dropdown-item" type="submit">Baned/Unbaned user</button>
                            </form>
                            <form method="post" action="/userList/delete">
                                <input type="hidden" name="id" value="${user.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <button class="dropdown-item" type="submit">Delete user</button>
                            </form>
                            <button class="dropdown-item" type="button" onclick="location.href='/userList/${user.id}'">
                                Edit user
                            </button>
                            <button class="dropdown-item" type="button" onclick="location.href='/userComposition/${user.id}'">
                                Get user compositions</button>
                        </div>
                    </div>
                </td>
            </tr>
        <#else>
            User not found
        </#list>
    </table>
</@comm.page>