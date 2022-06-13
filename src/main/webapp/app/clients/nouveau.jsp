<%@ include file="../../header.jsp" %>

    <!-- START: Main Content-->
    <main>
            <div class="container-fluid">
                <!-- START: Breadcrumbs-->
                <div class="row ">
                    <div class="col-12  align-self-center">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                            <div class="w-sm-100 mr-auto"><h4 class="mb-0">Enregistrement d'un client</h4></div>
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
                                                    <div class="form-group col-md-6">
                                                        <label for="nom">Nom</label>
                                                        <input type="text" class="form-control rounded text-center" id="nom" placeholder="Doe" required name="nom">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label for="prenom">Prénom</label>
                                                        <input type="text" class="form-control text-center" id="prenom" placeholder="John" name="prenom" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="num_cni">Num CNI</label>
                                                    <input type="text" class="form-control text-center" id="num_cni" placeholder="123456789" name="num_cni" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="inputAddress">Address</label>
                                                    <input type="text" class="form-control text-center" id="inputAddress" placeholder="1234 Main St" name="adresse" required>
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