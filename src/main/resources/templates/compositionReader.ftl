<#import "parts/common.ftl" as comm>
<@comm.page>
    <div>
        <h3><b>${composition.compositionname?ifExists}</b></h3>
        <h2>Author : ${composition.author.username}</h2>
        <#list chapters as chapter>
            <div class="card my-3 border-dark">
                <div class="card-header text-center">
                    <b>${chapter.chaptername?ifExists}</b>
                </div>
                <div class="card-body">
                    ${chapter.text}
                </div>
            </div>
        </#list>
    </div>
</@comm.page>