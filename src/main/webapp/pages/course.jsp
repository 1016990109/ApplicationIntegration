<%--
  Created by IntelliJ IDEA.
  User: 传旺
  Date: 2016/6/6
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的选课</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <style>
        body { padding-top: 100px; }
        .user-icon {
            width: 30px;
            height: 30px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">选课系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/index">首页</a></li>
                <li class="active"><a href="/course">我的选课 <span class="sr-only">(current)</span></a></li>
                <li><a href="/students">所有学生</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img
                            src="/assets/img/user.jpg" alt="用户" class="user-icon"> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人中心</a></li>
                        <li><a href="/logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">已选课程</div>

            <!-- Table -->
            <table class="table">
                <thead>
                <tr>
                    <th>课程编号</th>
                    <th>课程名称</th>
                    <th>授课老师</th>
                    <th>授课地点</th>
                    <th>学分</th>
                    <th>选课人数</th>
                    <th>退课</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>管理信息系统</td>
                    <td>王浩然</td>
                    <td>教103</td>
                    <td>2</td>
                    <td>212</td>
                    <td><a href="#">退课</a></td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>数据库开发</td>
                    <td>刘嘉</td>
                    <td>教203</td>
                    <td>2</td>
                    <td>212</td>
                    <td><a href="#">退课</a></td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>SOA</td>
                    <td>汤恩义</td>
                    <td>教103</td>
                    <td>2</td>
                    <td>212</td>
                    <td><a href="#">退课</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
</body>
</html>
