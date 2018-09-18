<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>

<div class="form-group">
    <form:hidden path="id"/>
    <for:label path="nazwa">Nazwa</for:label>
    <form:input path="nazwa" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="nazwa" element="label" cssClass="control-label help-block"/>
    <p/>
</div>
<div class="form-group">
    <for:label path="numerSeryjny">Numer seryjny</for:label>
    <form:input path="numerSeryjny" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="numerSeryjny" element="label" cssClass="control-label help-block"/>
    <p/>
</div>


<button type="submit" class="btn btn-default">Submit</button>