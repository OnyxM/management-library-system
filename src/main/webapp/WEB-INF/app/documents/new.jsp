<c:set var="page" value="3"/>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="styles/documents/new.css">

    <!-- START: Main Content-->
    <main>
            <div class="container-fluid">
                <!-- START: Breadcrumbs-->
                <div class="row ">
                    <div class="col-12  align-self-center">
                        <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                            <div class="w-sm-100 mr-auto"><h4 class="mb-0">Enregistrement d'un Document</h4></div>
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
                                            <form class="needs-validation" name="addDocument" onsubmit="return false;">
                                                <div class="col-md-12 mb-3">
                                                    <label for="title">Titre <span class="text-danger">*</span></label>
                                                    <input type="text" class="form-control" id="title" name="title" placeholder="Titre du document" maxlength="255" required>
                                                    <div class="invalid-tooltip" id="title-error"></div>
                                                </div>
                                                <div class="col-md-12 mb-3">
                                                    <label for="subject">Sujet <span class="text-danger">*</span></label>
                                                    <input type="text" class="form-control" name="subject" id="subject" placeholder="Sujet du document" maxlength="255" required>
                                                    <div class="invalid-tooltip" id="subject-error"></div>
                                                </div>
                                                <div class="col-md-12 mb-3">
                                                    <label for="edition">Edition <span class="text-danger">*</span></label>
                                                    <input type="text" class="form-control" name="edition" id="edition" placeholder="Maison d'édition du document" maxlength="255" required>
                                                    <div class="invalid-tooltip" id="edition-error"></div>
                                                </div>
                                                <div class="col-md-12 mb-3">
                                                    <label for="authors">Auteurs <span class="text-danger">*</span></label>
                                                    <input type="text" class="form-control" name="authors" id="authors" placeholder="Auteurs du document" maxlength="255" required>
                                                    <div class="invalid-tooltip" id="authors-error"></div>
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
                                            <label for="document-cover mb-2">Couverture</label>
                                            <div class="drag-area">
                                                <div class="icon"><i class="fas fa-cloud-upload-alt"></i></div>
                                                <h5 class="drag-header">Glissez et déposez votre image ici</h5>
                                                <span>OU</span>
                                                <button class="btn btn-success browse-button">Pacourez vos fichiers</button>
                                                <input class="upload-input" id="document-cover" type="file" hidden>
                                            </div>
                                            <div class="text-md-center mt-2" id="import" style="display: none;">
                                                <h6 id="file-name"></h6>
                                            </div>
                                            <div class="progress-cont mt-2" id="progress-cont" style="display: none;">
                                                <div class="progress" id="progress" style="width: 80px"> </div>
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
        <script src="scripts/documents/new.js"></script>
<%@ include file="../footer.jsp" %>