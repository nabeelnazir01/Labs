<?php
session_start();

function test_input($data)
{
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

$host = "localhost";
$username = "root";
$password = "NibsOneal456";
$database = "lab9";

$invalid_login = False;
$_SESSION["valid_login"] = False;

$error = "";
if (isset($_POST['email']) && isset($_POST['pass'])) {
    $_SESSION["email"] = $email = test_input($_POST["email"]);
    $_SESSION["pass"] = $pass = test_input($_POST["pass"]);

    include 'AccountDetails.php';

    if ($connect == FALSE) {
        die("Connection Failed: " . mysqli_connect_error());
    }

    $sql = "SELECT * FROM `Employee` WHERE `EmailAddress` LIKE '$email' AND `Password` LIKE '$pass'";
    $result = mysqli_query($connect, $sql);
    $row = mysqli_fetch_assoc($result);

    if (mysqli_num_rows($result) == 0) {
        $invalid_login = True;
    } else if ($row["EmailAddress"] == $email) {
        if ($row["Password"] == $pass) {
            $_SESSION["valid_login"] = True;
        } else {
            $invalid_login = True;
        }
    }

    mysqli_close($connect);

    if ($_SESSION["valid_login"]) {
        header('Location: ViewAllEmployees.php');
    }
}
?>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="Stylesheet.css" rel="stylesheet">
    <title>Login</title>
</head>

<body class="px-3">
    <div id="Head">
        <div class="container-fluid">
            <div class="row justify-content-center mt-3">
                <?php include_once 'header.php'; ?>
            </div>
            <div class="row justify-content-end">
                <div class="col-2" id=Menu>
                    <?php include_once 'menu.php'; ?>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mt-3" id="Content">
        <form method="post">
            <label>Email Address</label><br>
            <input type="email" name="email" required><br>
            <label>Password</label><br>
            <input type="password" name="pass" required><br>
            <button type="submit" name="submit">Login</button>
        </form>
    </div>
    <div class="container-fluid mt-3" id="Footer">
        <div class="row p-3">
            <div class="col">
                <?php include_once 'footer.php'; ?>
            </div>
        </div>
    </div>
</body>

</html>