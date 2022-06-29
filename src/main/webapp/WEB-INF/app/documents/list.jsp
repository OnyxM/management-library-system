<c:set var="page" value="3"/>
<%@ include file="../header.jsp" %>

    <!-- START: Main Content-->
    <main>
            <div class="container-fluid">
                <!-- START: Breadcrumbs-->
                <div class="row ">
                    <div class="col-9 align-self-center">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                            <div class="w-sm-100 mr-auto"><h4 class="mb-0">Liste des Documents</h4></div>
                        </div>
                    </div>
                    <div class="col-3 align-self-center" align="right">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                        	<a href="documents/new" class="btn btn-info">Nouveau document</a>
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
                                    <table id="documentsTableList" class="display table dataTable table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Titre</th>
                                                <th>Maison d'édition</th>
                                                <th>Auteurs</th>
                                                <th>Date de création </th>
                                                <th title='nombre d\'exemplaires'>Nbre d'ex.</th>
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
    
<script src="scripts/documents/list.js"></script>
<script>
	let temp = JSON.parse('${jsonDocumentsList}');
	let temp2 = JSON.parse('${jsonExemplairesList}');
	syncDocuments(temp, temp2);
</script>

<%@ include file="../footer.jsp" %>