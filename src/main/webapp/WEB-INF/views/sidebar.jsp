<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sidebar</title>
 <link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script> 
  <style>
    .sidebar {
      background-color: #212529;
      width: 200px;
      height: 93vh;
      padding: 20px;
      float: left;
    }
  </style>
</head>
<body>
	
  <div class="sidebar  col-md-3 col-lg-2">
    <h2 style="color: white;">User Dashboard</h2>
    <ul class="nav flex-column">
    
      <li class="nav-item">
        <a class="nav-link active" href="${pageContext.request.contextPath}/user/dashboard">Dashboard</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/add/boat">Add Boat</a>
      </li>
         
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/user/list">List Of User With No. Of Boats</a>
      </li>
         
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/boat/list">List Of Boat With User Detail</a>
      </li>
         
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/sensor/list">List Of Sensor With Boat Detail</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/user/users/disable">List Of Disabled Users By Admin</a>
      </li>
      
    </ul>
    <div style="margin-left: 5%; margin-top: 3%;">
	    <form method="post" action="${pageContext.request.contextPath}/logout">
	    	<button class="btn btn-danger">Logout</button>
	    </form>
    </div>
  </div>
  
  <!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script> -->
</body>
</html>