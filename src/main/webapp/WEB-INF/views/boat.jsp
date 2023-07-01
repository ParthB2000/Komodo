<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Boat</title>
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/css/parsley.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath }/resources/js/sweetalert.min.js" type="text/javascript"></script>
  <%-- <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet"> --%>
</head>
<body>

<jsp:include page="header.jsp" />

<div class="container-fluid">
	<div class="row" style="background-image: linear-gradient(to right, #3a70b4, violet);">
	
		<jsp:include page="sidebar.jsp" />
		
		<div class="col-md-9 col-lg-10 content">
			
			<section class=" bg-image" style="">
    			<div class="mask d-flex align-items-center h-100 gradient-custom-3">
      				<div class="container h-100">
        				<div class="row d-flex justify-content-center align-items-center h-100">
          					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
            					<div class="card" style="border-radius: 15px; margin-top: 30%;">
              						<div class="card-body p-5">
                						<h4 class="text-uppercase text-center mb-5"><b>Add Boat</b></h4>
                							<form method="post" action="${pageContext.request.contextPath}/add/boat" id="signupForm" name="addEmp">
                  								<div class="form-outline mb-3">
                    								<label class="form-label" for="form3Example1cg"><b>Boat Name</b></label> <input type="text" id="boatName" data-parsley-required-message="Enter First Name" placeholder="Enter Boat Name" name="name" class="form-control form-control-lg" required>
                  								</div>
                  
								                <div class="form-outline mb-3">
								                    <label for="boatSize"><b>Boat Size</b></label><br>
								                    <input type="radio" id="small" name="size" data-parsley-required-message="Select Boat Size" value="small" required=""> <label for="small">Small &nbsp;</label> <input type="radio" id="medium" name="size" value="medium"> <label for="medium">Medium &nbsp;</label> <input type="radio" id="large" name="size" value="large"> <label for="large">Large &nbsp;</label>
								                </div>
                  
                  								<div class="form-outline mb-3">
                    								<label class="form-label" for="form3Example1cg"><b>Boat Capacity</b></label> <input type="number" id="capacity" placeholder="Enter Boat Capacity" name="capacity" data-parsley-required-message="Enter Boat Capacity" data-parsley-pattern-message="Enter valid Email" class="form-control form-control-lg" required>
                  								</div>
                  
                  								<span>
                  									<c:if test = "${not empty successMessage}">
         												<p style="color: green;">${successMessage}<p>
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