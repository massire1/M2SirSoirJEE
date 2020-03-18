<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form:form autocomplete="off" action="/saveHabitationPro" method="post" modelAttribute="habitation">
	<div class="form-group row align-items-center">
		<label for="colFormLabelSm" class="col-sm-3 col-form-label col-form-label-sm text-right">Code</label>
		<div class="col-sm-1">
			<form:input path="codeHabitation" class="form-control" disabled="disabled" readonly="true" />
		</div>
	</div>
	<div class="form-group row align-items-center">
		<label for="colFormLabelSm" class="col-sm-3 col-form-label col-form-label-sm text-right">Propriétaire</label>
		<div class="col-sm-4">
			<form:input path="proprietaire" class="form-control" />
		</div>
		<div class="col-sm-offset-3 col-sm-9"><small class="form-text text-danger"><form:errors path="proprietaire" /></small></div>
	</div>
	<div class="form-group row align-items-center">
		<label for="colFormLabelSm"
			class="col-sm-3 col-form-label col-form-label-sm text-right">Adresse</label>
		<div class="col-sm-6">
			<form:input path="adresse" class="form-control" />
		</div>
		<div class="col-sm-offset-3 col-sm-9"><small class="form-text text-danger"><form:errors path="adresse" /></small></div>
	</div>
	<div class="form-group row align-items-center">
		<label for="colFormLabelSm" class="col-sm-3 col-form-label col-form-label-sm text-right">Surface</label>
		<div class="col-sm-2">
			<form:input path="surface" class="form-control" />
		</div>
		<div class="col-sm-offset-3 col-sm-9"><small class="form-text text-danger"><form:errors path="surface" /></small></div>	
	</div>
	<div class="form-group row align-items-center">
			<label for="colFormLabelSm" class="col-sm-3 col-form-label col-form-label-sm text-right">Nombre Employés</label>
			<div class="col-sm-1">
				<form:input path="nbrEmploye" class="form-control" />
			</div>
			<div class="col-sm-offset-3 col-sm-9"><small class="form-text text-danger"><form:errors path="nbrEmploye" /></small></div>
	</div>
	<c:if test="${ not empty impotAPayer}">
		<div class="form-group row align-items-center">
			<label for="colFormLabelSm" class="col-sm-3 col-form-label col-form-label-sm text-right text-danger">Impot a payer</label>
			<div class="col-sm-9">
				<span class="label label-danger"><c:out value = "${impotAPayer}" /></span>  <span class="small">FCFA</span>
			</div>
		</div>
	</c:if>
	<div class="form-group row align-items-center">
		<div class="col-sm-4 col-sm-offset-3">
			<button type="submit" class="btn btn-warning">Enregistrer</button>
			<a href="/listDeclarations" class="btn btn-primary">Retour</a>
		</div>
	</div>
</form:form>