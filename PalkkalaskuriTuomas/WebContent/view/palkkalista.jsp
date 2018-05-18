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

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #1C1C1C;
    color: white;
}


</style>
</head>
<body>
<div class="header">
<h1>Palkat</h1>
</div>

<div class="column">



<button type="submit" class="btn" onclick="location.href = 'lisaa-palkka';">Lisää uusi palkka</button>

<table border="1">
	<tr>
		<th>PalkkaID</th>
    	<th>Nimi</th>
   		<th>Netto</th>
   		<th>Brutto</th>
   		<th>Toiminnot</th>
	</tr>
	<c:forEach items="${palkat}" var="palkka">
		<tr>
			<td><c:out value="${palkka.palkkaId}" /></td>
			<td><c:out value="${palkka.nimi}" /></td>
			<td><c:out value="${palkka.brutto}" /></td>
			<td><c:out value="${palkka.netto}" /></td>
			<td>
			<a href="poista-palkka?palkkaid=${palkka.palkkaId}">Poista</a>
			<a href="muuta-palkka?palkkaid=${palkka.palkkaId}">Muuta</a>
            </td>          
		</tr>
		
	</c:forEach>
</table>
</div>

<div class="footer">
<p>&copy; 2018 Tuomas Plattonen. Contact: tuomasplada@gmail.com</p>
</div>


</body>
</html>