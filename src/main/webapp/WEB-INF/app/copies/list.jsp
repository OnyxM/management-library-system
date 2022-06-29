<c:set var="page" value="4"/>
<%@ include file="../header.jsp" %>

    <!-- START: Main Content-->
    <main>
            <div class="container-fluid">
                <!-- START: Breadcrumbs-->
                <div class="row ">
                    <div class="col-9 align-self-center">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                            <div class="w-sm-100 mr-auto"><h4 class="mb-0">Liste des exemplaires</h4></div>
                        </div>
                    </div>
                    <div class="col-3 align-self-center" align="right">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                        	<a href="documents/new" class="btn btn-info">Nouvel exemplaire</a>
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
                                    <table id="copiesTableList" class="display table dataTable table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Code</th>
                                                <th>Document</th>
                                                <th>Date d'ajout</th>
                                                <th>Statut </th>
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
    
<script src="scripts/copies/list.js"></script>
<script>
	let temp = JSON.parse('${jsonExemplairesList}');
	let temp2 = JSON.parse('${jsonDocumentsList}');
	syncCopies(temp, temp2);
</script>

<%@ include file="../footer.jsp" %>