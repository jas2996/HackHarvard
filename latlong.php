<?php

include 'calllatlong.php';

function getLatLong($address){
    if(!empty($address)){

        $formattedAddr = str_replace(' ','+',$address);

        $geocodeFromAddr = file_get_contents('http://maps.googleapis.com/maps/api/geocode/json?address='.$formattedAddr.'&sensor=false');
        $output = json_decode($geocodeFromAddr);

        $data['latitude']  = $output->results[0]->geometry->location->lat;
        $data['longitude'] = $output->results[0]->geometry->location->lng;

        if(!empty($data)){
            return $data;
        }else{
            return false;
        }
    }else{
        return false;
    }
}
 ?>
