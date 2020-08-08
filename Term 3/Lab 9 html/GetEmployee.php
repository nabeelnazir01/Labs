<!DOCTYPE html>
<html>
<head>
<style>
table {
  width: 100%;
  border-collapse: collapse;
}

table, td, th {
  border: 1px solid black;
  padding: 5px;
}

th {text-align: left;}
</style>
</head>
<body>

<?php
$q = intval($_GET['q']);
include 'AccountDetails.php';
if (!$connect) {
  die('Could not connect: ' . mysqli_error($connect));
}

mysqli_select_db($connect,"Employee");
$sql="SELECT * FROM Employee WHERE EmployeeId = '".$q."'";
$result = mysqli_query($connect,$sql);

echo "<table>";
echo "<tr>";
echo "<th>First Name</th>";
echo "<th>Last Name</th>";
echo "<th>Email Address</th>";
echo "<th>Phone Number</th>";
echo "<th>SIN</th>";
echo "<th>Password</th>";
echo "</tr>";
while($row = mysqli_fetch_array($result)) {
    echo "<tr>";
    echo "<td>" . $row['FirstName'] . "</td>";
    echo "<td>" . $row['LastName'] . "</td>";
    echo "<td>" . $row['EmailAddress'] . "</td>";
    echo "<td>" . $row['TelephoneNumber'] . "</td>";
    echo "<td>" . $row['SocialInsuranceNumber'] . "</td>";
    echo "<td>" . $row['Password'] . "</td>";
    echo "</tr>";
}
echo "</table>";
mysqli_close($connect);
?>
</body>
</html>