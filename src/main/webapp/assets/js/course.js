/**
 * Created by 传旺 on 2016/6/6.
 */

/**
 * 初始化选课模态框
 */
function loadChooseModal() {
    $('#chooseCourseModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var courseId = button.data('course-id') // Extract info from data-* attributes
        var courseName = button.data('course-name')
        var courseTeacher = button.data('course-teacher')
        var coursePlace = button.data('course-place')
        var courseCredits = button.data('course-credits')
        var modal = $(this)
        modal.find('.modal-title').html('确定选择 <span class="text-primary">' + courseName + '</span> 课程')
        modal.find('.modal-body input#course-teacher').val(courseTeacher)
        modal.find('.modal-body input#course-place').val(coursePlace)
        modal.find('.modal-body input#course-credits').val(courseCredits)
    })
}

/**
 * 初始化退课模态框
 */
function loadDropModal() {
    $('#dropCourseModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var courseId = button.data('course-id') // Extract info from data-* attributes
        var courseName = button.data('course-name')
        var courseTeacher = button.data('course-teacher')
        var coursePlace = button.data('course-place')
        var courseCredits = button.data('course-credits')
        var modal = $(this)
        modal.find('.modal-title').html('确定退选 <span class="text-primary">' + courseName + '</span> 课程？')
        modal.find('.modal-body input#course-teacher').val(courseTeacher)
        modal.find('.modal-body input#course-place').val(coursePlace)
        modal.find('.modal-body input#course-credits').val(courseCredits)
    })
}

function loadCourses() {
    $.ajax({
        url:"/getCourse",
        type:"post",
        data:{
            studentId:10001
        },
        success:function (data) {
            console.log(data);
            var courseList = $("#course-list");
            for (var i = 0; i < data.length; i++){
                var courseId = data[i]['courseId'];
                var courseName = data[i]['courseName'];
                var courseTeacher = data[i]['teacherName'];
                var coursePlace = data[i]['coursePlace'];
                var courseCredits = data[i]['coursePoint'];
                var content = '<tr>' +
                    '<th scope="row">' + courseId + '</th>' +
                    '<td>' + courseName + '</td>' +
                    '<td>' + courseTeacher + '</td>' +
                    '<td>' + coursePlace + '</td>' +
                    '<td>' + courseCredits + '</td>';
                if(data[i]['isShared'] == 2){
                    content += '<td>已选</td>';
                }else {
                    content += '<td><a href="#" data-toggle="modal" data-target="#chooseCourseModal" data-course-id="' + courseId + '" data-course-name="' + courseName + '" data-course-place="' + coursePlace + '" data-course-teacher="' + courseTeacher + '" data-course-credits="' + courseCredits + '">选课</a></td>';
                }
                content += '</tr>';
                courseList.append(content);
            }
        }
    });

    $.ajax({
        url:"/getOtherCourse",
        type:"post",
        data:{
            studentId:10001
        },
        success:function (data) {
            console.log(data);
            var courseListB = $("#course-listB");
            var courseListC = $("#course-listC");
            var dataB = data['B'];
            var dataC = data['C'];
            for (var i = 0; i < dataB.length; i++){
                var courseId = dataB[i]['courseId'];
                var courseName = dataB[i]['courseName'];
                var courseTeacher = dataB[i]['teacherName'];
                var coursePlace = dataB[i]['coursePlace'];
                var courseCredits = dataB[i]['coursePoint'];
                var content = '<tr>' +
                    '<th scope="row">' + courseId + '</th>' +
                    '<td>' + courseName + '</td>' +
                    '<td>' + courseTeacher + '</td>' +
                    '<td>' + coursePlace + '</td>' +
                    '<td>' + courseCredits + '</td>';
                if(data[i]['isShared'] == 2){
                    content += '<td>已选</td>';
                }else {
                    content += '<td><a href="#" data-toggle="modal" data-target="#chooseCourseModal" data-course-id="' + courseId + '" data-course-name="' + courseName + '" data-course-place="' + coursePlace + '" data-course-teacher="' + courseTeacher + '" data-course-credits="' + courseCredits + '">选课</a></td>';
                }
                content += '</tr>';
                courseListB.append(content);
            }

            for (var i = 0; i < dataC.length; i++){
                var courseId = dataC[i]['courseId'];
                var courseName = dataC[i]['courseName'];
                var courseTeacher = dataC[i]['teacherName'];
                var coursePlace = dataC[i]['coursePlace'];
                var courseCredits = dataC[i]['coursePoint'];
                var content = '<tr>' +
                    '<th scope="row">' + courseId + '</th>' +
                    '<td>' + courseName + '</td>' +
                    '<td>' + courseTeacher + '</td>' +
                    '<td>' + coursePlace + '</td>' +
                    '<td>' + courseCredits + '</td>';
                if(data[i]['isShared'] == 2){
                    content += '<td>已选</td>';
                }else {
                    content += '<td><a href="#" data-toggle="modal" data-target="#chooseCourseModal" data-course-id="' + courseId + '" data-course-name="' + courseName + '" data-course-place="' + coursePlace + '" data-course-teacher="' + courseTeacher + '" data-course-credits="' + courseCredits + '">选课</a></td>';
                }
                content += '</tr>';
                courseListC.append(content);
            }
        }
    });
}