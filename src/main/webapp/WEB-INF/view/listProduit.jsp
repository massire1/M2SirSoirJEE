<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste-Produit</title>
</head>
<body>
	<%@ include file="decorator/header.jsp" %>
	<div class="container col-md-10 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">Liste des Produits</div>
				<div class="panel-body">
					<form action="rechercher.mvc" method="get" >
						<label>Rechercher</label>
						<input type="text" name="designation" value="">
						<button type="submit" class="btn btn-success">Chercher</button>
					</form>
					<table class="table table striped">
						<tr>
							<th>Reference</th><th>Designation</th><th>Prix</th><th>Quantite</th><th>Update</th><th>Delete</th>
			            </tr>
						<c:forEach items="${produits}" var="myproduit">
							<tr>
								<td>${myproduit.reference}</td>
								<td>${myproduit.designation}</td>
								<td>${myproduit.prix}</td>
								<td>${myproduit.quantite}</td>
								<td><a href="editProduit.mvc?reference=<c:out value="${myproduit.reference}"/>"><img src="images/pencil-small.png" /></a></td>
								<td><a onclick="return confirm('Etes vous sure de vouloir supprimer?')" 
								href="deleteProduit.mvc?reference=<c:out value="${myproduit.reference}"/>"><img src="images/delete.png" /></a></td>
							</tr>
						</c:forEach>
					</table>
				<div sec:authorize="hasRole('ROLE_ADMIN')">This content is
					only shown to administrators.</div>

				<div sec:authorize="hasRole('ROLE_USER')">This content is only
					shown to users.</div>
				<c:out value="${userName}" />
			</div>
		</div>
	</div>
</body>
</html>