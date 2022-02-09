<?php
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

fscanf(STDIN, "%d", $n);

$n2= $n*$n;

for ($i=1; $i <$n+1 ; $i++) { 
    $x = ($n2/$i)+$n;
    $y = $i + $n;
    if( $n2 % $i === 0 & $x>= $y){
        echo("1/$n = 1/$x + 1/$y\n") ;
    }
}
?>