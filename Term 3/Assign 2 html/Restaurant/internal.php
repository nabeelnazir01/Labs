<?php
session_start();
if ($_SESSION['valid_login'] != True) {
    header('Location: Login.php');
    exit;
}
?>
<?php include 'header.php'; ?>


<div id="content" class="clearfix">
<?php echo "Admin ID: " . $_SESSION['AdminID'] . " | Admin Level: " . $_SESSION['AdminLevel'] . " | Last Login: " . $_SESSION['Lastlogin']; ?>
    <p>&nbsp;</p>
    <h1>Internal Page</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam et scelerisque ex. Nam tempus pulvinar condimentum. Morbi leo ipsum, feugiat ac neque nec, euismod posuere sapien. Nullam porta ligula et nibh malesuada condimentum. Praesent convallis, arcu quis vestibulum aliquet, purus sapien feugiat metus, iaculis bibendum turpis nulla vel orci. Cras nulla purus, vestibulum at varius sed, placerat a lacus. Sed id scelerisque libero.</p>
    <p>Sed eu eros sit amet neque efficitur pellentesque sed a odio. Sed faucibus ullamcorper nunc, sed dignissim mi placerat vitae. Integer porta vitae eros at mattis. Sed porta urna et odio cursus placerat nec vitae nulla. Maecenas aliquam commodo ante, ac interdum risus pulvinar ac. Duis suscipit, lorem in rhoncus pretium, massa dolor varius felis, in fermentum purus erat a felis. Morbi eu sagittis velit, a laoreet risus.</p>
    <p>Pellentesque condimentum arcu in hendrerit tincidunt. Cras velit nisl, tincidunt nec libero eu, sagittis commodo leo. Cras dignissim orci ac nunc viverra, sed iaculis orci varius. Mauris venenatis tellus sed neque auctor, sit amet laoreet leo lacinia. Vestibulum sit amet mi libero. Donec vehicula dui sed leo imperdiet tincidunt. Aliquam maximus augue id erat iaculis malesuada.</p>
    <p>Sed in tristique massa, fermentum porta eros. Nam pretium ligula in tortor bibendum iaculis. Mauris quis nisl massa. Ut ultrices elementum dolor, maximus iaculis magna vestibulum at. Nam imperdiet ante at arcu fermentum vestibulum. Pellentesque imperdiet purus ut congue auctor. Nullam condimentum tincidunt dui at consequat. Quisque quis bibendum nibh, ut eleifend turpis. Suspendisse ante diam, facilisis et iaculis semper, egestas eget neque. Mauris vulputate venenatis sapien non luctus. In tristique iaculis leo, eget molestie risus cursus eu. Nam sit amet sapien eu enim iaculis posuere.</p>
    <a href='logout.php'>Logout</a>
</div><!-- End Content -->


<?php include 'footer.php'; ?>