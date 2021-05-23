<?php

require_once 'connectdb.php';


$id = $_POST['id'];




try{

    $sql="DELETE FROM `users` WHERE `users`.`id` =".$id;
     

 
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