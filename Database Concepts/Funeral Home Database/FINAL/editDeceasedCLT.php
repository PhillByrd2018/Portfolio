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

				<h2 style="text-align: center;vertical-align: middle;line-height: 80px;">Edit Entry</h2>

	  </div>

	  <div id="content-wrapper">
<?php
require_once 'dbconnect.php';

$sql = "select * from Deceased where Contractid=" . $_REQUEST['id'];

$result = myquery($mysqli,$sql);

if (!$result = $mysqli->query($sql)) {
    echo "Errno: " . $mysqli->errno . "</br>";
    echo "Error: " . $mysqli->error . "</br>";
    exit;

}
?>
<table class="table" style="background-color:white;font-size:20px;">
<tr style="background-color:black; color:white;">
<th>Contract ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Date of Birth</th>
<th>Date of Death</th>
<th>Age</th>
<th>Service Type</th>
</tr>

<?php
$id;
$first;
$last;
$DOB;
$DOD;
$Age;
$Ser;

while($row = $result->fetch_assoc()) {
  echo "<tr>";
  echo '<td>' . $row['ContractID'] . '</td>';
  echo '<td>' . $row['firstName'] . '</td>';
  echo '<td>' . $row['lastName'] . '</td>';
  echo '<td>' . $row['DOB'] . '</td>';
  echo '<td>' . $row['DOD'] . '</td>';
  echo '<td>' . $row['Age'] . '</td>';
  echo '<td>' . $row['Service_Type'] . '</td>';
  echo "</tr>";
  $id=$row['ContractID'];
  $first=$row['firstName'];
  $last=$row['lastName'];
  $DOB=$row['DOB'];
  $DOD=$row['DOD'];
  $Age=$row['Age'];
  $Ser=$row['Service_Type'];
  
}
	echo '</table>';
	echo '<br>';
	echo '<hr>';
	echo '<h3>Are you sure you want to edit this entry?</h3>';
	
	echo '<br>';	

?>













<table>
<form action="editDeceasedSRV.php" method="get">
<tr>
<td>
</td><td><input type="hidden" name="id" value=<?php echo $id; ?>></td>
</tr>
<tr>
<td>
First Name:</td><td><input type="text" name="firstname" value=<?php echo $first; ?>></td>
</tr>

<tr>
<td>Last Name:</td><td><input type="text" name="lastname" value=<?php echo $last; ?>> </td>
</tr>

<tr>
<td>Date of Birth:</td><td><input type="date" name="DOB" value=<?php echo $DOB; ?>></td>
</tr>

<tr>
<td>Date of Death:</td><td><input type="date" name="DOD" min="0" max="100" value=<?php echo $DOD; ?>></td>
</tr>

<tr>
<td>Age:</td><td><input type="number" name="Age" min="0" max="100" value=<?php echo $Age; ?>></td>
</tr>

<tr>
<td>Service Type:</td><td><input type="radio" name="Service_Type" value="Burial" checked>Burial
<input type="radio" name="Service_Type" value="Cremation"/>Cremation</td>
</tr>

<tr>
<td>
<br>
<button type='submit' class='btn btn-success'>Submit Changes</button>
</td>
</tr>
</form>
</table>
<div id="footer">
			<img src="flower.gif" style="position: fixed;left: 0;bottom: 0;height: 40%;">

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





