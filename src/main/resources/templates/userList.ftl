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
            <th>Delete user</th>
            <th>Edit</th>
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
                    <form method="post" action="/userList/baned">
                        ${user.active?c}
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-warning" type="submit">Baned/Unbaned</button>
                    </form>
                </td>
                <td>
                    <form method="post" action="/userList/delete">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-danger" type="submit">Delete</button>
                    </form>
                </td>
                <td>
                    <div>
                        <button class="btn btn-primary" type="button" onclick="location.href='/userList/${user.id}'">Edit user
                        </button>
                    </div>
                </td>
            </tr>
        </#list>
    </table>
</@comm.page>