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
        <h1>Sign up for our newsletter</h1>
        <p>Please fill out the following form to be kept up to date with news, specials, and promotions from the WP eatery!</p>
        <form name="frmNewsletter" id="frmNewsletter" method="post">
            <table>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="customerfName" id="customerfName" size='40' required></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="customerlName" id="customerlName" size='40' required></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="tel" name="phoneNumber" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" id="phoneNumber" size='40' required></td>
                </tr>
                <tr>
                    <td>Email Address:</td>
                    <td><input type="email" name="emailAddress" id="emailAddress" size='40' required>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" id="username" size='20' required>
                </tr>
                <tr>
                    <td>How did you hear<br> about us?</td>
                    <td>
                        <select name="referral" size="1" required>
                            <option value="" selected hidden>Select referer</option>
                            <option value="newspaper">Newspaper</option>
                            <option value="radio">Radio</option>
                            <option value="tv">Television</option>
                            <option value="other">Other</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan='2'><input type='submit' name='btnSubmit' id='btnSubmit' value='Sign up!'>&nbsp;&nbsp;<input type='reset' name="btnReset" id="btnReset" value="Reset Form"></td>
                </tr>
            </table>
        </form>
        <?php
        if (isset($_POST['btnSubmit'])) {
            include 'db_config.php';
            $name = $_POST["customerfName"];
            $lname = $_POST["customerlName"];
            $phone = $_POST["phoneNumber"];
            $email = $_POST["emailAddress"];
            $user = $_POST["username"];
            $ref = $_POST["referral"];
            $sql = "INSERT INTO mailingList (firstName, lastName, phoneNumber, emailAddress, userName, referrer)
VALUES ('$name', '$lname', '$phone', '$email', '$user', '$ref')";
            if ($conn->query($sql) === TRUE) {
                echo "Account Created Successfully";
            } else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }

            $conn->close();
        }
        ?>
    </div><!-- End Main -->
</div><!-- End Content -->

<?php include("footer.php"); ?>