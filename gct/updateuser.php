<?php

require_once 'connectdb.php';

$id = $_POST['id'];
$user = $_POST['user'];
$password = $_POST['password']; 
$role = $_POST['role'];

try{

    $sql="UPDATE `users` SET `user` = '$user', `password` = '$password', `role` = '$role' WHERE `users`.`id` = $id";

 
 
if (mysqli_query($conn, $sql)) {
   
   echo json_encode(["success"=>1]);
}
else{
   echo json_encode(["success"=>0]);
}

}
catch(PDOException $e)
   {
       echo ($e->getMessage ()) ; 
   }



$conn->close();






?>