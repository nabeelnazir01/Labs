#!/bin/bash

# Nabeel Nazir
# 040974403
# Operating Systems Fund(GNU/Linux)
# Section 300
# Gets input from user for marks and gets the average and letter mark.
choice="n"
while [ $choice != "Q" ] && [ $choice != "q" ]; do
    printf "Choose one of the following options:\n"
    printf "A to Create a user account\nB to Delete a user account
C to Change Supplementary Group for a user account
D to Change Initial Group for a user account
F to Change account expiration date for a user account\nQ to Quit\n"

read -p 'What would you like to do?: ' choice

if [ $choice = "A" ] || [ $choice = "a" ]; then
read -p 'Username: ' user
read -p 'Home: ' Home
read -p 'Default shell: ' shell
useradd -m -d $Home -s $shell -U $user
fi
if [ $choice = "B" ] || [ $choice = "b" ]; then
read -p 'Username: ' user
userdel -r $user
fi
if [ $choice = "C" ] || [ $choice = "c" ]; then
read -p 'Username: ' user
read -p 'Group: ' group
usermod -G $group $user
fi
if [ $choice = "D" ] || [ $choice = "d" ]; then
echo hi
fi
if [ $choice = "E" ] || [ $choice = "e" ]; then
echo hi
fi
if [ $choice = "F" ] || [ $choice = "f" ]; then
echo hi
else
printf "Input is wrong\n"
fi

done
