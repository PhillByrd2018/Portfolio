<html lang="en">
<head>
  <meta charset="utf-8">

  <title>CSCI 332 Project</title>

 

  
  
  
  
  
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


 

<?php
include "dbconnect.php";




$sql = "Select userID, Password FROM Login_Info WHERE UserName = '" .
  $_REQUEST["Login_R"] . "'";








if (!$result = $mysqli->query($sql)) {
    echo "Error: User Does not exist!<br>";
    echo "Create a user and try again.<br>";
   
    exit;
}







$row = $result->fetch_assoc();
$userID;
$Pass;

	if($row['userID']!=null && $row['Password']!=null){
		$userID = $row['userID'];
		$Pass = $row['Password'];
	
	}
	


	
	
	if($userID == null || $Pass == null){
	echo "<h1>Error: User Does not exist!</h1><br>";
    	echo "<h1>Create a user and try again.</h1><br>";
    	echo $userID;
    	echo $Pass;
    	}
    	else if ($Pass != $_REQUEST["Password_R"]){
    	echo "<h1>Error: Password is Incorrect</h1><br>";
    	echo "<h1>Go back and try again.</h1><br>";
    	
    	}else{
    	header("Location:database.php");
    	}
?>
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


