<?php
session_start();
if (isset($_POST['submit'])) {
    $values = array("eName", "eID", "tNum", "eAdd", "pos", "project");
    foreach ($values as $key) :
        $_SESSION[$key] = $_POST[$key];
    endforeach;
    header('Location: Session2.php');
    exit;
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
            <h3>Application Form</h3>
            <label>Employee Name</label><br>
            <input type="text" name="eName" required><br>
            <label>Employee ID</label><br>
            <input type="text" name="eID" required><br>
            <label>Telephone Number</label><br>
            <input type="tel" name="tNum" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" required><br>
            <label>Email Address</label><br>
            <input type="email" name="eAdd" required><br>
            <h4>Position</h4>
            <label for="A">Manager</label>
            <input type="radio" id="man" name="pos" value="Manager" required><br>
            <label>Team Lead</label>
            <input type="radio" id="lead" name="pos" value="Team Lead"><br>
            <label>IT Developer</label>
            <input type="radio" id="ITdev" name="pos" value="IT Developer"><br>
            <label>IT Analyst</label>
            <input type="radio" id="ITan" name="pos" value="IT Analyst"><br>
            <h4>Project</h4>
            <select name="project" id="project" required>
                <option value="" selected hidden>
                    Select an Option
                </option>
                <option value="A">Project A</option>
                <option value="B">Project B</option>
                <option value="C">Project C</option>
                <option value="D">Project D</option>
            </select><br><br>
            <button type="submit" name="submit">Submit Information</button>
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