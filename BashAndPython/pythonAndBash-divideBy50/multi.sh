#!/bin/bash

#start time in seconds
start=$(date +%s)

noOfRounds=$1
start=$2
end=$3

echo "Bash script initiated invoking python script"
echo "going to simulate $start to $end devices"
echo "going to run for $noOfRounds rounds of 30 seconds"
echo "______________________________________________________"

for ((i = 1; i <= noOfRounds; i++)); do ### Outer for loop ###
    echo "Bash waiting 30 seconds new round"
    sleep 3
    for ((j = $start; j <= $end; j++)); do ### Inner for loop ###
        printf -v letter "%04g" $j
        python x.py "OHIOLT${letter}" &
    done
    wait
    echo "" #### print the new line ###
done

#end time and calculate total running time
end=$(date +%s)
runtime=$((end - start))

echo "Bash :- completed all process $runtime seconds"
