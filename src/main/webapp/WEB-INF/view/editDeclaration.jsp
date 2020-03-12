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
			<h1>Modififer déclaration Impots</h1>
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="/home">Dashboard</a></li>
						<li><a href="/listDeclarations">Declarations</a></li>
						<li class="active">Modifier</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<c:if test="${ isHabitIndivBool == true }">
						<div class="alert alert-info text-center" role="alert">
							Ceçi est une habitation <strong>individuelle !</strong>
						</div>
					</c:if>
					<c:if test="${ isHabitIndivBool == false }">
						<div class="alert alert-warning text-center" role="alert">
							Ceçi est une habitation <strong>professionnelle !	</strong>
						</div>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<c:if test="${ isHabitIndivBool == true }">
						<%@include file="decorator/form-edit-habitIndiv.jsp"%>
					</c:if>
					<c:if test="${ isHabitIndivBool == false }">
						<%@include file="decorator/form-edit-habitPro.jsp"%>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>