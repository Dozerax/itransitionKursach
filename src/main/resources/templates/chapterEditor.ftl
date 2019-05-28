<#import "parts/common.ftl" as comm>
<@comm.page>
    <h1>Edit chapter</h1>
    <form method="post" action="/chapterEditor/${chapter.get().id}">
        <input type="text" name="name" class="col-sm-block form-control mb-2" placeholder="Enter new composition name"
               value="${chapter.get().chaptername}">
        <textarea id="mytextarea" name="textarea">${chapter.get().text}</textarea>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-success btn-lg mt-5 btn-block">Save</button>
    </form>
</@comm.page>