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
            <h1>
                Dashboard
                <small>Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dashboard</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <div class="row">
    <div class="box">
        <div class="box-header">
            <h3 class="box-title">Liste de Pois</h3>
            <a class="btn btn-primary pull-right" href="/pois/create"> Ajouter un POI</a>
        </div>
        <!-- /.box-header -->
        <g:if test="${flash.message}">
            <div class="alert alert-info">
                ${flash.message}
            </div>
        </g:if>
        <div class="box-body">
            <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Adresse</th>
                    <th>Longitude</th>
                    <th>Latitude</th>
                    <th width="12%">&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${0..poisCount }" var="i" >
                    <g:if test="${poisData['id'][i]!=null}">
                        <tr>
                            <td>${poisData['nom'][i]}</td>
                            <td>${poisData['description'][i]}</td>
                            <td>${poisData['nom'][i]}</td>
                            <td>${poisData['nom'][i]}</td>
                            <td>${poisData['nom'][i]}</td>
                            <td>
                                  <label><a href="/pois/edit/${poisData['id'][i]}"><i class="fa fa-edit"></i></a></label>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
                                <label><a href="/pois/delete/${poisData['id'][i]}"><i class="fa fa-trash"></i></a></label>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
                                <label><a href="/pois/show/${poisData['id'][i]}"><i class="fa fa-eye"></i></a></label>
                            </td>
                        </tr>
                    </g:if>
                </g:each>
                </tbody>
            </table>


        </div>
        <!-- /.box-body -->
    </div>
    <!-- /.box -->
            </div>
            <!-- /.row -->


        </section>
        <!-- /.content -->
    </div>

    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <g:if test="${session}">

        </g:if>
        <br>
        <strong>Copyright &copy; TP-MBDS Haiti <a href="#">MUPANA 2017-2018</a>.</strong> Tout droit reserve.
    </footer>

</div>
<!-- ./wrapper -->

<script>
    $(function () {
        $('#example1').DataTable()
        $('#example2').DataTable({
            'paging'      : true,
            'lengthChange': false,
            'searching'   : false,
            'ordering'    : true,
            'info'        : true,
            'autoWidth'   : false
        })
    })
</script>
</body>
</html>
