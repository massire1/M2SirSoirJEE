<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration Form</title>
</head>
<body>
	<%@include file="decorator/header.jsp"%>
	<form:form action="/" method="get">
	</form:form>

	<div class="container col-md-6 col-md-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading">Page d'inscription</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12">
						<form:form autocomplete="off"  action="/registration"  method="post" modelAttribute="user">
							<div class="form-group row align-items-center">
						    	<div class="col-sm-12 text-center">
						    		<h2>Formulaire d'inscription</h2>
						    	</div>
						  	</div>
							<div class="form-group row align-items-center">
						    	<label for="colFormLabelSm" class="col-sm-4 col-form-label col-form-label-sm">Name</label>
						    	<div class="col-sm-8">
						     		<form:input path="name"  placeholder="Name" class="form-control" />
						     		<small class="form-text text-danger">
										<form:errors path="name" />
									</small>
						    	</div>
						  	</div>
						  	<div class="form-group row align-items-center">
						    	<label for="colFormLabelSm" class="col-sm-4 col-form-label col-form-label-sm">Last Name</label>
						    	<div class="col-sm-8">
									<form:input path="lastName" placeholder="Last Name" class="form-control" /> 
									<small class="form-text text-danger">
										<form:errors path="lastName" />
									</small>
								</div>
						  	</div>
						  	<div class="form-group row align-items-center">
						    	<label for="colFormLabelSm" class="col-sm-4 col-form-label col-form-label-sm">Email</label>
						    	<div class="col-sm-8">
									<form:input path="email" placeholder="Email" class="form-control is-invalid" />
									<small class="form-text text-danger">
										<form:errors path="email" />
									</small>
								</div>
						  	</div>
						  	<div class="form-group row align-items-center">
						    	<label for="colFormLabelSm" class="col-sm-4 col-form-label col-form-label-sm">Password</label>
						    	<div class="col-sm-8">
									<form:input path="password" type="password" placeholder="Password" class="form-control" />
									<small class="form-text text-danger">
										<form:errors path="password" />
									</small>
						    	</div>
						  	</div>
							<div class="form-group row align-items-center">
								<div class="col-sm-4 col-sm-offset-4">
									<button type="submit" class="btn btn-primary btn-block">Register User</button>
								</div>
							</div>
							<!-- <div class="form-group row align-items-center">
								<div class="col-sm-12 text-right">
									<a href="/" class="btn btn-md btn-warning">Retour</a>
								</div>
							</div> -->
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<p class="col-md-6">
				<a href="/" th:href="@{/}">Back to home page</a>
			</p>
		</div>
	</div>

</body>
</html>