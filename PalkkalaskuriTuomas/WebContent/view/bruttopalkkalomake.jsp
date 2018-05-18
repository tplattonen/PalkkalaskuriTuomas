<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PalkkalaskuriTuomas</title>
<meta name="author" content="Tuomas Plattonen">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="./css/styles.css" rel="stylesheet" type="text/css" />
<link href='https://fonts.googleapis.com/css?family=IM+Fell+English+SC' rel='stylesheet'>
<style>
.btn {
     width: 100%;
    background-color: #424242;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
.btn:hover {
    background-color: #1C1C1C;
}
</style>

</head>

<body>
<div class="header">
<h1>Laske bruttopalkka</h1>
</div>
	
	<div class="column">
	<form method="post" name="myForm" onsubmit="return validateForm()">
		<label>Syötä tuntipalkkasi:</label>
		<input type="text" name="tuntipalkka" onkeypress='validate(event)'/>	<br />
		<label>Syötä kuukaudessa tehdyt työtunnit:</label>
		<input type="text" name="kktunnit" onkeypress='validate(event)'/> <br />
		<input type="submit" value="Laske bruttopalkka" />
		
	</form>
	<div class="brutto">
	<p>Bruttopalkkasi on <c:out value="${bruttopalkka}"></c:out></p> <br /> 
	</div>
	<!-- <a href="laske-netto?bruttopalkka=${bruttopalkka}" >Laske nettopalkka</a> --> <br /><br />  
	
	
	<button type="submit" class="btn" onclick="location.href = 'laske-netto?bruttopalkka=';">Laske nettopalkka</button>
	
	 </div>
	
	<script>
	function validateForm() {
		var x = document.forms["myForm"]["tuntipalkka"].value;
		var xx = document.forms["myForm"]["kktunnit"].value;
	    if (x == "" || xx == "") {
	        alert("Täytä tyhjät kentät!");
	        return false;
	    	}
    
	}
	
	function validate(evt) {
		  var theEvent = evt || window.event;
		  var key = theEvent.keyCode || theEvent.which;
		  key = String.fromCharCode( key );
		  var regex = /[0-9]|\./;
		  if( !regex.test(key) ) {
		    theEvent.returnValue = false;
		    if(theEvent.preventDefault) theEvent.preventDefault();
		  }
		}
	</script>
	
	
	<div class="footer">
  	<p>&copy; 2018 Tuomas Plattonen. Contact: tuomasplada@gmail.com</p>
	</div>
</body>
</html>