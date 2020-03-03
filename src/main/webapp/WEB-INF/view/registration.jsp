<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
	<title>Registration Form</title>
</head>
<body>
<%@include file="decorator/header.jsp" %>
	<form:form action="/" method="get">
		<button class="btn btn-md btn-warning btn-block" type="Submit">Retour à la Page de connexion</button>
	</form:form>	
	
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form:form autocomplete="off"  action="/registration"  method="post" modelAttribute="user">
					<h2>Registration Form</h2>
					<div class="form-group">
						<div class="col-sm-9">
						<form:input path="name"  placeholder="Name" class="form-control" /> 
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<form:input path="lastName" placeholder="Last Name" class="form-control" /> 
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<form:input path="email" placeholder="Email" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<form:input path="password" type="password" placeholder="Password" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<button type="submit" class="btn btn-primary btn-block">Register User</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>