<c:set var="page" value="5"/>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="styles/loans/new.css">

    <!-- START: Main Content-->
    <main>
            <div class="container-fluid">
                <!-- START: Breadcrumbs-->
                <div class="row ">
                    <div class="col-12  align-self-center">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                            <div class="w-sm-100 mr-auto"><h4 class="mb-0">Enregistrement d'un Emprunt</h4></div>
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
                                        <div class="col-7">
                                            <form class="row needs-validation" name="addLoan" onsubmit="return false;">
                                                <div class="col-md-6 mb-3">
                                                    <label for="title">Document <span class="text-danger">*</span></label>
                                                    <select onchange="onDocumentChange(this.value)" class="form-control" name="document" id="document" required>
                                                    	<option value="" disabled hidden selected>Document cible</option>
                                                    	<c:forEach var="document" items="${documentsList}">
															<option value="<c:out value='${document.id}' />"><c:out value="${document.titre}" /></option>
														</c:forEach>
                                                    </select>
                                                    <div class="invalid-tooltip" id="document-error">Le document est requis !</div>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label for="copy">Exemplaire <span class="text-danger">*</span></label>
                                                    <select class="form-control" name="copy" id="copy" required>
                                                    	<option value="" disabled hidden selected>Exemplaire à préter</option>
                                                    </select>
                                                    <div class="invalid-tooltip" id="copy-error">L'exemplaire est requis !</div>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label for="customer">Emprunteur <span class="text-danger">*</span></label>
                                                    <select class="form-control" name="customer" id="customer" onchange="onCustomerChange(this.value)" required>
                                                    	<option value="" disabled hidden selected>Client désirant emprunter le document</option>
                                                    </select>
                                                    <div class="invalid-tooltip" id="copy-error">Le client est requis</div>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label for="edition">Date de restitution <span class="text-danger">*</span></label>
                                                    <input type="datetime-local" class="form-control" name="date" id="date" required>
                                                    <div class="invalid-tooltip" id="date-error">La date est requise !</div>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label for="prochNames">Noms du proche <span class="text-danger">*</span></label>
                                                    <input type="text" class="form-control" placeholder="CNI du proche" name="prochNames" id="prochNames" required>
                                                    <div class="invalid-tooltip" id="prochNames-error">Le nom d'un proche est requis !</div>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label for="prochCni">CNI du proche <span class="text-danger">*</span></label>
                                                    <input type="text" class="form-control" placeholder="Nom d'un proche" name="prochCni" id="prochCni" required>
                                                    <div class="invalid-tooltip" id="prochCni-error">La CNI d'un proche est requise !</div>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label for="prochPhone">Téléphone du proche <span class="text-danger">*</span></label>
                                                    <input type="text" class="form-control" placeholder="Téléphone du proche" name="prochPhone" id="prochPhone" required>
                                                    <div class="invalid-tooltip" id="prochPhone-error">Le numéro de téléphone d'un proche est requis !</div>
                                                </div>
                                            
                                                <div class="col-md-12">
                                                    <button id="submitButton" class="btn btn-primary" type="submit" onclick="onSubmit()">Enregistrer</button>
                                               		<svg class="spinner" id="loader" width="25px" height="25px" viewBox="0 0 66 66" xmlns="http://www.w3.org/2000/svg">
													   <circle class="path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
													</svg>
                                                </div>
                                            </form>
                                        </div>
                                        
                                        <div class="col-5">
                                            <label for="document-cover mb-2">-</label>
                                            <div class="image-content">
                                                <img id="document-cover" height="290px" src="public/images/book.jfif"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END: Card DATA-->
            </div>
        </main>
        <!-- END: Content-->
        <script src="scripts/loans/new.js"></script>
        <script>
	        let temp = JSON.parse('${jsonCustomersList}');
	    	let temp2 = JSON.parse('${jsonDocumentsList}');
	    	let temp3 = JSON.parse('${jsonCopiesList}');
	    	let temp4 = JSON.parse('${jsonLoansList}');
	    	syncData(temp, temp2, temp3, temp4);
        </script>
<%@ include file="../footer.jsp" %>