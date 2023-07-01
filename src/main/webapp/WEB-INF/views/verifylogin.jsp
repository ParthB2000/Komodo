<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login :: Verify</title>
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
              					<h4 class="text-uppercase text-center mb-5"><b>Verify User</b></h4>

              					<form id="loginForm" method="post" action="${pageContext.request.contextPath}/login/verify">
              
               						<input type="hidden" id="id" name="id" value="${idLogin }"> 

					                <div class="form-outline mb-2">
					                  <label class="form-label" for="form3Example3cg"><b> Otp </b></label>
					                  <input type="text" name="otp" id="otp" value="${otpLogin }" placeholder="Type your Otp" data-parsley-required-message="Enter Otp" class="form-control form-control-lg" required/>
					                </div>
                
						                <span>
						   					<c:if test = "${not empty errorLogin}">
						         				<p style="color: red;">${errorLogin}<p>
						    				</c:if>
						   				</span>
						  				<span>
						   					<c:if test = "${not empty successLogin}">
						         				<p style="color: green;">${successLogin}<p>
						    				</c:if>
						   				</span>
						   				<span>
				       						<c:if test = "${not empty successMsgLoginEmail}">
				         						<p style="color: green;">${successMsgLoginEmail}<p>
				      						</c:if>
				  						</span>

					                <div class="d-flex justify-content-center">
					                    <input  id="submitAd" style="width:100%; color: white; background-image: linear-gradient(to right, #3a70b4, violet); "  type="submit" value="Verify" class="btn  btn-block btn-lg gradient-custom-4 ">
					                </div>
			
              					</form>
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