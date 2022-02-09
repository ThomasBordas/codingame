<?php
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

fscanf(STDIN, "%d", $r1);
fscanf(STDIN, "%d", $r2);
$tempo;
$result = 0;
function sum($num)
{
    $sum = 0;
    for ($i = 0; $i < strlen($num); $i++) {
        $sum += $num[$i];
    }
    return strval($sum);
}
if (intval($r2) < intval($r1)) {
    $tempo = $r2;
    $r2 = $r1;
    $r1 = $tempo;
}
$i = -1;
$r1_array = [$r1];
$r2_array = [$r2];
while ($result == 0) {

    $i++;
    array_push($r1_array,strval( sum($r1_array[$i]) + ($r1_array[$i])));
    array_push($r2_array,strval( sum($r2_array[$i]) + ($r2_array[$i])));
    
   
if($r1_array[$i]>= $r2_array[0]){
    for ($j = 0; $j < count($r1_array); $j++) {
        if (intval($r1_array[$i]) == intval($r2_array[$j])) {
            $result = intval($r1_array[$i]);
        }
    }
}
}

// Write an answer using echo(). DON'T FORGET THE TRAILING \n
// To debug: error_log(var_export($var, true)); (equivalent to var_dump)

echo("$result\n");
?>