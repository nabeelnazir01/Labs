<?php
session_start();

function test_input($data)
{
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}
$invalid_login = False;
$_SESSION["valid_login"] = False;

$error = "";
if (isset($_POST['user']) && isset($_POST['pass'])) {
    $_SESSION["user"] = $user = test_input($_POST["user"]);
    $_SESSION["pass"] = $pass = test_input($_POST["pass"]);

    include 'db_config.php';

    if ($conn == FALSE) {
        die("Connection Failed: " . mysqli_connect_error());
    }

    $sql = "SELECT * FROM `adminusers` WHERE `Username` LIKE '$user' AND `Password` LIKE '$pass'";
    $result = mysqli_query($conn, $sql);
    $row = mysqli_fetch_assoc($result);

    if (mysqli_num_rows($result) == 0) {
        $invalid_login = True;
        echo "<script type='text/javascript'>alert('Invalid Login!');</script>";
    } else if ($row["Username"] == $user) {
        if ($row["Password"] == $pass) {
            $_SESSION["valid_login"] = True;
        } else {
            $invalid_login = True;
        }
    }

    if ($_SESSION["valid_login"]) {
        $adminID = $row["AdminID"];
        $date = date("Y-m-d");
        $sql = "UPDATE adminusers SET Lastlogin = '$date' WHERE AdminID = $adminID";
        mysqli_query($conn, $sql);
        $_SESSION["AdminID"] = $adminID;
        $_SESSION["AdminLevel"] = $row["AdminLevel"];
        $_SESSION["Lastlogin"] = $row["Lastlogin"];
        mysqli_close($conn);
        header('Location: internal.php');
    }
}
?>
<?php include("header.php");
?>

<div id="content" class="clearfix">
    <aside>
        <h2>Mailing Address</h2>
        <h3>1385 Woodroffe Ave<br>
            Ottawa, ON K4C1A4</h3>
        <h2>Phone Number</h2>
        <h3>(613)727-4723</h3>
        <h2>Fax Number</h2>
        <h3>(613)555-1212</h3>
        <h2>Email Address</h2>
        <h3>info@wpeatery.com</h3>
    </aside>
    <div class="main">
        <h1>Login</h1>
        <form method="post">
            <label>Username</label><br>
            <input type="text" name="user" required><br>
            <label>Password</label><br>
            <input type="password" name="pass" required><br>
            <button type="submit" name="submit">Login</button>
        </form>
    </div><!-- End Main -->
</div><!-- End Content -->

<?php include("footer.php"); ?>