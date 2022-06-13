<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8">
     <title>Accueil - Gestion de la Bibliothèque</title>
     <link rel="shortcut icon" href="dist/images/favicon.ico" />
     <meta name="viewport" content="width=device-width,initial-scale=1">

	<c:set var="req" value="${pageContext.request}" />
	<c:set var="url">${req.requestURL}</c:set>
	<c:set var="uri" value="${req.requestURI}" />
	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />

     <!-- START: Template CSS-->
     <link rel="stylesheet" href="dist/vendors/bootstrap/css/bootstrap.min.css">
     <link rel="stylesheet" href="dist/vendors/jquery-ui/jquery-ui.min.css">
     <link rel="stylesheet" href="dist/vendors/jquery-ui/jquery-ui.theme.min.css">
     <link rel="stylesheet" href="dist/vendors/simple-line-icons/css/simple-line-icons.css">        
     <link rel="stylesheet" href="dist/vendors/flags-icon/css/flag-icon.min.css"> 
     <link rel="stylesheet" href="dist/vendors/flag-select/css/flags.css">
     <!-- END Template CSS-->

     <!-- START: Page CSS-->
     <link rel="stylesheet"  href="dist/vendors/chartjs/Chart.min.css">
     <!-- END: Page CSS-->

     <!-- START: Page CSS-->   
     <link rel="stylesheet" href="dist/vendors/morris/morris.css"> 
     <link rel="stylesheet" href="dist/vendors/weather-icons/css/pe-icon-set-weather.min.css"> 
     <link rel="stylesheet" href="dist/vendors/chartjs/Chart.min.css"> 
     <link rel="stylesheet" href="dist/vendors/starrr/starrr.css"> 
     <link rel="stylesheet" href="dist/vendors/fontawesome/css/all.min.css">
     <link rel="stylesheet" href="dist/vendors/ionicons/css/ionicons.min.css"> 
     <link rel="stylesheet" href="dist/vendors/jquery-jvectormap/jquery-jvectormap-2.0.3.css">
     <!-- END: Page CSS-->

     <!-- START: Custom CSS-->
     <link rel="stylesheet" href="dist/css/main.css">
     <!-- END: Custom CSS-->
 </head>
    <!-- END Head-->

    <!-- START: Body-->
    <body id="main-container" class="default">

        <!-- START: Pre Loader-->
        <div class="se-pre-con">
            <img src="dist/images/logo.png" alt="logo" width="23" class="img-fluid"/>
        </div>
        <!-- END: Pre Loader-->

        <!-- START: Header-->
        <div id="header-fix" class="header fixed-top">
            <nav class="navbar navbar-expand-lg  p-0">
                <div class="navbar-header h4 mb-0 align-self-center logo-bar text-center">  
                    <a href="app" class="horizontal-logo text-center">
                        <span class="h3 align-self-center mb-0 ">LIBMAS</span>              
                    </a>                   
                </div>
                <div class="navbar-header h4 mb-0 text-center h-100 collapse-menu-bar">
                    <a href="#" class="sidebarCollapse" id="collapse"><i class="icon-menu body-color"></i></a>
                </div>

                <form class="float-left d-none d-lg-block search-form">
                    <div class="form-group mb-0 position-relative">
                        <input type="text" class="form-control border-0 rounded bg-search pl-5" placeholder="Search anything...">
                        <div class="btn-search position-absolute top-0">
                            <a href="#"><i class="h5 icon-magnifier body-color"></i></a>
                        </div>
                        <a href="#" class="position-absolute close-button mobilesearch d-lg-none" data-toggle="dropdown" aria-expanded="false"><i class="icon-close h5"></i>                               
                        </a>

                    </div>
                </form>
                <div class="navbar-right ml-auto h-100">
                    <ul class="ml-auto p-0 m-0 list-unstyled d-flex top-icon h-100">
                        <li class="dropdown user-profile align-self-center d-inline-block">
                            <a href="#" class="nav-link py-0" data-toggle="dropdown" aria-expanded="false"> 
                                <div class="media">                                   
                                    <img src="dist/images/author.jpg" alt="" class="d-flex img-fluid rounded-circle" width="29">
                                </div>
                            </a>

                            <div class="dropdown-menu  dropdown-menu-right p-0">
                                <a href="#" class="dropdown-item px-2 align-self-center d-flex">
                                    <span class="icon-settings mr-2 h6 mb-0"></span> Account Settings</a>
                                <div class="dropdown-divider"></div>
                                <a href="/Management_Library_System" class="dropdown-item px-2 text-danger align-self-center d-flex">
                                    <span class="icon-logout mr-2 h6  mb-0"></span> Sign Out</a>
                            </div>

                        </li>

                    </ul>
                </div>
            </nav>
        </div>
        <!-- END: Header-->

        <!-- START: Main Menu-->
        <div class="sidebar">
            <div class="media d-block text-center user-profile">
                <img class="img-fluid" src="dist/images/author1.jpg" alt="">
                <div class="media-body text-center mt-0 color-primary mt-2">
                        <a href="#" class="nav-link py-0" data-toggle="dropdown" aria-expanded="false"> 
                            <h6 class="mb-0 font-weight-bold">Harry Jones</h6>
                            Toronto, Canada 
                        </a>
                        <div class="dropdown-menu dropdown-menu-right p-0" style="">
                            <a href="#" class="dropdown-item px-2 align-self-center d-flex">
                                <span class="icon-settings mr-2 h6 mb-0"></span> Account Settings</a>
                            <div class="dropdown-divider"></div>
                            <a href="/Management_Library_System" class="dropdown-item px-2 text-danger align-self-center d-flex">
                                <span class="icon-logout mr-2 h6  mb-0"></span> Sign Out</a>
                        </div>
                </div>
            </div>
            
            <!-- START: Menu-->
            <ul id="side-menu" class="sidebar-menu">
                <li class="dropdown active"><a href="app">Dashboard</a>                  
                    <ul>
                        <li class="active"><a href="app"><i class="icon-rocket"></i> Dashboard</a></li>
                        
                        <li><a href="app/clients"><i class="icon-user"></i> Gestion des Clients</a></li>
                    </ul>
                </li>
            </ul>
            <!-- END: Menu-->
        </div>
        <!-- END: Main Menu-->