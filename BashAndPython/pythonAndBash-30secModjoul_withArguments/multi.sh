#!/bin/bash

#start time in seconds
start=$(date +%s)

#here specify the device count (times that needed to execute python script)
noOfRounds=10
waitingTimeSeconds=6

#arguments given from the bash
bashArgument1=$1
bashArgument2=$2
bashArgument3=$3

echo "Bash script initiated invoking python script"
echo "runnning interval $waitingTimeSeconds seconds"
echo "run for $(((noOfRounds * waitingTimeSeconds) / 60)) minutes"
echo "______________________________________________________"
for ((i = 1; i <= noOfRounds; i++)); do
    echo "Bash executed python script run  $i th time"
    sleep $waitingTimeSeconds
    python x.py $bashArgument1 $bashArgument2 $bashArgument3
done

#end time and calculate total running time
end=$(date +%s)
runtime=$((end - start))

echo "Bash :- completed all process $runtime seconds"
