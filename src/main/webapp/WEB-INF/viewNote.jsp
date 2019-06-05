<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Заметка</title>
</head>

<body>
<h1>Просмотр заметки</h1>
<c:set var = "note" style="width: 60%;" value = "${note}"/>
<label><b>ID заметки</b></label>&nbsp;
<p><input id="noteId" type="text" name="noteId" disabled style="width: 60%;" value=${note.id}></p>
<label><b>Заголовок</b></label>
<p><input id="title" type="text" name="title" disabled style="width: 60%;" value=${note.title}></p>
<p><label><b>Текст заметки</b></label></p>
<p><textarea id="text" name="text" disabled style="width: 60%;">${note.text}</textarea></p>
</body>
</html>
