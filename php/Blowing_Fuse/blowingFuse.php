<?php
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
$nTab =[];
$mTab =[];
$onOff = [];
$puiss = 0;
$puissMax = 0;

fscanf(STDIN, "%d %d %d", $n, $m, $c);
$inputs = explode(" ", fgets(STDIN));
for ($i = 0; $i < $n; $i++)
{
    $nx = intval($inputs[$i]);
    array_push($nTab,$nx);
}

$inputs = explode(" ", fgets(STDIN));
for ($i = 0; $i < $m; $i++)
{
    $mx = intval($inputs[$i]);
    array_push($mTab,$mx);
}

for ($i = 0; $i < count($mTab); $i++) {
    if (!in_array($mTab[$i], $onOff)) {
        array_push($onOff, $mTab[$i]);
        $puiss += $nTab[$mTab[$i]-1];
        if ($puiss > $puissMax) {
            $puissMax = $puiss;
        }

    
    } else {
        $puiss -= $nTab[$mTab[$i]-1];
        $suppr = array_search($mTab[$i],$onOff);        
        array_splice($onOff,$suppr,1);
    }
}

if($puissMax <= $c){
    echo("Fuse was not blown.\n");
    echo("Maximal consumed current was $puissMax A.\n");
}else{
    echo("Fuse was blown.\n");
}

?>