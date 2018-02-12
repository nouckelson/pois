<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="index2.html" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>M</b>P</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>MUPANA</b></span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-gears"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <g:link controller='logout' action=''>Logout</g:link>
                                %{--<a href="#" class="btn btn-default btn-flat">Logout</a>--}%
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">MAIN NAVIGATION </li>
                <li class="active treeview">
                    <a href="#">
                        <i class="fa fa-dashboard"></i>  <g:link controller='admin' action=''>Dashboard</g:link>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li class="active">
                            <g:link controller='pois' action=''>Gestion Pois</g:link>
                        </li>
                        <li class="active">
                            <g:link controller='emplacement' action=''>Gestion d'adresse</g:link>
                        </li>
                        <li class="active">
                            <g:link controller='groupe' action=''>Gestion Groupe</g:link>
                        </li>
                    </ul>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Dashboard</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dashboard</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <g:if test="${flash.message}">
                    <div class="alert alert-info">
                        ${flash.message}
                    </div>
                </g:if>
                <div class="col-md-6">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Gestion de POIs</h3>

                        </div>
                    <!-- /.box-header -->
                    <!-- form start -->

                            <div class="box-body">

                                <div class="form-group">
                                    <label>Point d'interet <i class="label label-default">${poisData.pois_nom} ${poisData.description}</i></label>
                                </div>
                                <ul class="products-list product-list-in-box">
                                    <li class="item">
                                        <div class="product-img">
                                            <img src="${poisData.filedata}">${poisData.image_nom}
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <div id="body"></div>
                                 <g:form role="form" action="upload" enctype="multipart/form-data">
                                     <input type="hidden" name="id" value="${poisData.id}">
                                     <input type="file" class="btn btn-primary" name="files" id="file">
                                     <hr>
                                    <input type="submit" class="btn btn-primary" value="ajouter">
                                    %{--<a class="btn btn-primary" id="add"><i class="fa fa-plus"></i></a>--}%
                                 </g:form>

                            </div>

                    </div>
                </div>
                <div class="col-md-8">
                </div>
            </div>
            <!-- /.row -->


        </section>
        <!-- /.content -->
    </div>

    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <strong>Copyright &copy; TP-MBDS Haiti <a href="#">MUPANA 2017-2018</a>.</strong> Tout droit reserve.
    </footer>

</div>
<!-- ./wrapper -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"/>
</script>
<script>
    $(document).ready(function () {
        // $("#add").click(function () {
        //   var x=$("#file").val();
        //   alert(formData)
        //     // $.ajax({
        //     //     type: "POST",
        //     //     url: "pois/upload",
        //     //     data: new FormData(this)
        //     // }).done(function(msg){
        //     //     $("#body").html(msg);
        //     // });
        // });

        $("#add").click(function(e) {
            form.submit();
            e.preventDefault();
            alert(new FormData($()))
            // $.ajax({
            //     url: "pois/upload",
            //     type: "POST",
            //     data:  new FormData(this),
            //     success: function(data)
            //     {
            //         alert("ok")
            //         // $("#targetLayer").html(data);
            //         // $("#targetLayer").css('opacity','1');
            //         // setInterval(function() {$("#body-overlay").hide(); },500);
            //     },
            //     error: function()
            //     {
            //         alert("error")
            //     }
            // });
        });
    });

</script>
</body>
</html>
