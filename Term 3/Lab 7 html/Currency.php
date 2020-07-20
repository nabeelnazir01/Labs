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
    <title>Arrays</title>
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
            <label>Convert</label>
            <input type="number" step="0.01" min="0" name="srcant">
            <select name="basecurr">
                <?php
                $currencies = array("CAD" => "Canadian Dollar", "NZD" => "New Zealand Dollar", "USD" => "US DOLLAR");
                $rates = array("CAD" => 0.97645, "NZD" => 1.20642, "USD" => 1.0);
                foreach ($currencies as $key => $value) :
                    echo '<option value="' . $key . '">' . $value . '</option>';
                endforeach;
                ?>
            </select>
            <label>to</label>
            <select name="destcurr">
                <?php
                foreach ($currencies as $key => $value) :
                    echo '<option value="' . $key . '">' . $value . '</option>';
                endforeach;
                ?>
            </select>
            <button type="submit" name="test">Convert</button>
        </form>
        <?php
        if (array_key_exists('test', $_POST)) {
            $converted_output = ($_POST["srcant"]/$rates[$_POST["basecurr"]])*$rates[$_POST["destcurr"]];
            echo "<h4>Conversion Results</h4>";
            echo number_format($_POST["srcant"], 2) . " " . $currencies[$_POST["basecurr"]] . " converts to " .  number_format($converted_output, 2) . " " . $currencies[$_POST["destcurr"]];
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