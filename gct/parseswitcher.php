<?php
include ('connectdb.php'); 
$AMN_SW_AMNANCIEN="";
$AMN_SW_AMNNOUV="";
$AMN_SW_DPE="";
$AMN_SW_ELE_MC="";
$AMN_SW_ELE_MC1="";
$AMN_SW_MAG="";
$AMN_SW_NIT="";
$AMN_SW_Pers="";
$AMN_SW_RG36001="";

$lines = file('./status.dat');

foreach ($lines as $line_num => $line) {
    if ($line_num==198){
        $AMN_SW_AMNANCIEN_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);
    }
    if ($line_num==253){
        $AMN_SW_AMNNOUV_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

   }

    if ($line_num==308){
        $AMN_SW_DPE_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

     }
     if ($line_num==363){
        $AMN_SW_ELE_MC_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==418){
        $AMN_SW_ELE_MC1_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==473){
        $AMN_SW_MAG_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==528){
        $AMN_SW_NIT_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==583){
        $AMN_SW_Pers_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==638){
        $AMN_SW_RG36001_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }



 //echo "<b>{$line_num}</b> : " . htmlspecialchars($line) . "<br />\n";
}



    


foreach ($lines as $line_num => $line) {
    if ($line_num>=171 && $line_num<=222){
        $AMN_SW_AMNANCIEN=$AMN_SW_AMNANCIEN.$line;
     }
     if ($line_num>=226 && $line_num<=277){
        $AMN_SW_AMNNOUV=$AMN_SW_AMNNOUV.$line;
     }
     if ($line_num>=996 && $line_num<=1047){
        $AMN_SW_DPE=$AMN_SW_DPE.$line;
     }
     if ($line_num>=336 && $line_num<=387){
        $AMN_SW_ELE_MC=$AMN_SW_ELE_MC.$line;
     }
     if ($line_num>=391 && $line_num<=442){
        $AMN_SW_ELE_MC1=$AMN_SW_ELE_MC1.$line;
     }
     if ($line_num>=446 && $line_num<=491){
        $AMN_SW_MAG=$AMN_SW_MAG.$line;
     }
     if ($line_num>=501 && $line_num<=552){
        $AMN_SW_NIT=$AMN_SW_NIT.$line;
     }
     if ($line_num>=556 && $line_num<=607){
        $AMN_SW_Pers=$AMN_SW_Pers.$line;
     }
     if ($line_num>=611 && $line_num<=662){
        $AMN_SW_RG36001=$AMN_SW_RG36001.$line;
     }
    
    


}



echo json_encode(["success"=>1,"AMN_SW_AMNANCIEN_val"=>$AMN_SW_AMNANCIEN_val,
"AMN_SW_AMNNOUV_val"=>$AMN_SW_AMNNOUV_val
,"AMN_SW_DPE_val"=>$AMN_SW_DPE_val,"AMN_SW_ELE_MC_val"=>$AMN_SW_ELE_MC_val,
"AMN_SW_ELE_MC1_val"=>$AMN_SW_ELE_MC1_val
,"AMN_SW_MAG_val"=>$AMN_SW_MAG_val,"AMN_SW_NIT_val"=>$AMN_SW_NIT_val,"AMN_SW_Pers_val"=>$AMN_SW_Pers_val
,"AMN_SW_RG36001_val"=>$AMN_SW_RG36001_val
,"AMN_SW_AMNANCIEN"=>$AMN_SW_AMNANCIEN
,"AMN_SW_AMNNOUV"=>$AMN_SW_AMNNOUV,
"AMN_SW_DPE"=>$AMN_SW_DPE,
"AMN_SW_ELE_MC"=>$AMN_SW_ELE_MC,
"AMN_SW_ELE_MC1"=>$AMN_SW_ELE_MC1,
"AMN_SW_MAG"=>$AMN_SW_MAG,
"AMN_SW_NIT"=>$AMN_SW_NIT,
"AMN_SW_Pers"=>$AMN_SW_Pers,
"AMN_SW_RG36001"=>$AMN_SW_RG36001


]);



try
{ 
   
    $sql1="UPDATE `switcher` SET `etat_switcher` = '$AMN_SW_AMNANCIEN_val' WHERE `switcher`.`id_switcher` = 1";
    $sql2="UPDATE `switcher` SET `etat_switcher` = '$AMN_SW_AMNNOUV_val' WHERE `switcher`.`id_switcher` = 2";
    $sql3="UPDATE `switcher` SET `etat_switcher` = '$AMN_SW_DPE_val' WHERE `switcher`.`id_switcher` = 3";

    $sql4="UPDATE `switcher` SET `etat_switcher` = '$AMN_SW_ELE_MC_val' WHERE `switcher`.`id_switcher` = 4";
    $sql5="UPDATE `switcher` SET `etat_switcher` = '$AMN_SW_ELE_MC1_val' WHERE `switcher`.`id_switcher` = 5";
    $sql6="UPDATE `switcher` SET `etat_switcher` = '$AMN_SW_MAG_val' WHERE `switcher`.`id_switcher` = 6";

    $sql7="UPDATE `switcher` SET `etat_switcher` = '$AMN_SW_NIT_val' WHERE `switcher`.`id_switcher` = 7";
    $sql8="UPDATE `switcher` SET `etat_switcher` = '$AMN_SW_Pers_val' WHERE `switcher`.`id_switcher` = 8";
    $sql9="UPDATE `switcher` SET `etat_switcher` = '$AMN_SW_RG36001_val' WHERE `switcher`.`id_switcher` = 9";

 



   


if (mysqli_query($conn, $sql1) && mysqli_query($conn, $sql2) && mysqli_query($conn, $sql3) 
&& mysqli_query($conn, $sql4)
&& mysqli_query($conn, $sql5) && mysqli_query($conn, $sql6) && mysqli_query($conn, $sql7) 
&& mysqli_query($conn, $sql8) && mysqli_query($conn, $sql9) ) {

 
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