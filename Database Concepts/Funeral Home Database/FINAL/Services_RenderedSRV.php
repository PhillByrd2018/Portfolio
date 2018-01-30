<!DOCTYPE html>



<html lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>SiteGround System Page Coming Soon</title>
	
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-
               rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
	
	
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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
		padding-bottom: 400px;
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
div id="container">
	  <div id="nav">

				<h2 style="text-align: center;vertical-align: middle;line-height: 80px;">Services Rendered View</h2>

	  </div>

	  <div id="content-wrapper">






<table class="table table-dark" style="border-top:none">
<tr style="background-color:black; color:white;">
<th>Contract ID</th>
<th>Service Type</th>
<th>Service Official</th>
<th>Service Location</th>
<th>Service Date</th>
<th>Section</th>
<th>Plot Number</th>
<th>Vault</th>
<th>HeadStone</th>
</tr>

<?php

require_once 'dbconnect.php';



$sql_print = "select * from Services_rendered Where ContractID= '" . $_REQUEST["id"] . "'";



$ID;
$result_print = myquery($mysqli,$sql_print);

while($row_print = $result_print->fetch_assoc()) {
  echo "<tr>";
  echo '<td>' . $row_print['ContractID'] . '</td>';
  echo '<td>' . $row_print['Service_Type'] . '</td>';
  echo '<td>' . $row_print['Service_Official'] . '</td>';
  echo '<td>' . $row_print['Service_Location'] . '</td>';
  echo '<td>' . $row_print['Service_Date'] . '</td>';
  echo '<td>' . $row_print['Section'] . '</td>';
  echo '<td>' . $row_print['Plot_Number'] . '</td>';
  echo '<td>' . $row_print['Vault'] . '</td>';
  echo '<td>' . $row_print['HeadStone'] . '</td>';
  echo "</tr>";
  
  $ID = $row_print['ContractID'];
  
}



	echo '</table>';
	echo '<br>';
	echo '<hr>';
	echo "<a href='database.php?id=" . $ID ."'><button class='btn btn-primary'>Database</button></a>";
	
?>
<br>
<br>
<h2>Would you like to Calculate the Balance of Services Rendered?</h2>
<hr>
<button class="btn btn-danger" id="Balance">Balance</button>











<div id="showBalance" style="display:none;">

<h1>Total amount for Services Rendered is: </h1>
<?php
require_once 'dbconnect.php';

$sql_function = "select Calculator(".$ID.") as Calc";
//echo $sql_function;


$result_function = myquery($mysqli, $sql_function);
$row_function = $result_function->fetch_assoc();

$Amt = $row_function['Calc'];
echo '<h1 style="color:green">$'.$Amt.' Dollars</h1>';


  



?>

<hr>
<h2>Would you like to Update the Balance Sheets?</h2>



<form action='UpdateBal.php' method="get">
<input type='hidden' name='ContractID' value=<?php echo $ID; ?>>
<input type='hidden' name='TotalAMT' value=<?php echo $Amt; ?>>
<label>How Much Has Been Paid Towards This Account?</label>
<input type='number' name='Paid'>

<button type='submit' class='btn btn-success'>Update Balance</button>
</form>










</div>
<script>
$(document).ready(function(){
    
    $("#Balance").click(function(){
        $("#showBalance").show(1000);
    });
});
</script>
<div id="footer">
			<img src="bored.gif" style="position: fixed;left: 0;bottom: 0;height: 40%;">

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















