<#import "parts/common.ftl" as comm>
<#import "parts/pager.ftl" as page>
<@comm.page>
    <#list compositions.content as composition>
        <form method="get">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
        <form  method="post" action="/myComposition/delete" id="delete">
            <input type="hidden" name="compositionId" value="${composition.id}">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
        <div class="card my-3 border-dark">
            <div class="card-header text-center">
                <b>${composition.compositionname?ifExists}</b>
            </div>
            <div class="card-body">
                ${composition.compositionDescription}
            </div>

            <div class="card-footer">

                <div class="d-inline float-left mt-1">
                    Genres : <#list composition.genres as genre>${genre}<#sep>, </#list>
                </div>
                <div class="d-inline float-right dropdown">
                    <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Tools
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <button class="dropdown-item" type="button" onclick="location.href='/compositionReader/${composition.id}'">Read</button>
                        <button class="dropdown-item" type="button" onclick="location.href='/compositionEditor/${composition.id}'">Edit</button>
                        <button class="dropdown-item" type="submit" form="delete">Delete</button>
                    </div>
                </div>
            </div>
        </div>
    <#else>
        Composition not found
    </#list>
    <@page.pager url page />
</@comm.page>