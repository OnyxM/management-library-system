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