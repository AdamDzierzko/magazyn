<div class="form-group">
    <form:hidden path="id"/>
    <form:label path="nazwa">nazwa czesci</form:label>
    <form:input cssClass="form-control" path="nazwa"/>
    <p class="form-group has-error">
        <form:errors path="nazwa" element="label" cssClass="control-label help-block"/>
    <p/>
</div>
<div class="form-group">
    <form:label path="ilosc">ilosc czesci</form:label>
    <form:input cssClass="form-control" path="ilosc"/>
    <p class="form-group has-error">
        <form:errors path="ilosc" element="label" cssClass="control-label help-block"/>
    <p/>
</div>

<button type="submit" class="btn btn-default">Submit</button>
