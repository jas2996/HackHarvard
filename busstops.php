<?php

include 'latlong.php';
include 'calllatlong.php';



$db = new mysqli('localhost', 'root', 'secret', 'harvardhack');

if($db->connect_errno > 0){
  die('Unable to connect to database [' . $db->connect_error . ']');
}


$sql = <<<SQL

SELECT *,
    SQRT(POW((69.1 * (bus.lat - $latitude)) , 2 ) +
    POW((53 * (bus.lng - $longitude)), 2)) AS distance



FROM bus
ORDER BY distance ASC

LIMIT 2

SQL;



if(!$result = $db->query($sql)){
  die('There was an error running the query [' . $db->error . ']');
}


while($row = $result->fetch_array())

{

  $rows[] = $row;



}



foreach($rows as $row)
{


  $busaddress = $row['BusAddress'];

  $buspopulation = $row['Population'];
  file_put_contents('businfo.json', json_encode($rows, JSON_PRETTY_PRINT));
    file_put_contents('startaddress.json', json_encode($latitude." ".$longitude));

}

//$bestpop = min(array($row['Population']));




 ?>
