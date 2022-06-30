<c:set var="page" value="5"/>
<%@ include file="../header.jsp" %>

    <!-- START: Main Content-->
    <main>
            <div class="container-fluid">
                <!-- START: Breadcrumbs-->
                <div class="row ">
                    <div class="col-9 align-self-center">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                            <div class="w-sm-100 mr-auto"><h4 class="mb-0">Liste des emprunts</h4></div>
                        </div>
                    </div>
                    <div class="col-3 align-self-center" align="right">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                        	<a href="loans/new" class="btn btn-info">Nouvel emprunt</a>
                        </div>
                    </div>
                </div>
                <!-- END: Breadcrumbs-->

                <!-- START: Card Data-->
                <div class="row">
                    <div class="col-12 mt-3">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table id="loansTableList" class="display table dataTable table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Client</th>
                                                <th>Exemplaire</th>
                                                <th>Document</th>
                                                <th>Date d'emprunt </th>
                                                <th>Date pev. rest. </th>
                                                <th>Date de rest </th>
                                                <th>Status </th>
                                                <th>Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody></tbody>
                                    </table>
                                </div>

                                <!-- Modal -->
                                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle1" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="loanDetails">Détails de l'emprunt</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
	                                            <div class="row">
	                                            	<div class="col-6">
	                                            		<img style="width: 100%; height: 100%" id="document-cover" src="public/images/book.jfif"/>
	                                            	</div>
	                                            	<div class="col-6">
		                                            	<div class="col-md-12 mb-3">
		                                                    <label class="text-bold">Document</label>
		                                                    <div id="document">dmasdm</div>
		                                                </div>
		                                                <div class="col-md-12 mb-3">
		                                                    <label class="text-bold">Exemplaire</label>
		                                                    <div id="copy">dmasdm</div>
		                                                </div>
		                                                <div class="col-md-12 mb-3">
		                                                    <label class="text-bold">Client</label>
		                                                    <div id="customer">dmasdm</div>
		                                                </div>
	                                            	</div>
	                                            </div>
	                                            <div class="row">
	                                            	<div class="col-md-6 mb-3">
	                                                    <label class="text-bold">Date d'emprunt</label>
	                                                    <div id="date1">dmasdm</div>
	                                                </div>
	                                                <div class="col-md-6 mb-3">
	                                                    <label class="text-bold">Date prévue de restitution</label>
	                                                    <div id="date2">dmasdm</div>
	                                                </div>
	                                                <div class="col-md-6 mb-3">
	                                                    <label class="text-bold">Date de restitution</label>
	                                                    <div id="date3">dmasdm</div>
	                                                </div>
	                                                <div class="col-md-6 mb-3">
	                                                    <label class="text-bold">Etat</label>
	                                                    <div id="state">dmasdm</div>
	                                                </div>
	                                                
	                                                <div class="col-md-6 mb-3">
	                                                    <label class="text-bold">Téléphone du client</label>
	                                                    <div id="phone1">dmasdm</div>
	                                                </div>
	                                                
	                                                <div class="col-md-6 mb-3">
	                                                    <label class="text-bold">Noms du proche</label>
	                                                    <div id="proch">dmasdm</div>
	                                                </div>
	                                                
	                                                <div class="col-md-6 mb-3">
	                                                    <label class="text-bold">Téléphone du proche</label>
	                                                    <div id="phone2">dmasdm</div>
	                                                </div>
	                                                
	                                                <div class="col-md-6 mb-3">
	                                                    <label class="text-bold">CNI du proche</label>
	                                                    <div id="cni">dmasdm</div>
	                                                </div>
	                                            </div>
                                              </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                                                <button type="button" class="btn btn-primary">Imprimer</button>
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
    
<script src="scripts/loans/list.js"></script>
<script>
	let temp = JSON.parse('${jsonCustomersList}');
	let temp2 = JSON.parse('${jsonDocumentsList}');
	let temp3 = JSON.parse('${jsonCopiesList}');
	let temp4 = JSON.parse('${jsonLoansList}');
	syncData(temp, temp2, temp3, temp4);
</script>

<%@ include file="../footer.jsp" %>