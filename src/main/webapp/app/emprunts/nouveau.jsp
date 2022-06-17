<%@ include file="../../header.jsp" %>

    <!-- START: Main Content-->
    <main>
            <div class="container-fluid">
                <!-- START: Breadcrumbs-->
                <div class="row ">
                    <div class="col-12  align-self-center">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                            <div class="w-sm-100 mr-auto"><h4 class="mb-0">Enregistrement d'un emprunt</h4></div>
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
                                        <div class="col-12">
                                            <form method="POST" action="">
                                                <div class="form-row">
                                                    <div class="form-group col-md-12">
                                                        <label for="document">Choisissez le document à emprunter</label>
                                                        <select class="form-control" name="document" required>
                                                        	<option>Choisissez le document à emprunter</option>
                                                        	<option>Document</option>
                                                        	<option>Document</option>
                                                        	<option>Document</option>
                                                        	<option>Document</option>
                                                        	<option>Document</option>
                                                        	<option>Document</option>
                                                        	<option>Document</option>
                                                        	<option>Document</option>
                                                        	<option>Document</option>
                                                        	<option>Document</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="num_cni">Num CNI du Client</label>
                                                    <input type="text" class="form-control text-center" id="num_cni" placeholder="123456789" name="num_cni" required>
                                                    <span class="text-center">lorem	ipsum</span>
                                                </div>
                                                <div class="form-group">
                                                    <label for="date_retour">Date de retour du Document</label>
                                                    <input type="datetime-local" class="form-control text-center" id="date_retour" placeholder="1234 Main St" name="date_retour" required>
                                                </div>

                                                <div class="text-right">
                                                	<button type="submit" class="btn btn-primary">Enregistrer</button>
                                                </div>
                                            </form>
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

<%@ include file="../../footer.jsp" %>