<!doctype html>
<html>
    <head>
        <title>
            <g:layoutTitle default="Grails"/>
        </title>
        <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
        <meta charset="utf-8">
        <title>Point d'interet MUPANA</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="${resource(dir:'assets/components/bootstrap/dist/css/',file:'bootstrap.min.css')}">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="${resource(dir:'assets',file:'font-awesome.min.css')}">
        <!-- Theme style -->
        <link rel="stylesheet" href="${resource(dir:'assets',file:'AdminLTE.min.css')}">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="${resource(dir:'assets',file:'_all-skins.min.css')}">
        <g:layoutHead/>
    </head>
<body class="hold-transition skin-blue sidebar-mini">
    <g:layoutBody/>
<asset:javascript src="application.js"/>
<!-- ./wrapper -->
</body>
</html>
