<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="home.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<div class="projtitle">
Project Management
</div><br>
Create Team<a href="createProject1.jsp" target="_self" required> +
</a><br>

<div class="conversation">
Conversation
</div>
<br>

<input type="search" id="myInput" onsearch="myFunction()">
<p id="demo"></p>

<script>
function myFunction() {
   var x = document.getElementById("myInput");
   document.getElementById("demo").innerHTML = "You are searching for: " + x.value;
}
</script>
<br>
PROJECTS<a href="createProject1.jsp" target="_self" required> +
</a><br>

<br>
<p id="title">Java</p><a href="createProject1.jsp" target="_self" required> :
</a><br>
</body>
</html>