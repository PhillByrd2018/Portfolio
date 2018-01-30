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

				<h2 style="text-align: center;vertical-align: middle;line-height: 80px;">Services Table</h2>

	  </div>

	  <div id="content-wrapper">
<?php
include "dbconnect.php";

$sql = "insert into Service_Info (ContractID, Service_Type, Service_Official, Service_Location, Service_Date ) values(" .
  $_REQUEST["ID"] . ",'" .
  $_REQUEST["Service_Type"] . "','" .
  $_REQUEST["Service_Official"] . "','" .
  $_REQUEST["Service_Location"] . "','" .
  $_REQUEST["Service_Date"] . "')";


myquery($mysqli,$sql);

?>

<h2>You have successfully added a entry to the Database<span style='color:green;'>(Service Info).</span></h2>
<hr>
<br>
<br>
<table class="table" style="background-color:white;font-size:20px;">
<tr style="background-color:black; color:white;">
<th>Contract ID</th>
<th>Service Type</th>
<th>Service Official</th>
<th>Service Location</th>
<th>Service Date</th>
</tr>
<?php

$sql_print = "select * from Service_Info where ContractID= '" . $_REQUEST["ID"] . "'";



$ID;
$result_print = myquery($mysqli,$sql_print);

while($row_print = $result_print->fetch_assoc()) {
  echo "<tr>";
  echo '<td>' . $row_print['ContractID'] . '</td>';
  echo '<td>' . $row_print['Service_Type'] . '</td>';
  echo '<td>' . $row_print['Service_Official'] . '</td>';
  echo '<td>' . $row_print['Service_Location'] . '</td>';
  echo '<td>' . $row_print['Service_Date'] . '</td>';
  echo "</tr>";
  
  $ID = $row_print['ContractID'];
  
}



	echo '</table>';
	echo '<br>';
	echo '<hr>';
	echo '<h2>Proceed to fillout additional Plot Info.</h2>';
	echo "<a href='addPlotCLT.php?id=" . $ID ."'><button class='btn btn-info'>Plot Info</button></a>";
	
?>
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
