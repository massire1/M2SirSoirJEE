<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>
	<%@include file="decorator/header.jsp"%>
	<p></p>
	<div class="container col-md-6 col-md-offset-2">
		<c:if test="${ request[''] }">
			<div class="alert alert-secondary" role="alert">
				Vous etes maintenant deconnecté
			</div>
		</c:if>
		<div class="panel panel-primary">
			<div class="panel-heading">Page de connexion</div>
			<div class="panel-body">
				<h1>Login page</h1>
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
				</form>
			</div>
		</div>

		<p>
			<a href="/" th:href="@{/}">Back to home page</a>
		</p>

	</div>
</body>
</html>