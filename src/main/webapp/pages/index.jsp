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
                <li class="active"><a href="/index">首页 <span class="sr-only">(current)</span></a></li>
                <li><a href="/course">我的选课</a></li>
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

<div class="container-fluid">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">本学院课程</div>

                <!-- Table -->
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>课程编号</th>
                        <th>课程名称</th>
                        <th>授课老师</th>
                        <th>授课地点</th>
                        <th>学分</th>
                        <th>选课</th>
                    </tr>
                    </thead>
                    <tbody id="course-list">

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
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>课程编号</th>
                        <th>课程名称</th>
                        <th>授课老师</th>
                        <th>授课地点</th>
                        <th>学分</th>
                        <th>选课</th>
                    </tr>
                    </thead>
                    <tbody id="course-listB">
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">学院C课程</div>

                <!-- Table -->
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>课程编号</th>
                        <th>课程名称</th>
                        <th>授课老师</th>
                        <th>授课地点</th>
                        <th>学分</th>
                        <th>选课</th>
                    </tr>
                    </thead>
                    <tbody id="course-listB">
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%--选课模态框--%>
<div class="modal fade" id="chooseCourseModal" tabindex="-1" role="dialog" aria-labelledby="chooseCourseModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="chooseCourseModalLabel">确定选择</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="course-teacher" class="control-label">授课教师:</label>
                        <input type="text" class="form-control" readonly="readonly" id="course-teacher">
                    </div>
                    <div class="form-group">
                        <label for="course-place" class="control-label">授课地点:</label>
                        <input class="form-control" readonly="readonly" id="course-place">
                    </div>
                    <div class="form-group">
                        <label for="course-credits" class="control-label">学分:</label>
                        <input class="form-control" readonly="readonly" id="course-credits">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/assets/js/course.js"></script>
<script>
    loadChooseModal();
    loadCourses();
</script>
</body>
</html>
