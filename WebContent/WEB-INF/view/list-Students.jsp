<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <title>Student Tracker</title>
    
  </head>
	<body>
	 <div class="container">
		<div id="wrapper">
			<div id="header">
				<h2> Student Tracking Service</h2>
				
			</div>
		</div>
		<div class="table" id="tableDiv">
		
		<!-- add new student -->
		<input type="button" 
			value="Add Student"
			 class="add-button" 
			 onclick="window.location.href='showFormForAdd'; return false;" />
		
			<div id="content">
				<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				
				</tr>
				
				<c:forEach var="tempStudent" items="${students}">
				
					<!-- construct an 'update' link with student id -->
					<c:url var="updateLink" value="/student/showFormForUpdate">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					
					<!-- construct an 'delete' link with student id -->
						<c:url var="deleteLink" value="/student/delete">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					<tr>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName } </td>
						<td> ${tempStudent.email }    </td>
						<td>
							<a href="${updateLink}">Update</a> 
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this student ?'))) return false">Delete</a></td>
					</tr>
				
				</c:forEach>
				</table>
			
			</div>
		</div>
	 </div>	
	</body>

</html>