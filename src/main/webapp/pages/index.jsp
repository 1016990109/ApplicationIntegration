<%--
  Created by IntelliJ IDEA.
  User: 传旺
  Date: 2016/6/2
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A学院选课</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
</head>
<body>
<nav>
    <div class="jumbotron" style="background-color: wheat">
        <div class="container" style="text-align: center">
            <h1>欢迎来到学院A!</h1>
            <p>...</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">了解更多</a></p>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">本学院课程</div>

                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>课程名称</th>
                        <th>选课人数</th>
                        <th>选课/退课</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>软件测试</td>
                        <td>212</td>
                        <td><a href="#">选课</a>/<a href="#">退课</a></td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>人机交互</td>
                        <td>212</td>
                        <td><a href="#">选课</a>/<a href="#">退课</a></td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>应用集成管理</td>
                        <td>212</td>
                        <td><a href="#">选课</a>/<a href="#">退课</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">学院B课程</div>

                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>课程名称</th>
                        <th>选课人数</th>
                        <th>选课/退课</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>管理信息系统</td>
                        <td>212</td>
                        <td><a href="#">选课</a>/<a href="#">退课</a></td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>数据库开发</td>
                        <td>212</td>
                        <td><a href="#">选课</a>/<a href="#">退课</a></td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>SOA</td>
                        <td>212</td>
                        <td><a href="#">选课</a>/<a href="#">退课</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
</body>
</html>
