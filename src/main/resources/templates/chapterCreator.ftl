<#import "parts/common.ftl" as comm>
<@comm.page>
    <h1>Add chapter ${composition}</h1>
    <input type="text" name="name" class="col-sm-block form-control mb-2" placeholder="Enter chapter name"
           form="compositionEditor"">
    <form method="post" action="/chapterCreator" id="compositionEditor">
        <textarea id="mytextarea" name="textarea"></textarea>
        <input type="hidden" name="compositionId" value="${composition}">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
    </form>
    <button form="compositionEditor" type="submit" class="btn btn-success btn-lg mt-5 btn-block">Save</button>
</@comm.page>