<%@ page language="java" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp" %>
<!DOCTYPE html>
<html style="overflow-x: hidden; overflow-y: auto;">
<head>
    <%@include file="/WEB-INF/include/head.jsp" %>
    <%@include file="/WEB-INF/include/title.jsp" %>
</head>
<body class="sidebar-mini skin-blue fixed" data-spy="scroll" data-target="#scrollspy">

<div class="wrapper">

    <!-- header begin -->
    <header class="main-header navbar-fixed-top">
        <a href="../index2.html" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>A</b>LT</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Admin</b>LTE</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">


            <a class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">切换导航</span>
            </a>

            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有4个消息</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><!-- start message -->
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="${contextPath}/image/default-avatar.png" class="img-circle"
                                                     alt="User Image">
                                            </div>
                                            <h4>
                                                Sender Name
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p>Message Excerpt</p>
                                        </a>
                                    </li><!-- end message -->
                                </ul>
                            </li>
                            <li class="footer"><a href="#">查看全部</a></li>
                        </ul>
                    </li>
                    <!-- Notifications: style can be found in dropdown.less -->
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">10</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有10个通知</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <a href="#">
                                            <i class="ion ion-ios-people info"></i>
                                            通知标题
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">查看全部</a></li>
                        </ul>
                    </li>
                    <!-- Tasks: style can be found in dropdown.less -->
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger">9</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">您有9个任务</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><!-- Task item -->
                                        <a href="#">
                                            <h3>
                                                未完成的任务
                                                <small class="pull-right">20%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-aqua" style="width: 20%"
                                                     role="progressbar" aria-valuenow="20" aria-valuemin="0"
                                                     aria-valuemax="100">
                                                    <span class="sr-only">20%</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="#">查看全部</a>
                            </li>
                        </ul>
                    </li>
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="${contextPath}/image/default-avatar.png" class="user-image" alt="User Image">
                            <span class="hidden-xs">Alexander Pierce</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="${contextPath}/image/default-avatar.png" class="img-circle" alt="User Image">
                                <p>
                                    Alexander Pierce
                                    <br/>Web Developer
                                    <small>Member since Nov. 2012</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="col-xs-4 text-center">
                                    <a href="#">Followers</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Sales</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Friends</a>
                                </div>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- header end-->


    <!-- sidebar begin-->

    <aside class="main-sidebar">
        <!-- Inner sidebar -->
        <section class="sidebar">
            <!-- user panel (Optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="${contextPath}/image/default-avatar.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>User Name</p>

                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div><!-- /.user-panel -->

            <!-- Search Form (Optional) -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search..."/>
                    <span class="input-group-btn">
                        <button type="submit" name="search" id="search-btn" class="btn btn-flat">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
            </form><!-- /.sidebar-form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">导航栏</li>
                <!-- Optionally, you can add icons to the links -->
                <li class="">
                    <a href="#">
                        <i class="fa fa-link"></i>
                        <span>连接</span>
                        <span class="pull-right-container">
                            <small class="label pull-right bg-red-active">1</small>
                        </span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-link"></i>
                        <span>关联链接</span>
                    </a>
                </li>
                <li class="treeview active menu-open">
                    <a href="#">
                        <i class="fa fa-circle-o"></i>
                        <span>一级链接</span><i class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li class="active"><a href="#"><i class="fa fa-circle-o"></i>二级链接</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i>二级链接</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->

        </section>

        <!-- /.sidebar -->
    </aside>

    <!-- /.main-sidebar -->

    <!-- sidebar end-->


    <!-- content begin-->
    <div class="content-wrapper">

        <section class="content-header">
            <h1>主标题
                <small>描述</small>
            </h1>
            <ol class="breadcrumb">
                <li>
                    <a href="javascript:void(0);">
                        一级
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        二级
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        三级
                    </a>
                </li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-xs-12">

                    <div class="box">
                        <div class="box-header ">
                            <h3 class="box-title">Data Table With Full Features</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="dataTables_length" id="example1_length"><label>Show <select
                                                name="example1_length" aria-controls="example1"
                                                class="form-control input-sm">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select> entries</label></div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div id="example1_filter" class="dataTables_filter"><label>Search:<input
                                                type="search" class="form-control input-sm" placeholder=""
                                                aria-controls="example1"></label></div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <table id="example1"
                                               class="table table-bordered table-striped table-hover dataTable"
                                               role="grid" aria-describedby="example1_info">
                                            <thead>
                                            <tr role="row">
                                                <th class="sorting_asc" tabindex="0" aria-controls="example1"
                                                    rowspan="1" colspan="1" aria-sort="ascending"
                                                    aria-label="Rendering engine: activate to sort column descending"
                                                    style="width: 193px;">Rendering engine
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example1"
                                                    rowspan="1" colspan="1"
                                                    aria-label="Browser: activate to sort column ascending"
                                                    style="width: 246px;">Browser
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example1"
                                                    rowspan="1" colspan="1"
                                                    aria-label="Platform(s): activate to sort column ascending"
                                                    style="width: 229px;">Platform(s)
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example1"
                                                    rowspan="1" colspan="1"
                                                    aria-label="Engine version: activate to sort column ascending"
                                                    style="width: 165px;">Engine version
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example1"
                                                    rowspan="1" colspan="1"
                                                    aria-label="CSS grade: activate to sort column ascending"
                                                    style="width: 126px;">CSS grade
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>


                                            <tr role="row" class="odd">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Firefox 1.0</td>
                                                <td>Win 98+ / OSX.2+</td>
                                                <td>1.7</td>
                                                <td>A</td>
                                            </tr>
                                            <tr role="row" class="even">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Firefox 1.5</td>
                                                <td>Win 98+ / OSX.2+</td>
                                                <td>1.8</td>
                                                <td>A</td>
                                            </tr>
                                            <tr role="row" class="odd">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Firefox 2.0</td>
                                                <td>Win 98+ / OSX.2+</td>
                                                <td>1.8</td>
                                                <td>A</td>
                                            </tr>
                                            <tr role="row" class="even">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Firefox 3.0</td>
                                                <td>Win 2k+ / OSX.3+</td>
                                                <td>1.9</td>
                                                <td>A</td>
                                            </tr>
                                            <tr role="row" class="odd">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Camino 1.0</td>
                                                <td>OSX.2+</td>
                                                <td>1.8</td>
                                                <td>A</td>
                                            </tr>
                                            <tr role="row" class="even">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Camino 1.5</td>
                                                <td>OSX.3+</td>
                                                <td>1.8</td>
                                                <td>A</td>
                                            </tr>
                                            <tr role="row" class="odd">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Netscape 7.2</td>
                                                <td>Win 95+ / Mac OS 8.6-9.2</td>
                                                <td>1.7</td>
                                                <td>A</td>
                                            </tr>
                                            <tr role="row" class="even">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Netscape Browser 8</td>
                                                <td>Win 98SE+</td>
                                                <td>1.7</td>
                                                <td>A</td>
                                            </tr>
                                            <tr role="row" class="odd">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Netscape Navigator 9</td>
                                                <td>Win 98+ / OSX.2+</td>
                                                <td>1.8</td>
                                                <td>A</td>
                                            </tr>
                                            <tr role="row" class="even">
                                                <td class="sorting_1">Gecko</td>
                                                <td>Mozilla 1.0</td>
                                                <td>Win 95+ / OSX.1+</td>
                                                <td>1</td>
                                                <td>A</td>
                                            </tr>
                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th rowspan="1" colspan="1">Rendering engine</th>
                                                <th rowspan="1" colspan="1">Browser</th>
                                                <th rowspan="1" colspan="1">Platform(s)</th>
                                                <th rowspan="1" colspan="1">Engine version</th>
                                                <th rowspan="1" colspan="1">CSS grade</th>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-5">
                                        <div class="dataTables_info" id="example1_info" role="status"
                                             aria-live="polite">Showing 1 to 10 of 57 entries
                                        </div>
                                    </div>
                                    <div class="col-sm-7">
                                        <div class="dataTables_paginate paging_simple_numbers"
                                             id="example1_paginate">
                                            <ul class="pagination">
                                                <li class="paginate_button previous disabled"
                                                    id="example1_previous"><a href="#" aria-controls="example1"
                                                                              data-dt-idx="0"
                                                                              tabindex="0">Previous</a></li>
                                                <li class="paginate_button active"><a href="#"
                                                                                      aria-controls="example1"
                                                                                      data-dt-idx="1"
                                                                                      tabindex="0">1</a></li>
                                                <li class="paginate_button "><a href="#" aria-controls="example1"
                                                                                data-dt-idx="2" tabindex="0">2</a>
                                                </li>
                                                <li class="paginate_button "><a href="#" aria-controls="example1"
                                                                                data-dt-idx="3" tabindex="0">3</a>
                                                </li>
                                                <li class="paginate_button "><a href="#" aria-controls="example1"
                                                                                data-dt-idx="4" tabindex="0">4</a>
                                                </li>
                                                <li class="paginate_button "><a href="#" aria-controls="example1"
                                                                                data-dt-idx="5" tabindex="0">5</a>
                                                </li>
                                                <li class="paginate_button "><a href="#" aria-controls="example1"
                                                                                data-dt-idx="6" tabindex="0">6</a>
                                                </li>
                                                <li class="paginate_button next" id="example1_next"><a href="#"
                                                                                                       aria-controls="example1"
                                                                                                       data-dt-idx="7"
                                                                                                       tabindex="0">Next</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>

        </section>


        <%--<div class="content-"--%>
    </div>
    <!-- content end-->


    <!-- footer begin-->
    <footer class="main-footer text-center">
        Copyright © 2014-2016 <a href="javascript:void(0);">AlbenYuan</a>
    </footer>

    <!-- footer end-->


</div>

</body>
</html>




