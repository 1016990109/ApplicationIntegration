/**
 * Created by 传旺 on 2016/6/6.
 */
$('#chooseCourseModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var courseId = button.data('course-id') // Extract info from data-* attributes
    var courseName = button.data('course-name')
    var courseTeacher = button.data('course-teacher')
    var coursePlace = button.data('course-place')
    var courseCredits = button.data('course-credits')
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    modal.find('.modal-title').html('确定选择 <span class="text-primary">' + courseName + '</span> 课程')
    modal.find('.modal-body input#course-teacher').val(courseTeacher)
    modal.find('.modal-body input#course-place').val(coursePlace)
    modal.find('.modal-body input#course-credits').val(courseCredits)
})