<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boat List</title>
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
    				<h2 style="text-align: center; margin-top: 1%">List Of Users With Number Of Boats</h2>
    					<span>
   							<c:if test = "${not empty errorBoatList}">
         						<p style="color: red;">${errorBoatList}<p>
    						</c:if>
   						</span>
   						<span>
   							<c:if test = "${not empty successfullyAdded}">
         						<p style="color: green;">${successfullyAdded}<p>
    						</c:if>
   						</span>
   						<span>
						 	<c:if test = "${not empty successMessage}">
		         				<p style="color: green;">${successMessage}<p>
		      			  	</c:if>
						</span>
        			<table class="table table-bordered table-success mt-3">
						<thead>
			
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Number Of Boats</th>
								<th>Blocked</th>
							</tr>
				
						</thead>
						<tbody>
			 				<c:forEach items="${boatsWithUsers}" var="boat" >
								<tr>
									<td>${boat.id}</td>
									<td>${boat.firstName}</td>
									<td>${boat.lastName}</td>
									<td>${boat.email}</td>
								    <td>${boat.numberOfBoats }</td> 
									<td>
					 					<c:choose>
  											<c:when test="${boat.isBlocked}">
  												Yes
  											</c:when>
  							
  											<c:otherwise>
  												No
  											</c:otherwise>
										</c:choose>
									</td>
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