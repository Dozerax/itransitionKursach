<#import "parts/common.ftl" as comm>
<@comm.page>
    <button type="button" class="btn btn-primary" onclick="location.href='/chapterCreator/${composition.id}'">Create new Chapter</button>
    <table class="table table-bordered table-sm">
        <tr class="text-center">
            <th>Chapter name</th>
            <th>Tools</td>
        </tr>
        <#list chapters as chapter>
            <tr>
                <td class="text-center">${chapter.chaptername}</td>
                <td>
                    <div class="text-center dropdown">
                        <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Tools
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <button class="dropdown-item" type="button" onclick="location.href='/chapterEditor/${chapter.id}'">Edit</button>
                            <form method="post" action="/chapterDelete">
                                <input type="hidden" name="chapterId" value="${chapter.id}">
                                <input type="hidden" name="compositionId" value="${composition.id}">
                                <input type="hidden" value="${_csrf.token}" name="_csrf">
                                <button class="dropdown-item" type="submit">Delete</button>
                            </form>
                        </div>
                    </div>
                </td>
            </tr>
        </#list>
    </table>
</@comm.page>