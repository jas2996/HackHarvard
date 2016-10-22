<?php

$address = 'Harvard University Cambridge, MA 02138'; // get address from Jas (json)
$latLong = getLatLong($address);
$latitude = $latLong['latitude']?$latLong['latitude']:'Not found';
$longitude = $latLong['longitude']?$latLong['longitude']:'Not found';

echo $latitude;
echo $longitude;


 ?>
