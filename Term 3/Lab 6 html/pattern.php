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
    <title>Pattern</title>
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
            <label>Height:</label>
            <input type="number" name="Height">
            <label>Width:</label>
            <input type="number" name="Width">
            <button type="submit" name="test">Submit</button>
        </form>
        <?php
        $box = '';
        if (array_key_exists('test', $_POST)) {
            $box .= "<p style = 'font-family: Consolas;'>";
            for ($i = 0; $i < $_POST["Width"]; $i++) {
                $box .= "*";
            }
            for ($i = 0; $i < $_POST["Height"] - 2; $i++) {
                $box .= "<br>";
                $box .= "*";
                for ($e = 0; $e < $_POST["Width"] - 2; $e++) {
                    $box .= "&ensp;";
                }
                $box .= "*";
            }
            $box .= "<br>";
            for ($i = 0; $i < $_POST["Width"]; $i++) {
                $box .= "*";
            }
            $box .= "</p>";
            echo $box;
        }
        ?>
    </div>
</body>

</html>