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
		padding-bottom: 100px;
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

				<h2 style="text-align: center;vertical-align: middle;line-height: 80px;">Cause of Death Table</h2>

	  </div>

	  <div id="content-wrapper">
	    <div id="content">



<?php
include "dbconnect.php";

$sql = "insert into Cause_of_Death (ContractID, C_O_D, Foul_Play, Sex, height, weight) values(" .
  $_REQUEST["ID"] . ",'" .
  $_REQUEST["C_O_D"] . "','" .
  $_REQUEST["Foul_Play"] . "','" .
  $_REQUEST["Sex"] . "','" .
  $_REQUEST["height"] . "','" .
  $_REQUEST["weight"] . "')";


myquery($mysqli,$sql);

?>

<h2>You have successfully added a entry to the Database<span style='color:green;'>(Coroner Report)</span>.</h2>
<hr>
<br>
<br>
<table class="table" style="background-color:white;font-size:20px;">
<tr style="background-color:black; color:white;">
<th>Contract ID</th>
<th>Cause of Death</th>
<th>Suspected Foul Play</th>
<th>Sex</th>
<th>Height</th>
<th>Weight</th>
</tr>
<?php

$sql_print = "select * from Cause_of_Death where ContractID= '" . $_REQUEST["ID"] . "'";



$ID;
$result_print = myquery($mysqli,$sql_print);

while($row_print = $result_print->fetch_assoc()) {
  echo "<tr>";
  echo '<td>' . $row_print['ContractID'] . '</td>';
  echo '<td>' . $row_print['C_O_D'] . '</td>';
  echo '<td>' . $row_print['Foul_Play'] . '</td>';
  echo '<td>' . $row_print['Sex'] . '</td>';
  echo '<td>' . $row_print['height'] . '</td>';
  echo '<td>' . $row_print['weight'] . '</td>';
  echo "</tr>";
  
  $ID = $row_print['ContractID'];
  
}



	echo '</table>';
	echo '<br>';
	echo '<hr>';

?>
<h2> You have finished all the data entry for this Contract!</h2>
<a href="database.php"><button class='btn btn-primary'>Return to Database</button></a>
<div id="footer">
			

			<ul class="nav justify-content-center" style="font-size:20px;text-align: center;vertical-align: middle;line-height: 60px;">
			  <li class="nav-item">
			    <a class="nav-link" style="color:#bfd2ef;" href="#">Contract ID</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" style="color:#bfd2ef;" href="#">Balances</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" style="color:#bfd2ef;" href="#">Employee</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" style="color:#bfd2ef;" href="#">Cemetary</a>
			  </li>
			</ul>


	  </div>
	</div>
</body>
</html>