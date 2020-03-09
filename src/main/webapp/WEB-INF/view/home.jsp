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
			<div class="list-group">
				<a href="#" class="list-group-item disabled">Menu principal</a> 
				<a href="addProduits" class="list-group-item">Saisie Produit</a>
				<a href="listProduits" class="list-group-item">Liste Produit</a></li>
				<a href="#" class="list-group-item">Dapibus ac facilisis in</a> 
				<a href="#" class="list-group-item">Morbi leo risus</a> 
				<a href="#" class="list-group-item">Porta ac consectetur ac</a> 
				<a href="#" class="list-group-item">Vestibulum at eros</a>
			</div>
		</div>
		<div class="col-md-9">
			<div class="jumbotron">
				<h1>Hello, world!</h1>
				<p>...</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Learn
						more</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>