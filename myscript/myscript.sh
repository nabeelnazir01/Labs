#!/bin/bash

# Nabeel Nazir
# 040974403
# Operating Systems Fund(GNU/Linux)
# Section 300
# Gets

choice="n"
while [ $choice != "Q" ] && [ $choice != "q" ]; do
clear
printf "Choose one of the following options:
A to Create a user account\nB to Delete a user account
C to Change Supplementary Group for a user account
D to Change Initial Group for a user account
E Change default login shell for a user account
F to Change account expiration date for a user account\nQ to Quit\n"

read -p 'What would you like to do?: ' choice

if [ $choice = "A" ] || [ $choice = "a" ]; then
read -p 'Username: ' user
read -p 'Home: ' Home
read -p 'Default shell: ' shell
useradd -m -d $Home -s $shell -U $user
elif [ $choice = "B" ] || [ $choice = "b" ]; then
read -p 'Username: ' user
userdel -r $user
elif [ $choice = "C" ] || [ $choice = "c" ]; then
read -p 'Username: ' user
read -p 'Group: ' group
usermod -G $group $user
elif [ $choice = "D" ] || [ $choice = "d" ]; then
read -p 'Username: ' user
read -p 'Group: ' group
usermod -g $group $user
elif [ $choice = "E" ] || [ $choice = "e" ]; then
read -p 'Username: ' user
read -p 'Shell: ' shell
usermod -s $shell $user
elif [ $choice = "F" ] || [ $choice = "f" ]; then
read -p 'Username: ' user
read -p 'date: ' date
chage -E $date $user
elif [ $choice != "q" ] && [ $choice != "Q" ]; then
echo "Input is wrong"
fi
sleep 3
done

echo Bye!
