#!/bin/bash

# Nabeel Nazir
# 040974403
# Operating Systems Fund(GNU/Linux)
# Section 300
# Gets input from user for marks and gets the average and letter mark.

grade='A+'

read -p 'Enter Assignment mark (0 - 40): ' m1
read -p 'Enter Test 1 mark (0 - 15): ' m2
read -p 'Enter Test 2 mark (0 - 15): ' m3
read -p 'Enter Final exam mark (0 - 30): ' m4

((num=m1+m2+m3+m4))

if [ $num -lt 90 ]; then
grade='A' 
fi
if [ $num -lt 85 ]; then
grade='A-' 
fi
if [ $num -lt 80 ]; then
grade='B+' 
fi
if [ $num -lt 77 ]; then
grade='B' 
fi
if [ $num -lt 73 ]; then
grade='B-' 
fi
if [ $num -lt 70 ]; then
grade='C+' 
fi
if [ $num -lt 67 ]; then
grade='C' 
fi
if [ $num -lt 63 ]; then
grade='C-' 
fi
if [ $num -lt 60 ]; then
grade='D+' 
fi
if [ $num -lt 57 ]; then
grade='D' 
fi
if [ $num -lt 53 ]; then
grade='D-' 
fi
if [ $num -lt 50 ]; then
grade='F' 
fi

echo Your final numeric grade is $num, and your final letter grade is $grade