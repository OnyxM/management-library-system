<%@ include file="../header.jsp" %>

    <!-- START: Main Content-->
    <main>
        <div class="container-fluid">
            <!-- START: Breadcrumbs-->
            <div class="row">
                <div class="col-12  align-self-center">
                    <div class="sub-header mt-3 py-3 px-3 align-self-center d-sm-flex w-100 rounded">
                        <div class="w-sm-100 mr-auto"><h4 class="mb-0">Dashboard</h4></div>
                    </div>
                </div>
            </div>
            <!-- END: Breadcrumbs-->

            <!-- START: Card Data-->
            <div class="row">
                <div class="col-12 col-sm-6 col-xl-3 mt-3">
                    <div class="card">
                        <div class="card-body">
                            <div class='d-flex px-0 px-lg-2 py-2 align-self-center'>
                                <i class="icon-basket icons card-liner-icon mt-2"></i>
                                <div class='card-liner-content'>
                                    <h2 class="card-liner-title">2,390</h2>
                                    <h6 class="card-liner-subtitle">Today's Orders</h6> 
                                </div>                                
                            </div>
                            <i class="icon-settings icons card-liner-absolute-icon"></i>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-xl-3 mt-3">
                    <div class="card">
                        <div class="card-body">
                            <div class='d-flex px-0 px-lg-2 py-2 align-self-center'>
                                <i class="icon-user icons card-liner-icon mt-2"></i>
                                <div class='card-liner-content'>
                                    <h2 class="card-liner-title">9,390</h2>
                                    <h6 class="card-liner-subtitle">Today's Visitors</h6> 
                                </div>                                
                            </div>
                            <span class="bg-primary card-liner-absolute-icon text-white card-liner-small-tip">+4.8%</span>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-xl-3 mt-3">
                    <div class="card">
                        <div class="card-body">
                            <div class='d-flex px-0 px-lg-2 py-2 align-self-center'>
                                <i class="icon-bag icons card-liner-icon mt-2"></i>
                                <div class='card-liner-content'>
                                    <h2 class="card-liner-title">$4,390</h2>
                                    <h6 class="card-liner-subtitle">Today's Sale</h6> 
                                </div>                                
                            </div>
                            <i class="icon-refresh icons card-liner-absolute-icon"></i>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-xl-3 mt-3">
                    <div class="card">
                        <div class="card-body">
                            <div class='d-flex px-0 px-lg-2 py-2 align-self-center'>
                                <span class="card-liner-icon mt-1">$</span>
                                <div class='card-liner-content'>
                                    <h2 class="card-liner-title">$4,390</h2>
                                    <h6 class="card-liner-subtitle">Total Profit</h6> 
                                </div>                                
                            </div>
                            <i class="icon-options icons card-liner-absolute-icon"></i>
                        </div>
                    </div>
                </div>
                
                <div class="col-12 col-md-12 col-lg-12 mt-3">
                    <div class="card">
                        <div class="card-header  justify-content-between align-items-center">                               
                            <h4 class="card-title">Derniers documents enregistrés</h4> 
                        </div>
                        <div class="card-body table-responsive">
                            <table class="table table-bordered  table-hover mb-0 mt-3">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Purchased</th>
                                        <th>Client Name</th>
                                        <th>Amount</th>
                                        <th>Quantity</th>
                                        <th>Shipment</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>0001</td>
                                        <td>03/11/2015</td>
                                        <td>Addison Nichols</td>
                                        <td>$ 515.20</td>
                                        <td>547</td>
                                        <td>04/10/2017</td>
                                        <td><span class="badge badge-primary text-white">Standby</span></td>
                                    </tr>
                                    <tr class="ng-scope">
                                        <td>0002</td>
                                        <td>05/11/2015</td>
                                        <td>Albert Watkins</td>
                                        <td>$ 22.30</td>
                                        <td>122</td>
                                        <td>06/10/2017</td>
                                        <td><span class="badge badge-dark text-white">Paid</span></td>
                                    </tr>
                                    <tr class="ng-scope">
                                        <td>0003</td>
                                        <td>07/09/2015</td>
                                        <td>Johnny Fernandez</td>
                                        <td>$ 31.4</td>
                                        <td>68</td>
                                        <td>28/09/2017</td>
                                        <td><span class="badge badge-success text-white">Standby</span></td>
                                    </tr>

                                    <tr class="ng-scope">
                                        <td>0014</td>
                                        <td>30/09/2015</td>
                                        <td>Nora Lambert</td>
                                        <td>$ 147.15</td>
                                        <td>65</td>
                                        <td>23/11/2017</td>
                                        <td><span class="badge badge-info text-white">Paid</span></td>
                                    </tr>
                                    <tr class="ng-scope">
                                        <td>0015</td>
                                        <td>29/07/2015</td>
                                        <td>Shelly Robertson</td>
                                        <td>$ 15.016</td>
                                        <td>12</td>
                                        <td>30/1/2020</td>
                                        <td><span class="badge badge-danger text-white">Canceled</span></td>
                                    </tr>
                                    <tr class="ng-scope">
                                        <td>0016</td>
                                        <td>22/07/2015</td>
                                        <td>Everett Garcia</td>
                                        <td>$ 188.19</td>
                                        <td>65</td>
                                        <td>029/11/2017</td>
                                        <td><span class="badge badge-primary text-white">Paid</span></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>


                </div>
                
            </div>
            <!-- END: Card DATA-->
        </div>
    </main>
    <!-- END: Content-->

<%@ include file="../footer.jsp" %>