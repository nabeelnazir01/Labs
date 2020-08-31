<?php include("header.php"); ?>

<div id="content" class="clearfix">
    <aside>
        <h2>Mailing Address</h2>
        <h3>1385 Woodroffe Ave<br>
            Ottawa, ON K4C1A4</h3>
        <h2>Phone Number</h2>
        <h3>(613)727-4723</h3>
        <h2>Fax Number</h2>
        <h3>(613)555-1212</h3>
        <h2>Email Address</h2>
        <h3>info@wpeatery.com</h3>
    </aside>
    <div class="main">
    <?php
        include 'db_config.php';

        // Attempt select query execution
        $sql = "SELECT * FROM mailingList";
        echo "<h3>Mailing List</h3>";
        if ($result = mysqli_query($conn, $sql)) {
            if (mysqli_num_rows($result) > 0) {
                echo "<table>";
                echo "<tr>";
                echo "<th>Full Name</th>";
                echo "<th>Email Address</th>";
                echo "<th>Phone</th>";
                echo "</tr>";
                while ($row = mysqli_fetch_array($result)) {
                    echo "<tr>";
                    echo "<td>" . $row['firstName'] . " " . $row['lastName'] . "</td>";
                    echo "<td>" . $row['emailAddress'] . "</td>";
                    echo "<td>" . $row['phoneNumber'] . "</td>";
                    echo "</tr>";
                }
                echo "</table>";
                // Free result set
                mysqli_free_result($result);
            } else {
                echo "No records have been found.";
            }
        } else {
            echo "ERROR: Could not able to execute $sql. " . mysqli_error($conn);
        }

        // Close connection
        mysqli_close($conn);
        ?>
    </div><!-- End Main -->
</div><!-- End Content -->

<?php include("footer.php"); ?>