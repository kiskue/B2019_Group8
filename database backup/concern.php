<?php

require "connectiondb.php";

$Name = isset($_POST["Name"]) ? $_POST["Name"] : '';;
$address = isset($_POST["address"]) ? $_POST["address"] : '';;
$Concern = isset($_POST["Concern"]) ? $_POST["Concern"] : '';;
$Needforconcern = isset($_POST["Needforconcern"]) ? $_POST["Needforconcern"] : '';;

$sql = "insert into NotEmergency  (name,address,Concern,Needforconcern,confirm_at) values ('$Name','$address','$Concern','$Needforconcern',NOW());";

if(mysqli_query($con,$sql))
{

echo "Concern Submmited Successfully!";

}
else
{
echo "Something Went wrong!!" ;

}
?>