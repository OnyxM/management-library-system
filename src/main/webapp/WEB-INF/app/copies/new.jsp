<c:set var="page" value="2"/>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="styles/copies/new.css">

    <!-- START: Main Content-->
    <main>
            <div class="container-fluid">
                <!-- START: Breadcrumbs-->
                <div class="row ">
                    <div class="col-12  align-self-center">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                            <div class="w-sm-100 mr-auto"><h4 class="mb-0">Enregistrement d'exemplaire</h4></div>
                        </div>
                    </div>
                </div>
                <!-- END: Breadcrumbs-->

                <!-- START: Card Data-->
                <div class="row">
                    <div class="col-12 mt-4">
                        <div class="card">
                            <div class="card-content">
                                <div class="card-body">
                                	<div class="row">
                                		<form class="col-md-6 mb-3 needs-validation" name="selectDocument" onsubmit="return false;">
                                            <label for="names">Créer à partir</label>
                                            <select class="form-control" id="select-document" required>
                                            	<option value="" disabled hidden selected>Document cible</option>
                                            	<c:forEach var="document" items="${documentsList}">
													<option value="<c:out value='${document.id}' />"><c:out value="${document.titre}" /></option>
												</c:forEach>
                                            </select>
                                            <div class="invalid-tooltip" >Veuillez choisir document !</div>
                                        </form>
                                        <div class="col-md-6 mb-3">
                                        	<label for="names">Nombre d'exemplaires</label>
                                            <div class="add form-control">
                                            	<div onclick="decreaseCount()" class="minus cursor-pointer bg-danger">-</div>
                                            	<div class="count" id="count-value">1</div>
                                            	<div onclick="increaseCount()" class="plus cursor-pointer bg-success">+</div>
                                            </div>
                                        </div>
                                	</div>
                                    <form class="needs-validation" name="addCopy" onsubmit="return false;">
                                        <div class="row" id="copiesInputs"></div>
                                        <div class="row">
                                            <div class="col-md-12">
                                            	<button id="submitButton" class="btn btn-primary" type="submit" onclick="onSubmit()">Enregistrer</button>
	                                       		<svg class="spinner" id="loader" width="25px" height="25px" viewBox="0 0 66 66" xmlns="http://www.w3.org/2000/svg">
												   <circle class="path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
												</svg>
                                            </div>
                                         </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END: Card DATA-->
            </div>
        </main>
        <!-- END: Content-->
        <script src="scripts/copies/new.js"></script>
<%@ include file="../footer.jsp" %>