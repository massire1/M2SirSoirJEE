<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'accueil</title>
</head>
<body>
	<%@include file="decorator/header.jsp"%>
	<div class="container col-md-12">
		<div class="col-md-3">
			<%@ include file="decorator/left.jsp"%>
		</div>
		<div class="col-md-9">
			<div class="jumbotron">
				<h1>Welcome, dashboard!</h1>
				<p>...</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>