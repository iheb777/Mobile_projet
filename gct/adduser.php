<?php

require_once 'connectdb.php';


$user = $_POST['user'];
$password = $_POST['password']; 
$role = $_POST['role']; 




try{

    $sql="INSERT INTO `users` (`id`, `user`, `password`, `role`) VALUES (NULL, '".$user."', '".$password."', '".$role."');";
     

 
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