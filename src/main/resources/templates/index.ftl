<#import "parts/common.ftl" as comm>
<@comm.page>
    <div class="card-header">
        <#list compositions as composition>
            <div class="card my-3 text-center">
                <div class="m-2">
                    <b>${composition.compositionname?ifExists}</b>
                </div>
                <div class="card-footer text-muted">
                    <form method="post" class="form-inline">
                        <div class="mr-5">
                            ${composition.text}
                        </div>
                    </form>
                </div>
            </div>
        <#else>
            error
        </#list>
    </div>
</@comm.page>