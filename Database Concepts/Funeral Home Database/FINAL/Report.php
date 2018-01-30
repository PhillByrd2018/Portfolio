<!DOCTYPE html>



<html lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>SiteGround System Page Coming Soon</title>
	<link href="//www.siteground.com/css/systempages.css" media="screen, handheld" rel="stylesheet" type="text/css" />
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
	
	
<style>

body {
  margin:0;
  padding:0;
  height: 100%;
  width: 100%;
}

#container {
  position: absolute;
  height: 100%;
  width: 100%;
  overflow: hidden;
}

#nav {
  background-color:#c3b9f7;
  color: white;
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 80px;
}

#content-wrapper {
    position:absolute;
    top:80px;
    bottom:80px;
    left:0;
    right:0;
  	background-color:white;
  	width: 100%;
    overflow:scroll;
		padding-bottom: 200px;
		padding-left: 35px;
		padding-top: 10px;
		font-size: 200%
		
}

#footer {
  background-color: black;
  position: fixed;
  left: 0;
  bottom: 0;
  height: 80px;
  width: 100%;
}
</style>	
</head>
<body>
<div id="container">
	  <div id="nav">

				<h2 style="text-align: center;vertical-align: middle;line-height: 80px;">Report Table</h2>

	  </div>

	  <div id="content-wrapper">
	
	





<h2>Data:</h2>

<br>

<h4>Number of Clients in the Database:</h4>

<?php

include "dbconnect.php";

$sql_old = "select COUNT(*) AS deadCount from Deceased";


$result_old = myquery($mysqli,$sql_old);


$row = $result_old->fetch_assoc();


echo $row['deadCount'];

?>

<br>
<hr>

<h4>Sum of Balances in the Database:</h4>

<?php




$sql = "select SUM(TotalAmount) AS DEADSum from Balances";


$result = myquery($mysqli,$sql);


$row = $result->fetch_assoc();


echo $row['DEADSum'];

?>
<br>
<hr>

<h4>Number of Burials in the Database:</h4>

<?php




$sql = "select Count(Service_Type) AS BurialCOUNT from Deceased WHERE Service_Type = 'Burial'";


$result = myquery($mysqli,$sql);


$row = $result->fetch_assoc();


echo $row['BurialCOUNT'];

?>

<br>
<hr>
<h4>Number of Cremations in the Database:</h4>
<?php




$sql = "select Count(Service_Type) AS CremationCOUNT from Deceased WHERE Service_Type = 'Cremation'";


$result = myquery($mysqli,$sql);


$row = $result->fetch_assoc();


echo $row['CremationCOUNT'];

?>
<br>
<a href="database.php"><button class='btn btn-primary'>Return to Database</button></a>

         <div id="footer">
			<img src="waiting.webp" style="position: fixed;left: 0;bottom: 0;height: 40%;">

			<ul class="nav justify-content-center" style="font-size:20px;text-align: center;vertical-align: middle;line-height: 60px;">
		
			  <li class="nav-item">
			    <a class="nav-link" style="color:#bfd2ef;" href="Report.php">Balances</a>
			  </li>

			</ul>


	  </div>

     </div>
	
	
</body>
</html>
