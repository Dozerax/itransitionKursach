<#import "parts/common.ftl" as comm>
<@comm.page>
        <h1>Edit your composition</h1>
        <input type="text" name="name" class="col-sm-block form-control mb-2" placeholder="Enter new composition name"
               form="compositionEditor" value="${composition.compositionname}">
        <form method="post" action="/myComposition/update" id="compositionEditor">
            <input type="text" name="description" class="col-sm-block form-control mb-2" placeholder="Enter description"
            value="${composition.compositionDescription}">
            <textarea id="mytextarea" name="textarea">${composition.text}</textarea>
            <input type="hidden" name="compositionId" value="${composition.id}">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </form>
        <div class="mt-2">
            <h2>Choise genre</h2>
            <#list genres as genre>
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input type="checkbox" form="compositionEditor" class="form-check-input" name="${genre}" ${composition.genres?seq_contains(genre)?string("checked", "")}>${genre}
                    </label>
                </div>
            <#else>
                Genre not found
            </#list>
        </div>
        <button form="compositionEditor" type="submit" class="btn btn-success btn-lg mt-5 btn-block">Save</button>
</@comm.page>