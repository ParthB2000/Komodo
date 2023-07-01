<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sensor List</title>
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/css/parsley.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath }/resources/js/sweetalert.min.js" type="text/javascript"></script>
  
  <style type="text/css">
  	.content {
      padding: 20px;
    }
  </style>
</head>
<body>
<jsp:include page="header.jsp" />
		<div class="container-fluid">
			<div class="row" style="background-color: aliceblue;">
					<jsp:include page="sidebar.jsp" />
    			<div class="col-md-9 col-lg-10 content">
    				<h2 style="text-align: center; margin-top: 1%">List Of Sensors With Boat Details</h2>
    		
    				<div class="dropdown">
  						<button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
    						Pressure Filter
		  						</button>
		  				<ul class="dropdown-menu">
		  					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/sensor/list">All</a></li>
		    				<li><a class="dropdown-item" href="${pageContext.request.contextPath}/sensor/list/above119">Above 119</a></li>
		  				</ul>
					</div>
    		
			    		<span>
			   				<c:if test = "${not empty sensorErrorMessage}">
			         			<p style="color: red;">${sensorErrorMessage}<p>
			    			</c:if>
			   			</span>
			   			
        			<table class="table table-bordered table-success mt-3">
						<thead>
			
							<tr>
								<th>Id</th>
								<th>Sensor Name</th>
								<th>Temperature</th>
								<th>Temperature Unit</th>
								<th>Pressure</th>
								<th>Humidity</th> 
								<th>Boat Name</th>
								<th>Boat Size</th>
								<th>Boat Capacity</th>
							</tr>
				
						</thead>
						<tbody>
			 				<c:forEach items="${sensorListWithBoat}" var="sensor" >
								<tr>
									<td>${sensor.id}</td>
									<td>${sensor.name}</td>
									<td>${sensor.temperature}</td>
									<td>${sensor.temperatureUnit}</td>
								    <td>${sensor.pressure }</td> 
									<td>${sensor.humidity}</td> 
									<td>${sensor.boatName}</td>
									<td>${sensor.size}</td>
									<td>${sensor.capacity}</td>
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