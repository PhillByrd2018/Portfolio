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

				<h2 style="text-align: center;vertical-align: middle;line-height: 80px;">Next of Kin Table</h2>

	  </div>

	  <div id="content-wrapper">
<a href="database.php"><button class='btn btn-primary'>Return to Database</button></a>
<?php
include "dbconnect.php";
?>
<h2>Cause of Death Information:</h2>
<table class="table table-dark" style="border-top:none">
<tr style="background-color:black; color:white;">
<th>Contract ID</th>
<th>Cause of Death</th>
<th>Suspected Foul Play</th>
<th>Gender</th>
<th>Height</th>
<th>Weight</th>
</tr>

<?php
$sql = "select * from Cause_of_Death where Contractid=" . $_REQUEST['id'];




$result = myquery($mysqli,$sql);

while($row = $result->fetch_assoc()) {
  echo "<tr>";
  echo '<td>' . $row['ContractID'] . '</td>';
  echo '<td>' . $row['C_O_D'] . '</td>';
  echo '<td>' . $row['Foul_Play'] . '</td>';
  echo '<td>' . $row['Sex'] . '</td>';
  echo '<td>' . $row['height'] . '</td>';
  echo '<td>' . $row['weight'] . '</td>';
  echo "</tr>";
}
?>
</table>

<br>
<hr class="style18">
<hr class="style18">
<hr class="style18">
<br>


<h2>For client:</h2>

<table class="table table-dark" style="border-top:none">
<tr style="background-color:black; color:white;">
<th>Contract ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Date of Birth</th>
<th>Date of Death</th>
<th>Age</th>
<th>Service Type</th>


<?php


$sql_old = "select * from Deceased where Contractid=" . $_REQUEST['id'];
$result_old = myquery($mysqli,$sql_old);

while($row = $result_old->fetch_assoc()) {
  echo "<tr>";
  echo '<td>' . $row['ContractID'] . '</td>';
  echo '<td>' . $row['firstName'] . '</td>';
  echo '<td>' . $row['lastName'] . '</td>';
  echo '<td>' . $row['DOB'] . '</td>';
  echo '<td>' . $row['DOD'] . '</td>';
  echo '<td>' . $row['Age'] . '</td>';
  echo '<td>' . $row['Service_Type'] . '</td>';
  echo "</tr>";
}
?>
</table>
<div id="footer">
			<img src="waiting.webp" style="position: fixed;left: 0;bottom: 0;height: 40%;">

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
