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
			<c:if test="${ success != null }">
				<div class="alert alert-success text-center" role="alert">
					Opération effectuée avec succés !
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			<h1>Déclarations
				<a href="/addDeclaration" class="btn btn-primary bt-sm pull-right">Ajouter</a>
			</h1>
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="/home">Dashboard</a></li>
						<li class="active">Declarations</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Habitations Individuelles</h3>
						</div>
						<!-- <div class="panel-body">
							<p>...</p>
						</div> -->
						<table id="example" class="table table striped">
							<tr>
								<th>Code</th>
								<th>Proprietaire</th>
								<th>Adresse</th>
								<th class="text-center">surface</th>
								<th class="text-center">NbrPieces</th>
								<th class="text-center">Piscine</th>
								<th class="text-center">Update</th>
								<th class="text-center">Delete</th>
							</tr>
							<c:forEach items="${listeHabitIndivs}" var="myHabitIndiv">
								<tr>
									<td>${myHabitIndiv.codeHabitation}</td>
									<td>${myHabitIndiv.proprietaire}</td>
									<td>${myHabitIndiv.adresse}</td>
									<td class="text-center">${myHabitIndiv.surface}</td>
									<td class="text-center">${myHabitIndiv.nbrPiece}</td>
									<td class="text-center">${myHabitIndiv.piscine}</td>
									<td class="text-center">
										<a href="/editHabitation?code=<c:out value="${myHabitIndiv.codeHabitation}"/>&success">
										<img src="images/pencil-small.png" /></a>
									</td>
									<td class="text-center">
										<a onclick="return confirm('Etes vous sure de vouloir supprimer?')"
										href="/deleteHabitation?code=<c:out value="${myHabitIndiv.codeHabitation}"/>&success">
										<img src="images/delete.png" /></a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Habitations Professionnelles</h3>
						</div>
						<!-- <div class="panel-body">
							<p>...</p>
						</div> -->
						<table class="table table striped">
							<tr>
								<th>Code</th>
								<th>Proprietaire</th>
								<th>Adresse</th>
								<th class="text-center">surface</th>
								<th class="text-center">nbrEmploye</th>
								<th class="text-center">Update</th>
								<th class="text-center">Delete</th>
							</tr>
							<c:forEach items="${listeHabitPros}" var="myHabitPro">
								<tr>
									<td>${myHabitPro.codeHabitation}</td>
									<td>${myHabitPro.proprietaire}</td>
									<td>${myHabitPro.adresse}</td>
									<td class="text-center">${myHabitPro.surface}</td>
									<td class="text-center">${myHabitPro.nbrEmploye}</td>
									<td class="text-center">
										<a href="/editHabitation?code=<c:out value="${myHabitPro.codeHabitation}"/>&success">
										<img src="images/pencil-small.png" /></a>
									</td>
									<td class="text-center">
										<a onclick="return confirm('Etes vous sure de vouloir supprimer?')"
										href="/deleteHabitation?code=<c:out value="${myHabitPro.codeHabitation}"/>&success">
										<img src="images/delete.png" /></a>
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