<?php
header("Access-Control-Allow-Origin: *");

$server="127.0.0.1";
$username="root";
$password="";
$dbname="gct";

$conn=mysqli_connect($server,$username,$password,$dbname);
if (!$conn)

echo "not connected to database";

mysqli_set_charset($conn, 'utf8');

 

?>
