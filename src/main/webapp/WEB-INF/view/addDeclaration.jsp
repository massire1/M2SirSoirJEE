<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisie déclaration</title>
</head>
<body>
	<%@include file="decorator/header.jsp"%>
	<div class="container col-md-12">
		<div class="col-md-3">
			<%@ include file="decorator/left.jsp"%>
		</div>
		<div class="col-md-9">
			<h1>Creer déclaration Impots</h1>
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="/home">Dashboard</a></li>
						<li><a href="/listDeclarations">Declarations</a></li>
						<li class="active">Nouveau</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form:form autocomplete="off" action="/registration" method="post" modelAttribute="user">
						<div class="form-group row align-items-center">
							<label for="colFormLabelSm"
								class="col-sm-4 col-form-label col-form-label-sm">Name</label>
							<div class="col-sm-8">
								<form:input path="name" placeholder="Name" class="form-control" />
								<small class="form-text text-danger"> 
									<form:errors path="name" />
								</small>
							</div>
						</div>
						<div class="form-group row align-items-center">
							<label for="colFormLabelSm"
								class="col-sm-4 col-form-label col-form-label-sm">Last
								Name</label>
							<div class="col-sm-8">
								<form:input path="lastName" placeholder="Last Name"
									class="form-control" />
								<small class="form-text text-danger"> <form:errors path="lastName" />
								</small>
							</div>
						</div>
						<div class="form-group row align-items-center">
							<label for="colFormLabelSm"
								class="col-sm-4 col-form-label col-form-label-sm">Email</label>
							<div class="col-sm-8">
								<form:input path="email" placeholder="Email"
									class="form-control is-invalid" />
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
								<button type="submit" class="btn btn-primary btn-block">Register
									User</button>
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
			<div class="row">
				<div class="col-md-12">
					<div>Basic panel example</div>
					<div>
						<a href="/listDeclarations" class="btn btn-primary">Retour</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>