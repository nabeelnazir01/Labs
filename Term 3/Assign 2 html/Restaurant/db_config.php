<?php 
$servername = "localhost";
$username = "nabeelna_eatery";
$password = "ThisIsAGreat";
$dbname = "nabeelna_eatery";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
//echo "Connected successfully";

?>