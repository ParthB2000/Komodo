<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/css/parsley.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath }/resources/js/sweetalert.min.js" type="text/javascript"></script>
  <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
</head>
<body>

<section class="vh-100 bg-image">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
      <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-12 col-md-9 col-lg-7 col-xl-6">
            <div class="card" style="border-radius: 15px;">
              <div class="card-body p-5">
                <h4 class="text-uppercase text-center mb-5"><b>Registration</b></h4>
                <form method="post" action="${pageContext.request.contextPath}/signup/process" id="signupForm" name="addEmp">
                  	<div class="form-outline mb-3">
                    	<label class="form-label" for="form3Example1cg"><b>First Name</b></label> <input type="text" value="${firstName }" id="fname" data-parsley-required-message="Enter First Name" placeholder="Type your First Name" name="firstName" class="form-control form-control-lg" required>
                  	</div>
                  	<div class="form-outline mb-3">
                    	<label class="form-label" for="form3Example1cg"><b>Last Name</b></label> <input type="text" value="${lastName }" id="lname" data-parsley-required-message="Enter Last Name" placeholder="Type your Last Name" name="lastName" class="form-control form-control-lg" required>
                  	</div>
                  
                  	<div class="form-outline mb-3">
                    	<label class="form-label" for="form3Example1cg"><b>Email</b></label> <input type="text" value="${email }" id="email" placeholder="Type your Email" name="email" data-parsley-required-message="Enter Email" data-parsley-pattern-message="Enter valid Email" data-parsley-pattern="/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/" class="form-control form-control-lg" required>
                  	</div>
                  
						<span>
       						<c:if test = "${not empty successMsg}">
         						<p style="color: green;">${successMsg}<p>
      						</c:if>
  						</span>
	  					<span>
	       					<c:if test = "${not empty success}">
	         					<p style="color: green;">${success}<p>
	      					</c:if>
	  					</span>
	  					<span>
	       					<c:if test = "${not empty emailExist}">
	         					<p style="color: red;">${emailExist}<p>
	      					</c:if>
	  					</span>
  					                  
                  	<div class="d-flex justify-content-center">
                    	<input id="submitSignup" style="width:100%; color: white; background-image: linear-gradient(to right, #3a70b4, violet);" type="submit" value="Submit" class="btn btn-block btn-lg gradient-custom-4">
                  	</div>
                </form>
                	<a href="${pageContext.request.contextPath}/send/login/otp" style="color:white;"><button style="width: 100%; margin-bottom: 2%; margin-top: 2%" type="button" class="btn btn-secondary btn-block btn-lg gradient-custom-4">Login</button></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
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