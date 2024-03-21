$menu = $args[0]
$num1 = $args[1]
$num2 = $args[2]
switch ($menu)
{
    "sum"{$res = $num1 + $num2
            Write-Host ($res +" es el resultado de la suma")}
    "res"{$res = $num1 - $num2
            Write-Host ($res +" es el resultado de la resta")}
    "mult"{$res = $num1 * $num2
            Write-Host ($res +" es el resultado de la multiplicacion")}
    "div"{$res = $num1 / $num2
            Write-Host ($res +" es el resultado de la division")}
}