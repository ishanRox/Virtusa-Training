#!/bin/bash

noOfRounds=$1
start=$2
end=$3

echo "Bash script initiated invoking inner bash script"

for ((i = start; i <= end; i = i + noOfRounds)); do ### Outer for loop ###
    #sleep for 1 second
    sleep 1
    #calculate end value
    innerEnd=$((i + noOfRounds - 1))
    echo "start - $i end - $innerEnd"
    #execute innerbash
    sh ./x.sh 10 $i $innerEnd &
    
done

echo "Bash :- completed all inner bash calls"
