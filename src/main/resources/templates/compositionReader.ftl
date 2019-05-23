<#import "parts/common.ftl" as comm>
<@comm.page>
    <div>
        <h3><b>${composition.compositionname?ifExists}</b></h3>
        <h2>Author : ${composition.author}</h2>
        <div class="card my-3 border-dark">
            <div class="card-body">
                ${composition.text}
            </div>
            <div class="card-footer">
                <div class="d-inline float-right">
                    <button type="button" class="btn btn-primary">Download</button>
                </div>
            </div>
        </div>
    </div>
</@comm.page>