<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boat List With User Details</title>
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/css/parsley.min.css" rel="stylesheet">
   <script src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle(5.2.3).min.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
		<div class="container-fluid">
			<div class="row" style="background-color: aliceblue;">
				<jsp:include page="sidebar.jsp" />
    			<div class="col-md-9 col-lg-10 content">
    				<h2 style="text-align: center; margin-top: 1%">List Of Boat With Basic Details Of User</h2>
    		
			    		<span>
			   				<c:if test = "${not empty errorBoatUserList}">
			         			<p style="color: red;">${errorBoatUserList}<p>
			    			</c:if>
			   			</span>
			   			<span>
						 	<c:if test = "${not empty alreadyUsed}">
		         				<p style="color: red;">${alreadyUsed}<p>
		      			  	</c:if>
						</span>
						<span>
   							<c:if test = "${not empty successfullyAdded}">
         						<p style="color: green;">${successfullyAdded}<p>
    						</c:if>
   						</span>
   						
  					<div class="dropdown">
  						<button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
    						Sensor Filter
  						</button>
		  				<ul class="dropdown-menu">
		    				<li><a class="dropdown-item" href="${pageContext.request.contextPath}/boat/list">All</a></li>
		    				<li><a class="dropdown-item" href="${pageContext.request.contextPath}/boat/list/with/sensor">With Sensor</a></li>
		    				<li><a class="dropdown-item" href="${pageContext.request.contextPath}/boat/list/without/sensor">Without Sensor</a></li>
		  				</ul>
					</div>
			   			
        			<table class="table table-bordered table-success mt-3">
						<thead>
			
							<tr>
								<th>Id</th>
								<th>Boat Name</th>
								<th>Boat Size</th>
								<th>Boat Capacity</th> 
								<th>Owner Name</th>
								<th>Owner Email</th>
								<th>Has Sensor</th> 
								<th>Add Sensor</th>
							</tr>
				
						</thead>
						<tbody>
							<c:forEach items="${boatsListWithUser}" var="boat" >
								<tr>
									<td>${boat.id}</td>
									<td>${boat.name}</td>
									<td>${boat.size}</td>
									<td>${boat.capacity}</td>
									<td>${boat.firstName } ${boat.lastName }</td>
									<td>${boat.email }</td>
									<td>
					 					<c:choose>
  											<c:when test="${boat.hasSensor}">
  												Yes
  											</c:when>
  							
  											<c:otherwise>
  												No
  											</c:otherwise>
										</c:choose> 
									</td>
									<td>
										<a href="${pageContext.request.contextPath}/add/sensor?id=${boat.id}">
											<button id="boatId" value="${boat.id }" class="btn btn-primary">Add Sensor</button>
										</a>
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