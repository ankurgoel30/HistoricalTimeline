<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Your events are</caption>
			<thead>
				<tr>
					<th>Title</th>
					<th>Date</th>
					<th>Description</th>
					<th>Image Link</th>
					<!--  
					<th></th>
					<th></th>
					-->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${events}" var="event">
					<tr>
						<td>${event.title}</td>
						<td><fmt:formatDate value="${event.date}" pattern="dd/MM/yyyy"/></td>
						<td>${event.description}</td>
						<td><a href="${event.imageLink}">Image Link</a></td>
						<!--
						<td><a type="button" class="btn btn-success" href="/update-todo?id=${event.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${event.id}">Delete</a></td>
					   -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-event">Add a Event</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>