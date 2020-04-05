#!/bin/bash

# Lab 9
# Nabeel Nazir
# 040974403
# Operating Systems Fund(GNU/Linux)
# Section 300
# Calculator for plus or minus. Can take in parameters also.

user='p'

if [[ $# -eq 3 ]] && [[ $1 =~ ^[+-]?[0-9]+$ ]] && [[ $3 =~ ^[+-]?[0-9]+$ ]]; then
	if [ $2 == + ] || [ $2 == - ]; then
		echo $1 $2 $3 equals $(($1$2$3))
	else
		echo The second parameter is not a + or a -!
	fi
elif [ $# -eq 0 ]; then
	while [ ${user^^} != 'X' ]; do
		clear
		printf 'C) Calculation\nX) Exit\n'
		read -p 'Enter a choice: ' user
		if [ ${user^^} == 'C' ]; then
			read -p 'Please enter an integer number or X to exit: ' first
			if [ ${first^^} == 'X' ]; then
				clear
				continue
			fi
			printf '+) Add\n-) Subtract\nX) Exit\n'
			read second
			if [ $second == + ] || [ $second == - ]; then
				read -p 'Please enter another integer number or X to exit: ' third
				if [ ${third^^} == 'X' ]; then
					clear
					continue
				fi
				echo Answer is $(($first$second$third))
				sleep 3
				clear
				continue
			elif [ ${user^^} != 'X' ]; then
				echo wrong input!
				clear
				continue
			else
				clear
				continue
			fi
		elif [ ${user^^} != 'X' ]; then
			clear
			echo wrong input!
		else
			clear
			continue
		fi
	done
else
	clear
	echo Wrong parameters!	
fi
echo Bye!
