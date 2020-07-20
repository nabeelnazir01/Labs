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
    <title>Index</title>
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
        $first = "Nabeel";
        $middle = "Ahmad";
        $last = "Nazir";
        $word1 = "Hello World!!";
        $word2 = "This is the first time I am using PHP!!";
        define("STUDENT_NUMBER", "040974403");
        echo "<p>$first $middle $last</p>";
        echo "<p>" . STUDENT_NUMBER . "</p>";
        echo "<p>" . $word1 . " " . $word2 . "</p>";
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