<#import "parts/common.ftl" as comm>
<#include "parts/security.ftl">
<@comm.page>
    <h1>Create new composition</h1>

    <input type="text" name="name" class="col-sm-block form-control mb-2" placeholder="Enter composition name" form="createComposition">
    <form method="post" action="/compositionCreate" id="createComposition">
        <div class="input-group">
            <textarea type="text" name="description" class="col-sm-block form-control mb-2" rows="3" placeholder="Enter description"></textarea>
        </div>
        <textarea id="mytextarea" name="textarea"></textarea>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
    </form>
    <div class="mt-2">
        <h2>Choise genre</h2>
        <#list genres as genre>
            <div class="form-check form-check-inline">
                <label class="form-check-label" for="defaultCheckedDisabled2">
                    <input type="checkbox" class="form-check-input" form="createComposition" name="checked" value="${genre}">${genre}
                </label>
            </div>
        <#else>
            Genre not found
        </#list>
    </div>
    <button form="createComposition" type="submit" class="btn btn-success btn-lg mt-5 btn-block">Save</button>
</@comm.page>