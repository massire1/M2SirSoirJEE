<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>
	<%@include file="decorator/header.jsp"%>
	<p></p>
	<div class="container col-md-4 col-md-offset-4">
		<div class="panel panel-primary">
			<div class="panel-heading">Page de connexion</div>
			<div class="panel-body">
				<h1 class="text-center">Login page</h1>
				<form action="/home" method="post">
					<div class="form-group">
						<label for="username">Email</label>: <input type="text" id="email"
							name="email" class="form-control" autofocus="autofocus"
							placeholder="Email">
					</div>
					<div class="form-group">
						<label for="password">Password</label>: <input type="password"
							id="password" name="password" class="form-control"
							placeholder="Password">
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<input type="submit" name="login-submit" id="login-submit"
									class="form-control btn btn-info" value="Log In">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<c:if test="${ param.logout }">
									<div class="alert alert-success text-center" role="alert">
										Vous êtes maintenant <strong>déconnecté !</strong>
										<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:if>
								<c:if test="${ param.error }">
									<div class="alert alert-danger text-center" role="alert">
										Identifiants de connexion <strong>incorrects !</strong>
										<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="row">
			<!-- <p class="col-md-6">
				<a href="/" th:href="@{/}">Back to home page</a>
			</p> -->
			<p class="col-md-6 col-md-offset-6 text-right">
				<a href="/registration">S'inscrire</a>
			</p>
		</div>
	</div>
</body>
</html>