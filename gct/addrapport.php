<?php

require_once 'connectdb.php';


 $data = $_POST['data']; 




try{

    $sql="INSERT INTO `rapport` (`id_rapport`, `data`) VALUES (NULL, '$data');";
     

 
if (mysqli_query($conn, $sql)) {
   
 }
else{
 }

}
catch(PDOException $e)
   {
       echo ($e->getMessage ()) ; 
   }



$conn->close();








?>