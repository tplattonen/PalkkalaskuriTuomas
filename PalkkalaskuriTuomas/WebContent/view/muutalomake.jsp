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

</head>
<body>
	<div class="header">
	<h1>Muuta palkan tiedot</h1>
	</div>
	
	<div class="column">
	
	<!--Ongelman on, että en saa palkkaid siirrettyä jsp to jsp-->
	
	<form method="post"  name="myForm" onsubmit="return validateForm()">
	
	 
      <input type="hidden" name="palkkaid" value="${palkka.palkkaId}" />
    
		<label>Anna palkansaajan nimi:</label> 
		<input type="text" name="nimi" /> <br />
		<label>Anna bruttopalkka:</label> 
		<input type="text" name="brutto"  onkeypress='validate(event)'/> <br />
		<label>Anna nettopalkka:</label> 
		<input type="text" name="netto"  onkeypress='validate(event)'/> <br />
		<input type="submit" value="Tallenna" />
		<input type="submit" value="Peruuta" />
	</form>
</div>

<script>
function validateForm() {
	var y = document.forms["myForm"]["palkkaid"].value;
	var x = document.forms["myForm"]["nimi"].value;
    var xx = document.forms["myForm"]["brutto"].value;
    var xxx = document.forms["myForm"]["netto"].value;
    if (y == "" || x == "" ||  xx == "" || xxx == "") {
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