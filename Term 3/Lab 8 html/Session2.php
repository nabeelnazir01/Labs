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
    <title>Session 2</title>
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
        <?php
        session_start();
        $values = array("eName", "eID", "tNum", "eAdd", "pos", "project");
        foreach ($values as $key) :
            $_SESSION[$key] = isset($_SESSION[$key]) ? $_SESSION[$key] : "Was not set by the form";
        endforeach;
        echo "<p> Employee Name: " . $_SESSION["eName"] . "</p>";
        echo "<p> Employee ID: " . $_SESSION["eID"] . "</p>";
        echo "<p> Telephone Number: " . $_SESSION["tNum"] . "</p>";
        echo "<p> Email Address: " . $_SESSION["eAdd"] . "</p>";
        echo "<p> Position: " . $_SESSION["pos"] . "</p>";
        echo "<p> Project: " . $_SESSION["project"] . "</p>";
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