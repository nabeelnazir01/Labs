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
    <title>Prime</title>
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
            <label>Range 1:</label>
            <input type="number" name="Range1">
            <label>Range 2:</label>
            <input type="number" name="Range2">
            <button type="submit" name="test">Submit</button>
        </form>
        <?php
        if (array_key_exists('test', $_POST)) {
            for ($i = $_POST["Range1"]; $i <= $_POST["Range2"]; $i++) {
                $counter = 0;
                for ($num = $i; $num >= 1; $num--) {
                    if ($i % $num == 0) {
                        $counter++;
                    }
                }
                if ($counter == 2) {
                    echo "<p>$i is a prime number</p>";
                }
            }
        }
        ?>
    </div>
</body>

</html>