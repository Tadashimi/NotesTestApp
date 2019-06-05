<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script>
    function checkFields() {
        var titleInputField = document.getElementById("title")
        var textInputField = document.getElementById("text")
        document.getElementById("saveButton").disabled = (titleInputField.value || textInputField.value)? false : "disabled";}

    </script>

    <title>Новая заметка</title>
</head>

<body>
<h1>Новая заметка</h1>
<form action="/add-new-note" method="POST">
    <label><b>Заголовок</b></label>
    <p><input id="title" type="text" name="title" onkeyup="checkFields();" style="width: 60%;" maxlength="15"></p>
    <p><label><b>Текст заметки</b></label></p>
    <p><textarea id="text" name="text" onkeyup="checkFields();" style="width: 60%;" maxlength="4095"></textarea></p>
    <p><input id="saveButton" type="submit" value="Добавить заметку" disabled></p>
</form>
</body>
</html>
