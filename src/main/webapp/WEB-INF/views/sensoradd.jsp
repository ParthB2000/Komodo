<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sensor</title>
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/css/parsley.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	
<div class="container-fluid">
	<div class="row" style="background-image: linear-gradient(to right, #3a70b4, violet);">
	
		<jsp:include page="sidebar.jsp" />
		
		<div class="col-md-9 col-lg-10 content">
		
			<section class=" bg-image">
    			<div class="mask d-flex align-items-center h-100 gradient-custom-3">
      				<div class="container h-100">
        				<div class="row d-flex justify-content-center align-items-center h-100">
          					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
            					<div class="card" style="border-radius: 15px; margin-top: 15%;">
              						<div class="card-body p-5">
                						<h4 class="text-uppercase text-center mb-5"><b>Add Sensor</b></h4>
                						<form method="post" action="${pageContext.request.contextPath}/add/sensor" id="signupForm" name="addEmp">
                  							
                  							<input type="hidden" id="id" name="id" value="${id }">
                  							<div class="form-outline mb-3">
                    							<label class="form-label" for="form3Example1cg"><b>Sensor Name</b></label> <input type="text" id="name" data-parsley-required-message="Enter Sensor Name" placeholder="Enter Sensor Name" name="sensorName" class="form-control form-control-lg" required>
                  							</div>
                  							
                  							<div class="form-outline mb-3">
                    							<label class="form-label" for="form3Example1cg"><b>Pressure</b></label> <input type="text" id="pressure" data-parsley-required-message="Enter Pressure" placeholder="Enter Pressure" name="pressure" class="form-control form-control-lg" required>
                  							</div>
                  
                  							<div class="form-outline mb-3">
                    							<label class="form-label" for="form3Example1cg"><b>Humidity</b></label> <input type="text" id="humidity" placeholder="Enter Humidity" name="humidity" data-parsley-required-message="Enter Humidity"  class="form-control form-control-lg" required>
                  							</div>
                  
                  							<div class="form-outline mb-3">
                    							<label class="form-label" for="form3Example1cg"><b>Temperature</b></label> <input type="text" id="temp" placeholder="Enter Temperature" name="temperature" data-parsley-required-message="Enter Temperature"  class="form-control form-control-lg" required>
                  							</div>
                  
                  							<div class="form-outline mb-3">
												<label for="tempUnit"><b>Temperature Unit</b></label><br>
												<input type="radio" id="celsius" name="unit" data-parsley-required-message="Select Temperature Unit" value="celsius" required=""> <label for="celsius">Celsius &nbsp;</label> <input type="radio" id="kelvin" name="unit" value="kelvin"> <label for="kelvin">Kelvin &nbsp;</label> 
				  							</div>
                  
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
												<span>
												 	<c:if test = "${not empty alreadyUsed}">
								         				<p style="color: red;">${alreadyUsed}<p>
								      			  	</c:if>
												</span>
                  
                  							<div class="d-flex justify-content-center">
                    							<input id="submitSignup" style="width:100%; color: white; background-image: linear-gradient(to right, #3a70b4, violet);" type="submit" value="Submit" class="btn btn-block btn-lg gradient-custom-4">
                  							</div>
                						</form>
              						</div>
            					</div>
          					</div>
        				</div>
      				</div>
    			</div>
  			</section>
		</div>
	</div>
</div>
	
	<jsp:include page="footer.jsp" /> 
	
<script src="${pageContext.request.contextPath }/resources/js/jquery.min.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath }/resources/js/parsley.min.js" type="text/javascript"></script> 
  
  <script type="text/javascript">

  		$(document).ready(function()
  		  		{
      				$('form').parsley();
  				});
  </script>
</body>
</html>