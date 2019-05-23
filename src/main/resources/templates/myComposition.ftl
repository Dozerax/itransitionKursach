<#import "parts/common.ftl" as comm>
<@comm.page>
    <#list myComposition as composition>
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
                <div class="d-inline float-right">
                    <button class="btn btn-primary" onclick="location.href='/compositionReader/${composition.id}'">Read</button>
                    <button class="btn btn-warning" onclick="location.href='/compositionEditor/${composition.id}'">Edit</button>
                    <button type="submit" class="btn btn-danger" form="delete">Delete</button>
                </div>
            </div>
        </div>
    <#else>
        Composition not found
    </#list>
</@comm.page>