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
    <title>ChessBoard</title>
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
        <h3>Chess Board</h3>
        <table style="margin-left:auto;margin-right:auto;">
            <?php
            for ($row = 1; $row <= 8; $row++) {
                echo "<tr>";
                for ($col = 1; $col <= 8; $col++) {
                    $total = $row + $col;
                    if ($total % 2 == 0) {
                        echo "<td height=30px width=30px bgcolor=black></td>";
                    } else {
                        echo "<td height=30px width=30px bgcolor=white></td>";
                    }
                }
                echo "</tr>";
            }
            ?>
        </table>
    </div>
</body>

</html>