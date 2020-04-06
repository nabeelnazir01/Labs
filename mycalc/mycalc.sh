#!/bin/bash

# Lab 9
# Nabeel Nazir
# 040974403
# Operating Systems Fund(GNU/Linux)
# Section 300
# Calculator for plus or minus. Can take in parameters also.

add () { # Addition function
	echo The sum of $1 plus $2 equals $(($1+$2))
}

subtract () { # Subtraction function
	echo The difference of $1 minus $2 equals $(($1-$2))
}

if [[ $# -eq 3 ]] && [[ $1 =~ ^[+-]?[0-9]+$ ]] && [[ $3 =~ ^[+-]?[0-9]+$ ]]; then # Uses regex to check if integer or not
	if [ $2 == + ]; then
		add $1 $3
	elif [ $2 == - ]; then
		subtract $1 $3
	else # If not + or -
		echo The second parameter is not a + or a -!
	fi
elif [ $# -eq 0 ]; then
	user='p'
	while [ ${user^^} != 'X' ]; do # While loop that stops when user enters x lower case or upper case
		clear
		printf 'C) Calculation\nX) Exit\n'
		read -p 'Enter a choice: ' user
		if [ ${user^^} == 'C' ]; then
			clear
			read -p 'Please enter an integer number or X to exit: ' first
			if [ ${first^^} == 'X' ]; then
				clear
				continue # Goes back to main menu
			fi
			clear
			printf '+) Add\n-) Subtract\nX) Exit\n'
			read second
			if [ $second == + ] || [ $second == - ]; then
				clear
				read -p 'Please enter another integer number or X to exit: ' third
				clear
				if [ ${third^^} == 'X' ]; then
					clear
					continue
				elif [ $second == + ]; then
					add $first $third
				elif [ $second == - ]; then
					subtract $first $third
				fi
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
else # If not right number of parameters or not integers
	clear
	echo Wrong parameters!	
fi
echo Bye!