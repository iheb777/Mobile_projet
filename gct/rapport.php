<?php

include ('connectdb.php'); 
 


	
 
try
{ 
  
    $sql="SELECT * FROM `rapport`";

$res=mysqli_query($conn , $sql);

if(mysqli_num_rows($res) > 0){
$data = mysqli_fetch_all($res,MYSQLI_ASSOC);
echo json_encode(["success"=>1,"rapport"=>$data]);
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