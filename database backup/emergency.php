<?php

require "connectiondb.php";

$email = isset($_POST["email"]) ? $_POST["email"] : '';;
$fire = isset($_POST["fire"]) ? $_POST["fire"] : '';;
$floods = isset($_POST["floods"]) ? $_POST["floods"] : '';;
$robbery = isset($_POST["robbery"]) ? $_POST["robbery"] : '';;
$earthquake = isset($_POST["earthquake"]) ? $_POST["earthquake"] : '';;
$bomb_threat = isset($_POST["bomb_threat"]) ? $_POST["bomb_threat"] : '';;
$needambulance = isset($_POST["needambulance"]) ? $_POST["needambulance"] : '';;
$lost_family = isset($_POST["lost_family"]) ? $_POST["lost_family"] : '';;
$personal_threat = isset($_POST["personal_threat"]) ? $_POST["personal_threat"] : '';;


$sql = "insert into Emergency  (email,fire,floods,robbery,earthquake,bomb_threat,need_ambulance,lost_family,	personal_threat,confirm_at) values ('$email','$fire','$floods','$robbery','$earthquake','$bomb_threat','$need_ambulance','$lost_family','$personal_threat', CURRENT_TIMESTAMP)";

if(mysqli_query($con,$sql))
{

echo "Emergency Comfirm Successfully!";

}
else
{
echo "Something Went wrong!!" ;
}

?>