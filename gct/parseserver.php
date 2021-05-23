<?php

include ('connectdb.php'); 
$APPRO_SRV_DHCP_KAV="";
$DRU_SRV_AD="";
$DRU_SRV_Backup="";
$DRU_SRV_ESXI_GPM3="";
$DRU_SRV_GLPI_ANCIEN="";
$DRU_SRV_GPM3="";
$DRU_SRV_GPM3_Backp="";
$DRU_SRV_GedAlfresco="";
$DRU_SRV_Helpdesk="";
$DRU_SRV_KAV_HYP="";

$DRU_SRV_AD_Service="";
$DRU_SRV_Backup_Service="";


$DRU_SRV_ProxyNew="";
$DRU_SRV_VMWARE_GPM3="";
$DRU_SRV_VMs="";
$DRU_SRV_WEB_APPS="";



$lines = file('./status.dat');

foreach ($lines as $line_num => $line) {
    if ($line_num==1078){
        $APPRO_SRV_DHCP_KAV_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);
    }
    if ($line_num==1683){
        $DRU_SRV_AD_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

   }

    if ($line_num==1738){
        $DRU_SRV_Backup_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

     }
     if ($line_num==1793){
        $DRU_SRV_ESXI_GPM3_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==1848){
        $DRU_SRV_GLPI_ANCIEN_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==1903){
        $DRU_SRV_GPM3_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==1958){
        $DRU_SRV_GPM3_Backp_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==2013){
        $DRU_SRV_GedAlfresco_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==2068){
        $DRU_SRV_Helpdesk_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==2123){
        $DRU_SRV_KAV_HYP_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);




        //service

    }
    if ($line_num==5670){
        $DRU_SRV_AD_Service_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    
    if ($line_num==5955){
        $DRU_SRV_Backup_Service_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }




    if ($line_num==2288){
        $DRU_SRV_VMWARE_GPM3_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==2343){
        $DRU_SRV_VMs_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }
    if ($line_num==2398){
        $DRU_SRV_WEB_APPS_val=(int)filter_var($line, FILTER_SANITIZE_NUMBER_INT);

    }







 //echo "<b>{$line_num}</b> : " . htmlspecialchars($line) . "<br />\n";
}



    


foreach ($lines as $line_num => $line) {
    if ($line_num>=1051 && $line_num<=1102){
        $APPRO_SRV_DHCP_KAV=$APPRO_SRV_DHCP_KAV.$line;
     }
     if ($line_num>=1656 && $line_num<=1707){
        $DRU_SRV_AD=$DRU_SRV_AD.$line;
     }
     if ($line_num>=1711 && $line_num<=1762){
        $DRU_SRV_Backup=$DRU_SRV_Backup.$line;
     }
     if ($line_num>=1766 && $line_num<=1817){
        $DRU_SRV_ESXI_GPM3=$DRU_SRV_ESXI_GPM3.$line;
     }
     if ($line_num>=1821 && $line_num<=442){
        $DRU_SRV_GLPI_ANCIEN=$DRU_SRV_GLPI_ANCIEN.$line;
     }
     if ($line_num>=1876 && $line_num<=1927){
        $DRU_SRV_GPM3=$DRU_SRV_GPM3.$line;
     }
     if ($line_num>=1931 && $line_num<=1982){
        $DRU_SRV_GPM3_Backp=$DRU_SRV_GPM3_Backp.$line;
     }
     if ($line_num>=1986 && $line_num<=2037){
        $DRU_SRV_GedAlfresco=$DRU_SRV_GedAlfresco.$line;
     }
     if ($line_num>=2041 && $line_num<=2092){
        $DRU_SRV_Helpdesk=$DRU_SRV_Helpdesk.$line;
     }
     if ($line_num>=2096 && $line_num<=2147){
        $DRU_SRV_KAV_HYP=$DRU_SRV_KAV_HYP.$line;
     }



//service
     if ($line_num>=5648 && $line_num<=5702){
        $DRU_SRV_AD_Service=$DRU_SRV_AD_Service.$line;
     }


     if ($line_num>=5933 && $line_num<=5986){
        $DRU_SRV_Backup_Service=$DRU_SRV_Backup_Service.$line;
     }



     if ($line_num>=2261 && $line_num<=2312){
        $DRU_SRV_VMWARE_GPM3=$DRU_SRV_VMWARE_GPM3.$line;
     }
     if ($line_num>=2316 && $line_num<=2367){
        $DRU_SRV_VMs=$DRU_SRV_VMs.$line;
     }
     if ($line_num>=2371 && $line_num<=2422){
        $DRU_SRV_WEB_APPS=$DRU_SRV_WEB_APPS.$line;
     }
    
    
    


}



echo json_encode(["success"=>1,
"APPRO_SRV_DHCP_KAV_val"=>$APPRO_SRV_DHCP_KAV_val,
"DRU_SRV_AD_val"=>$DRU_SRV_AD_val,
"DRU_SRV_Backup_val"=>$DRU_SRV_KAV_HYP_val,
"DRU_SRV_ESXI_GPM3_val"=>$DRU_SRV_ESXI_GPM3_val,
"DRU_SRV_GLPI_ANCIEN_val"=>$DRU_SRV_GLPI_ANCIEN_val,
"DRU_SRV_GPM3_val"=>$DRU_SRV_GPM3_val,
"DRU_SRV_GPM3_Backp_val"=>$DRU_SRV_GPM3_Backp_val,
"DRU_SRV_GedAlfresco_val"=>$DRU_SRV_GedAlfresco_val,
"DRU_SRV_KAV_HYP_val"=>$DRU_SRV_KAV_HYP_val,
"DRU_SRV_Helpdesk_val"=>$DRU_SRV_Helpdesk_val,

"DRU_SRV_VMWARE_GPM3_val"=>$DRU_SRV_VMWARE_GPM3_val,
"DRU_SRV_VMs_val"=>$DRU_SRV_VMs_val,
"DRU_SRV_WEB_APPS_val"=>$DRU_SRV_WEB_APPS_val,


"APPRO_SRV_DHCP_KAV"=>$APPRO_SRV_DHCP_KAV,
"DRU_SRV_AD"=>$DRU_SRV_AD,
"DRU_SRV_Backup"=>$DRU_SRV_Backup,
"DRU_SRV_ESXI_GPM3"=>$DRU_SRV_ESXI_GPM3,
"DRU_SRV_GLPI_ANCIEN"=>$DRU_SRV_GLPI_ANCIEN,
"DRU_SRV_GPM3"=>$DRU_SRV_GPM3,
"DRU_SRV_GPM3_Backp"=>$DRU_SRV_GPM3_Backp,
"DRU_SRV_GedAlfresco"=>$DRU_SRV_GedAlfresco,
"DRU_SRV_Helpdesk"=>$DRU_SRV_Helpdesk,
"DRU_SRV_KAV_HYP"=>$DRU_SRV_KAV_HYP,

"DRU_SRV_AD_Service"=>$DRU_SRV_AD_Service,
"DRU_SRV_AD_Service_val"=>$DRU_SRV_AD_Service_val,
"DRU_SRV_Backup_Service_val"=>$DRU_SRV_Backup_Service_val,
"DRU_SRV_Backup_Service"=>$DRU_SRV_Backup_Service,









"DRU_SRV_ProxyNew"=>$DRU_SRV_ProxyNew,
"DRU_SRV_VMWARE_GPM3"=>$DRU_SRV_VMWARE_GPM3,
"DRU_SRV_VMs"=>$DRU_SRV_VMs,
"DRU_SRV_WEB_APPS"=>$DRU_SRV_WEB_APPS,

]);

//--------------------insertion a la base------------------------

try
{ 
   
    $sql1="UPDATE `server` SET `etat_server` = '$APPRO_SRV_DHCP_KAV_val' WHERE `server`.`id_server` = 1";
    $sql2="UPDATE `server` SET `etat_server` = '$DRU_SRV_AD_val' WHERE `server`.`id_server` = 2";
    $sql3="UPDATE `server` SET `etat_server` = '$DRU_SRV_KAV_HYP_val' WHERE `server`.`id_server` = 3";

    $sql4="UPDATE `server` SET `etat_server` = '$DRU_SRV_ESXI_GPM3_val' WHERE `server`.`id_server` = 4";
    $sql5="UPDATE `server` SET `etat_server` = '$DRU_SRV_GLPI_ANCIEN_val' WHERE `server`.`id_server` = 5";
    $sql6="UPDATE `server` SET `etat_server` = '$DRU_SRV_GPM3_val' WHERE `server`.`id_server` = 6";


    $sql7="UPDATE `server` SET `etat_server` = '$DRU_SRV_GPM3_Backp_val' WHERE `server`.`id_server` = 7";
    $sql8="UPDATE `server` SET `etat_server` = '$DRU_SRV_GedAlfresco_val' WHERE `server`.`id_server` = 8";
    $sql9="UPDATE `server` SET `etat_server` = '$DRU_SRV_KAV_HYP_val' WHERE `server`.`id_server` = 9";


    $sql10="UPDATE `server` SET `etat_server` = '$DRU_SRV_Helpdesk_val' WHERE `server`.`id_server` = 10";

    $sql11="UPDATE `server` SET `etat_server` = '$DRU_SRV_AD_Service_val' WHERE `server`.`id_server` = 11";
    $sql12="UPDATE `server` SET `etat_server` = '$DRU_SRV_Backup_Service_val' WHERE `server`.`id_server` = 12";
    



    
   


if (mysqli_query($conn, $sql1) && mysqli_query($conn, $sql2) && mysqli_query($conn, $sql3)
 && mysqli_query($conn, $sql4)&& mysqli_query($conn, $sql5)&& mysqli_query($conn, $sql6)
&& mysqli_query($conn, $sql7)&& mysqli_query($conn, $sql8) 
&& mysqli_query($conn, $sql9)&& mysqli_query($conn, $sql10)&& mysqli_query($conn, $sql11)&& mysqli_query($conn, $sql12)) {

 
  
 
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