first=$1
second=$2
third=$3
user='p'

if [ $# -eq 3 ]; then
if [ $second == + ]; then
	echo $(($first+$third))
elif [ $second == - ]; then
	echo $(($first-$third))
fi
else
	while [ ${user^^} != 'X' ]; do
		printf 'C) Calculation\nX) Exit\n'
		read -p 'Enter a choice: ' user
		if [ ${user^^} == 'C' ]; then
			echo hi
		fi
	done	
fi
echo Bye!
