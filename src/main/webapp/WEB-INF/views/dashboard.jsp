<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/parsley.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<style type="text/css">
  	.content 
  	{
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
	        		<h2>Welcome to the Dashboard </h2>
	        		<h4>${userName} ${userLastName}</h4>
	      		</div>
	    	</div>
    	
    	</div>
	<jsp:include page="footer.jsp" /> 
	
<script src="${pageContext.request.contextPath }/resources/js/jquery.min.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath }/resources/js/parsley.min.js" type="text/javascript"></script> 
</body>
</html>