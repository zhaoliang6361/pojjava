<%--
  Created by IntelliJ IDEA.
  User: zhaoliang
  Date: 2018/11/22
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shadow</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../resources/bootstrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/demo/shadow.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-primary">
    <a class="navbar-brand" href="#">CNIPR</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div style="clear: both; margin-top: 80px;"></div>
<div class="container">
    <div class="row">
        <div class="col-3">
            <div class="left-side">
                <h4><label>系统菜单列表</label></h4>
                <ul>
                    <li><label>项目1</label></li>
                    <li><label>项目2</label></li>
                    <li><label>项目3</label></li>
                    <li><label>项目4</label></li>
                </ul>
            </div>
        </div>
        <div class="col-9">
            <div class="box right-side">
                <div class="bootstrap-table">
                    <div class="fix-table"></div>
                    <table>

                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="../resources/bootstrap4/js/jquery-3.2.1.slim.min.js"></script>
<script src="../resources/bootstrap4/js/bootstrap.min.js"></script>
</body>
</html>
