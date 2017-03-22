<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX JsonArray Example</title>
<!-- <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'> -->
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
body
{
	text-align: center;
}
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
			
			console.log("Test is:");
			console.log("Response is:"+responseText);
			if(responseText!=null){
	          	   $("#countrytable").find("tr:gt(0)").remove();
	          	   var table1 = $("#countrytable");
	          	   var buffer="";
		               $.each(responseText, function(key,value) { 
		            	   
		            	   var item = value['projectid']; 
		                   console.log("Item is:"+item);
		                   buffer+=" <li><a href='getUserServlet?id="+item+"'>"+value['projectname']+"</a></li>"; 
		                   
		               		   /* var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td></tr>");
		                       rowNew.children().eq(0).text(value['projectid']); 
		                       rowNew.children().eq(1).text(value['projectname']); 
		                       rowNew.children().eq(2).text(value['projectstartdate']); 
		                       rowNew.children().eq(3).text(value['projectenddate']); 
		                       rowNew.children().eq(4).text(value['teamid']); 
		                       rowNew.appendTo(table1); */
		                       
		                       
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
<form id="form1">
Enter your Name:
<input type="text" id="user"/>
<ul>
<li>
<a href="#home">
<div id="tablediv">
<!-- <table cellspacing="0" id="countrytable"> 
    <tr> 
        <th scope="col">Projectid</th> 
        <th scope="col">ProjectName</th> 
        <th scope="col">ProjectStartDate</th> 
        <th scope="col">ProjectEndDate</th> 
        <th scope="col">TeamID</th>          
    </tr> 
</table> -->
</div>
</a>
</li>
</ul>

</form>
</body>
</html>