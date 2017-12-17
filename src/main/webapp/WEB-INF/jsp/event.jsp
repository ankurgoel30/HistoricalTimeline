<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" modelAttribute="event" action="add-event">
		
		<fieldset class="form-group">
			<form:label path="title">Title</form:label>
			<form:input path="title" type="text" class="form-control" required="required" />
			<form:errors path="title" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="date">Event Date</form:label>
			<form:input path="date" type="text" class="form-control" required="required" />
			<form:errors path="date" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="description">Description</form:label>
			<form:textarea path="description" type="textbox" class="form-control" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="imageLink">Image Link</form:label>
			<form:input path="imageLink" type="text" class="form-control" />
			<form:errors path="imageLink" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>