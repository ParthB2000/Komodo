<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Disable Users</title>
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/css/parsley.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath }/resources/js/sweetalert.min.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
		<div class="container-fluid">
			<div class="row" style="background-color: aliceblue;">
					<jsp:include page="sidebar.jsp" />
    			<div class="col-md-9 col-lg-10 content">
    				<h2 style="text-align: center; margin-top: 1%">List Of Disable Users</h2>
			    		<span>
			   				<c:if test = "${not empty errorMessage}">
			         			<p style="color: red;">${errorMessage}<p>
			    			</c:if>
			   			</span>
        			<table class="table table-bordered table-success mt-3">
						<thead>
			
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
					
							</tr>
				
						</thead>
						<tbody>
			 				<c:forEach items="${userList}" var="list" >
								<tr>
									<td>${list.id}</td>
									<td>${list.firstName}</td>
									<td>${list.lastName}</td>
									<td>${list.email}</td>
								    
								</tr>
							</c:forEach> 
						</tbody>
					</table>
      			</div>
    		</div>
    	</div>
    <jsp:include page="footer.jsp" /> 
</body>
</html>