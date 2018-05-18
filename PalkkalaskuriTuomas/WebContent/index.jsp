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
<h1>Tuomaksen palkkalaskuri</h1>
</div>

<div class="column">
<button type="submit" class="btn" onclick="location.href = 'laske-brutto';">Laske bruttopalkkasi</button>
<br /> 
<button type="submit" class="btn" onclick="location.href = 'laske-netto';">Laske nettopalkkasi</button>
<br />  
<button type="submit" class="btn" onclick="location.href = 'listaa-palkat';">Listaa palkat</button>
<br />  
<button type="submit" class="btn" onclick="location.href = 'https://github.com/tplattonen/PalkkalaskuriTuomas';">Linkki Git Hubiin</button>
<p>PalkkalaskuriTuomas on ohjelmointi SWD1TN002-27 kursilla tehty harjoitustyö.
Nimensä mukaisesti palvelussa voi laskea oman brutto- ja nettopalkkansa, ja tämän
jälkeen tallentaa saadut tiedot tietokantaan myöhempää tarkastelua varten. 
Palkkoja ei ole pakko tallentaa, eli palvelua voi käyttää myös vain palkan laskuun.
Muuta palkka toimintoa en saanut toimimaan, jätin koodin ja servletin kuitenkin osaksi
palvelua mahdollista jatkokehittelyä varten.
</p>
<img src="./css/PalkkalaskuriTuomas- java-luokkakaavio.png" height="310" width=100% alt="indexi">
<p>

</p>
 </div>

<div class="footer">
  <p>&copy; 2018 Tuomas Plattonen. Contact: tuomasplada@gmail.com</p>
</div>



</body>
</html>