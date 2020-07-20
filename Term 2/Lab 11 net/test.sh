#!/bin/bash
((x=6));((y=10))
if [ $x –gt 5 ]
then
    if [ $y –gt 10 ]
    then
        echo "peaches"

    elif [ $(($x*$y)) –ge 55 ]
    then
        echo "pears"

    else
        echo "apples"
    fi
else
    echo "mushrooms"
fi