<c:set var="page" value="2"/>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="styles/documents/new.css">

    <!-- START: Main Content-->
    <main>
            <div class="container-fluid">
                <!-- START: Breadcrumbs-->
                <div class="row ">
                    <div class="col-12  align-self-center">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                            <div class="w-sm-100 mr-auto"><h4 class="mb-0">Enregistrement d'un Client</h4></div>
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
                                    <form class="row needs-validation" name="addCustomer" onsubmit="return false;">
                                        <div class="col-6">
                                        	<div class="col-md-12 mb-3">
                                                <label for="names">Créer à partir</label>
                                                <select class="form-control" onchange="onCustomerTypeChange(this.value)">
                                                	<option value="1" selected>D'un étudiant</option>
                                                	<option value="2">Autre</option>
                                                </select>
                                            </div>
                                            <div class="col-md-12 mb-3">
                                                <label for="names">Noms <span class="text-danger">*</span></label>
                                                <input type="text" class="form-control" id="names" name="names" placeholder="Noms et prénoms du client" maxlength="60" required>
                                                <div class="invalid-tooltip" id="names-error"></div>
                                            </div>
                                            <div class="col-md-12 mb-3">
                                                <label for="identifiant" id="identifiant-label">Matricule <span class="text-danger">*</span></label>
                                                <input type="text" class="form-control" id="identifiant" name="identifiant" placeholder="Matricule de l'étudiant" maxlength="30" required>
                                                <div class="invalid-tooltip" id="identifiant-error"></div>
                                            </div>
                                            <div class="col-md-12 mb-3">
                                                <label for="phone">Téléphone <span class="text-danger">*</span></label>
                                                <input type="text" class="form-control" name="phone" id="phone" placeholder="Numéro de téléphone du client" maxlength="20" required>
                                                <div class="invalid-tooltip" id="phone-error"></div>
                                            </div>
                                            <div class="col-md-12 mb-3">
                                                <label for="address">Adresse</label>
                                                <input type="text" class="form-control" name="address" id="address" placeholder="Adresse du client" maxlength="255">
                                                <div class="invalid-tooltip" id="address-error"></div>
                                            </div>
                                        
                                            <div class="col-md-12">
                                                <button id="submitButton" class="btn btn-primary" type="submit" onclick="onSubmit()">Enregistrer</button>
                                           		<svg class="spinner" id="loader" width="25px" height="25px" viewBox="0 0 66 66" xmlns="http://www.w3.org/2000/svg">
												   <circle class="path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
												</svg>
                                            </div>
                                        </div>
                                        
                                    
	                                     <div class="col-6">
	                                         <div class="col-md-12 mb-3">
	                                              <label for="proch-names">Noms Proche</label>
	                                              <input type="text" class="form-control" id="proch-names" name="prochNames" placeholder="Noms et prénoms d'un proche" maxlength="60">
	                                              <div class="invalid-tooltip" id="proch-names-error"></div>
	                                          </div>
	                                          <div class="col-md-12 mb-3">
	                                              <label for="proch-cni">CNI proche</label>
	                                              <input type="text" class="form-control" name="prochCni" id="proch-cni" placeholder="CNI du proche" maxlength="30">
	                                              <div class="invalid-tooltip" id="proch-cni-error"></div>
	                                          </div>
	                                          <div class="col-md-12 mb-3">
	                                              <label for="proch-phone">Téléphone proche</label>
	                                              <input type="text" class="form-control" name="proch-phone" id="prochPhone" placeholder="Numéro de téléphone du proche" maxlength="20">
	                                              <div class="invalid-tooltip" id="proch-phone-error"></div>
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
        <script src="scripts/customers/new.js"></script>
<%@ include file="../footer.jsp" %>