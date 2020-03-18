<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des déclarations</title>

<!-- <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script> -->
</head>
<body>
	<%@include file="decorator/header.jsp"%>
	<div class="container col-md-12">
		<div class="col-md-3">
			<%@ include file="decorator/left.jsp"%>
		</div>
		<div class="col-md-9">
			<c:if test="${ not empty param.successMessage}">
				<div class="alert alert-success text-center" role="alert">
					<c:out value = "${param.successMessage}" />
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			<h1>Déclarations
				<a href="/registration" class="btn btn-primary bt-sm pull-right">Ajouter</a>
			</h1>
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="/home">Dashboard</a></li>
						<li class="active">Utilisateurs</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">Gestion des Utilisateurs</h3>
						</div>
						<!-- <div class="panel-body">
							<p>...</p>
						</div> -->
						<table id="example" class="table table striped">
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Password</th>
								<th class="text-center">Active</th>
								<th class="text-center">Details</th>
							</tr>
							<c:forEach items="${users}" var="user">
								<tr>
									<td><strong>${user.id}</strong></td>
									<td>${user.name}</td>
									<td><strong>${user.lastName}</strong></td>
									<td><i>${user.email}</i></td>
									<td><i>${user.password}</i></td>
									<td class="text-center">${user.active}</td>
									<td class="text-center">
										<a href="#">
										<img src="images/pencil-small.png" /></a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>