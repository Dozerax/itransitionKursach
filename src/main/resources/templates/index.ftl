<#import "parts/common.ftl" as comm>
<#import "parts/pager.ftl" as page>
<@comm.page>
    <div>
        <#list compositions.content as composition>
            <div class="card my-3 border-dark">
                <div class="card-header text-center">
                    <b>${composition.compositionname?ifExists}</b>
                </div>
                <div class="card-body">
                    ${composition.compositionDescription}
                </div>
                <div class="card-footer">
                    <div class="d-inline float-left">
                        <div>
                            Author : ${composition.author}
                        </div>
                        <div>
                            Genres : <#list composition.genres as genre>${genre}<#sep>, </#list>
                        </div>
                    </div>
                    <div class="d-inline float-right">
                        <button class="btn btn-primary btn-lg" onclick="location.href='/compositionReader/${composition.id}'">Read</button>
                    </div>
                </div>
            </div>
        <#else>
            Composition not found
        </#list>
    </div>
    <@page.pager url page />
</@comm.page>