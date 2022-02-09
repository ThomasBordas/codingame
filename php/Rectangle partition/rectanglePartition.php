<?php
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

function getIntervals($countTab)
{
    $tabInt = [];
    for ($i = count($countTab) - 1; $i > 0; $i--) {
        for ($j = 0; $j < $i; $j++) { 
                array_push($tabInt, ($countTab[$i] - $countTab[$j]));       
        }
    }
    return ($tabInt);
}

function compare($tabInt, $tabInt2)
{
    $tabValue = array_count_values($tabInt);
    $tabValue2 = array_count_values($tabInt2);
    $result = 0;
    foreach ($tabValue as $key => $value) {
        foreach ($tabValue2 as $key2 => $value2) {
            if ($key == $key2) {
                $result += $tabValue[$key]*$tabValue2[$key2];
            }
        }
    }
    return $result;
}

$countxTab =[];
$countyTab =[];

fscanf(STDIN, "%d %d %d %d", $w, $h, $countX, $countY);
$inputs = explode(" ", fgets(STDIN));

$countxTab[0] = 0;
for ($i = 0; $i < $countX; $i++)
{
    $x = intval($inputs[$i]);    
    array_push($countxTab,$x);    
}
array_push($countxTab,$w);

$inputs = explode(" ", fgets(STDIN));

$countyTab[0] = 0;
for ($i = 0; $i < $countY; $i++)
{
    $y = intval($inputs[$i]);
    array_push($countyTab,$y);
}
array_push($countyTab,$h);

$countxTab = getIntervals($countxTab);
$countyTab = getIntervals($countyTab);
$result = compare($countxTab, $countyTab );

echo("$result\n");
?>