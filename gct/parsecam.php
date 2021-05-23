<?php
include ('connectdb.php'); 
$dvr1info ="";
$dvr2info ="";
$nvrarpoinfo ="";
$extprincipalinfo ="";
$nvrdruinfo ="";
$camintinfo="";

$lines = file('./status.dat');

 foreach ($lines as $line_num => $line) {
     if ($line_num==88){
         $dvr1=$line;
     }
     if ($line_num==143){
        $dvr2=$line;
    }

     if ($line_num==1023){
      $nvrarpo=$line;
      }
      if ($line_num==1353){
        $extprincipal=$line;
     }
     if ($line_num==1408){
        $camint=$line;
     }
     if ($line_num==1463){
        $nvrdru=$line;
     }


  //echo "<b>{$line_num}</b> : " . htmlspecialchars($line) . "<br />\n";
}
 

$dvr1_val=(int)filter_var($dvr1, FILTER_SANITIZE_NUMBER_INT);
$dvr2_val=(int)filter_var($dvr2, FILTER_SANITIZE_NUMBER_INT);
$nvrarpo_val=(int)filter_var($nvrarpo, FILTER_SANITIZE_NUMBER_INT);
$extprincipal_val=(int)filter_var($extprincipal, FILTER_SANITIZE_NUMBER_INT);
$camint_val=(int)filter_var($camint, FILTER_SANITIZE_NUMBER_INT);
$nvrdru_val=(int)filter_var($nvrdru, FILTER_SANITIZE_NUMBER_INT);



  
    


    foreach ($lines as $line_num => $line) {
        if ($line_num>=61 && $line_num<=112){
            $dvr1info=$dvr1info.$line;
         }
         if ($line_num>=116 && $line_num<=167){
            $dvr2info=$dvr2info.$line;
         }
         if ($line_num>=996 && $line_num<=1047){
            $nvrarpoinfo=$nvrarpoinfo.$line;
         }
         if ($line_num>=1326 && $line_num<=1377){
            $extprincipalinfo=$extprincipalinfo.$line;
         }
         if ($line_num>=1436 && $line_num<=1487){
            $nvrdruinfo=$nvrdruinfo.$line;
         }
         if ($line_num>=1381 && $line_num<=1432){
            $camintinfo=$camintinfo.$line;
         }
        
        
        
            
         



   }

    
   echo json_encode(["success"=>1,"dvr1"=>$dvr1_val,"dvr2"=>$dvr2_val,"nvrarpo"=>$nvrarpo_val,"extprincipal"=>$extprincipal_val,"camint"=>$camint_val,"nvrdru"=>$nvrdru_val
   ,"dvr1info"=>$dvr1info,"dvr2info"=>$dvr2info,"nvrarpoinfo"=>$nvrarpoinfo,"extprincipalinfo"=>$extprincipalinfo
   ,"nvrdruinfo"=>$nvrdruinfo,"camintinfo"=>$camintinfo
   
   
   ]);


         
        



      //---------------Insertion a la base------------------//


      
     try
     { 
        
         $sql1="UPDATE `cam` SET `etat_cam` = '$dvr1_val' WHERE `cam`.`id_cam` = 1";
         $sql2="UPDATE `cam` SET `etat_cam` = '$dvr2_val' WHERE `cam`.`id_cam` = 2";
         $sql3="UPDATE `cam` SET `etat_cam` = '$nvrarpo_val' WHERE `cam`.`id_cam` = 3";

         $sql4="UPDATE `cam` SET `etat_cam` = '$extprincipal_val WHERE `cam`.`id_cam` = 4";
         $sql5="UPDATE `cam` SET `etat_cam` = '$camint_val' WHERE `cam`.`id_cam` = 5";
         $sql6="UPDATE `cam` SET `etat_cam` = '$nvrdru_val' WHERE `cam`.`id_cam` = 6";


 
        
  
   
 if (mysqli_query($conn, $sql1) && mysqli_query($conn, $sql2) && mysqli_query($conn, $sql3) 
 && mysqli_query($conn, $sql4)
 && mysqli_query($conn, $sql5) && mysqli_query($conn, $sql6) ) {
  
      
 }else{
 
       echo json_encode(["success"=>0]);
 }
  
 
 
 
 }
     catch(PDOException $e)
     {
         echo ($e->getMessage ()) ; 
     }
  
 

     

$conn->close();
 




?>