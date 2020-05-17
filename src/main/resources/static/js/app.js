function SelectAllCheckBoxes(FormName, FieldName, CheckValue) {
    window.alert("in js");
    if(!document.forms[FormName]) { return; }
    var checkBoxes = document.forms[FormName].elements[FieldName];

    if(!checkBoxes){ return; }

    var numberOfCheckBoxes = checkBoxes.length;
    if(!numberOfCheckBoxes){
        checkBoxes.checked = CheckValue;
    } else {
        for(var i = 0; i < numberOfCheckBoxes; i++){
            checkBoxes[i].checked = CheckValue;
        }
    }
}

function test() {
    window.alert("test");
}

function allTasks() {
    //var url = "${request.getContextPath()}/tasks/viewAllTasks/";
    alert(${request.getContextPath()});
    $.ajax({
        type: "GET",
        url: "/tasks/viewAllTasks/",
        error: function () {
            window.alert("FAILED GET: " + "${request.getContextPath()}/tasks/viewAllTasks/");
        },
        success: function () {
            window.alert("SUCCESS");
        }
    });
}