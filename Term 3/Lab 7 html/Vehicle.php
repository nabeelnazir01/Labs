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
        interface Vehicle
        {
            public function displayVehicleInfo();
        }

        class LandVehicle implements Vehicle
        {
            protected $make;
            protected $model;
            protected $year;
            protected $price;

            function __construct($make, $model, $year, $price)
            {
                $this->make = $make;
                $this->model = $model;
                $this->year = $year;
                $this->price = $price;
            }

            function displayVehicleInfo()
            {
                return "Make: $this->make, Model: $this->model, Year: $this->year, Price: $this->price";
            }
        }
        class WaterVehicle implements Vehicle
        {
            protected $make;
            protected $model;
            protected $year;
            protected $price;

            function __construct($make, $model, $year, $price)
            {
                $this->make = $make;
                $this->model = $model;
                $this->year = $year;
                $this->price = $price;
            }

            function displayVehicleInfo()
            {
                echo "Make: $this->make, Model: $this->model, Year: $this->year, Price: $this->price";
            }
        }
        class Car extends LandVehicle
        {
            protected $speedLimit;
            function __construct($make, $model, $year, $price, $speedLimit)
            {
                $this->make = $make;
                $this->model = $model;
                $this->year = $year;
                $this->price = $price;
                $this->speedLimit = $speedLimit; 
            }

            function displayVehicleInfo()
            {
                return "Make: $this->make, Model: $this->model, Year: $this->year, Price: $this->price, Speed Limit: $this->speedLimit";
            }
        }
        class Boat extends WaterVehicle
        {
            protected $boatCapacity;
            function __construct($make, $model, $year, $price, $boatCapacity)
            {
                $this->make = $make;
                $this->model = $model;
                $this->year = $year;
                $this->price = $price;
                $this->boatCapacity = $boatCapacity; 
            }

            function displayVehicleInfo()
            {
                return "Make: $this->make, Model: $this->model, Year: $this->year, Price: $this->price, Boat Capacity: $this->boatCapacity";
            }
        }
        $car1 = new Car("Toyota", "Camry", 1992, 2000, 180);
        $car2 = new Car("Honda", "Accord", 2002, 6000, 200);
        $boat1 = new Boat("Mitsubishi", "Turbo", 1999, 20000, 18);
        $boat2 = new Boat("Hyundai", "XT", 2012, 26000, 8);
        echo "<h4>Car</h4><br>" . $car1->displayVehicleInfo() . "<br>";
        echo $car2->displayVehicleInfo() . "<br>";
        echo "<h4>Boat</h4><br>" . $boat1->displayVehicleInfo() . "<br>";
        echo $boat2->displayVehicleInfo();
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