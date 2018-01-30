<?php
$mysqli = new mysqli('127.0.0.1', 'phill664_ADMIN', 'sesame', 'phill664_CSCI_332');
function myquery($mysqli,$sql) {
  if (!$result = $mysqli->query($sql)) {
    echo "Errno: " . $mysqli->errno . "</br>";
    echo "Error: " . $mysqli->error . "</br>";
    exit;
  }
  return $result;
}




if ($mysqli->connect_errno) {
    echo "Error: Failed to make a MySQL connection, here is why: </br>";
    echo "Errno: " . $mysqli->connect_errno . "</br>";
    echo "Error: " . $mysqli->connect_error . "</br>";
    
    exit;
}
?>