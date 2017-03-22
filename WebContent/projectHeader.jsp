<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX JsonArray Example</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<style type="text/css">
table, td, th
{
border:1px solid green;
font-family: 'Oxygen', sans-serif;
}
th
{
background-color:green;
color:white;
}
/* body
{
	text-align: center;
} */
.container
{
	margin-left: auto;
	margin-right: auto;
	width: 40em;
}
h4
{
	font-family: 'Oxygen', sans-serif;
	color:#1E90FF;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: white;
}

li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}

/* Change the link color on hover */
li a:hover {
    background-color: #555;
    color: red;
}
div {
text-decoration: none;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).on("keypress", "#user", function(e) {
	//var table = $('<table/>').appendTo($('#welcometext')); 

	$("#tablediv").hide();
	
	console.log("keypress function");
	
	if (e.which == 13) {
		 e.preventDefault(); 
		console.log("enter key");
		//do some stuff
		var txt = $('input:text[name=DrugDurationLength]').val();

		var username = $('#user').val();
		
		$.get('getPojectFromDB', {
			usern : username
		}, function(responseText) {
			if(responseText!=null){
	          	   $("#countrytable").find("tr:gt(0)").remove();
	          	   var table1 = $("#countrytable");
	          	   var buffer="";
		               $.each(responseText, function(key,value) { 
		            	   
		            	   var item = value['projectid']; 
		                   console.log(item);
		                   buffer+=" <li><a href='getUserServlet?id="+item+"' target='menu'>"+value['projectname']+"</a></li>"; 
		                       
		               });
		               $("#tablediv").html(buffer);
	              }
		});
		$("#tablediv").show();   
	} 
});
</script>
</head>
<body class="container">

<h2> Asana.com  </h2>
<ul>
  <li><a href="#home">Asana</a></li>
</ul>

<ul>
  <li><a href="#news">Conversation</a></li>
</ul>

<form id="form1">
<input type="text" placeholder="filter project" id="user"/>
<ul>
<li>
<a href="#home">
<!-- <div id="tablediv">
</div> -->
</a>
</li>
</ul>

</form>
<div>
PROJECTS <a href="createProject1.jsp" target="_self" required id="atest"> +
</div>
<ul>
<li>
<div id="tablediv">

</div>
</li>
</ul>
<ul>
  <li>
	 <span class="psw"><a href="#home1" id="tlink" onclick="doalert(this); return false;">Java</a><a href="#project" id="tlink" onclick="doalert(this); return false;">...</a></span>
  </li>
</ul>
</body>
</html>