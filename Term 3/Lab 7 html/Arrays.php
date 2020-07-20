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
        <?php
        $noKeyArray = array(10, 20, 30, 40);
        $stringKeyArray = array("key1" => "item1", "key2" => "item2");
        $intKeyArray = array(0 => "item1", 1 => "item2", 3 => "item3");
        $mixedKeyArray = array("key1" => "item1", "key2" => "item2", 2 => "item8", 4 => "item4", 5 => "item5", 3 => "item 6", 1 => "item7");
        $multiDimensionArray = array(array(10, 20), array(30, 40));
        echo "<h4>No Key Array - Output using var_dump</h4>";
        var_dump($noKeyArray);
        echo "<h4>No Key Array - Output using foreach</h4>";
        foreach ($noKeyArray as $key => $value) {
            echo "<br>key: $key, value: $value, key data type: " . gettype($key);
        }
        echo "<h4>String Key Array - Output using var_dump</h4>";
        var_dump($stringKeyArray);
        echo "<h4>String Key Array - Output using foreach</h4>";
        foreach ($stringKeyArray as $key => $value) {
            echo "<br>key: $key, value: $value, key data type: " . gettype($key);
        }
        echo "<h4>Integer Key Array - Output using var_dump</h4>";
        var_dump($intKeyArray);
        echo "<h4>Integer Key Array - Output using foreach</h4>";
        foreach ($intKeyArray as $key => $value) {
            echo "<br>key: $key, value: $value, key data type: " . gettype($key);
        }
        echo "<h4>Mixed Key Array - Output using var_dump</h4>";
        var_dump($mixedKeyArray);
        echo "<h4>Mixed Key Array - Output using foreach</h4>";
        foreach ($mixedKeyArray as $key => $value) {
            echo "<br>key: $key, value: $value, key data type: " . gettype($key);
        }
        echo "<h4>Multi-dimensional Array - Output using var_dump</h4>";
        var_dump($multiDimensionArray);
        echo "<h4>Multi-dimensional Array - Output using foreach</h4>";
        foreach ($multiDimensionArray as $key => $value) {
            echo "Level 1 key: $key<br>";
            foreach ($value as $k=>$v){ 
            echo "Level 2 key: $k, value: $v, key data type: " . gettype($key) . "<br>";
            }
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