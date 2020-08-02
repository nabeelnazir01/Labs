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
    <title>Session 1</title>
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
        <form method="POST">
            <h3>Create your new account</h3>
            <label>First Name</label><br>
            <input type="text" name="eName" required><br>
            <label>Last Name</label><br>
            <input type="text" name="eLName" required><br>
            <label>Email Address</label><br>
            <input type="email" name="eAdd" required><br>
            <label>Telephone Number</label><br>
            <input type="tel" name="tNum" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" required><br>
            <label>SIN</label><br>
            <input type="number" name="SIN" required><br>
            <label>Password</label><br>
            <input type="password" name="pass" required><br>
            <button type="submit" name="submit">Submit Information</button>
        </form>
        <?php
        if (isset($_POST['submit'])) {
            $host = "localhost";
            $username = "root";
            $password = "";
            $database = "lab9";
            $conn = new mysqli($host, $username, $password, $database);
            $name = $_POST["eName"];
            $lname = $_POST["eLName"];
            $email = $_POST["eAdd"];
            $phone = $_POST["tNum"];
            $sin = $_POST["SIN"];
            $pass = $_POST["pass"];
            $sql = "INSERT INTO Employee (FirstName, LastName, EmailAddress, TelephoneNumber, SocialInsuranceNumber, Password)
VALUES ('$name', '$lname', '$email', '$phone', '$sin', '$pass')";
            if ($conn->query($sql) === TRUE) {
                echo "New record created successfully";
            } else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }

            $conn->close();
        }
        ?>
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