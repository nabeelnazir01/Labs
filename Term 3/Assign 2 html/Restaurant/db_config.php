<?php 
$servername = "localhost";
$username = "eatery_eatery";
$password = "hello";
$dbname = "username_eatery";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
//echo "Connected successfully";

?>