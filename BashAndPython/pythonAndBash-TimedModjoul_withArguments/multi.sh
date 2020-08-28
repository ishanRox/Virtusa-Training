#!/bin/bash

#start time in seconds
start=$(date +%s)

#here specify the device count (times that needed to execute python script)

hour=0
minutes=5

#generate noOfRounds by hour or minute
minutes=$((minutes + (hour * 60)))

#for 5 min ---> 30sec*10=5min
#rounds for a x rounds when we know min min-->sec
# 5 min = 30 sec*x
# 5 * 60 sec =30 sec*x
#x=min*60/30

waitingTimeSeconds=30
noOfRounds=$(((minutes * 60) / waitingTimeSeconds))

#arguments given from the bash
bashArgument1=$1
bashArgument2=$2
bashArgument3=$3

echo "$noOfRounds rounds of $waitingTimeSeconds second"
echo "$minutes minutes"
echo "Bash script initiated invoking python script"
echo "runnning interval $waitingTimeSeconds seconds"
echo "going to run for $minutes minutes in $noOfRounds rounds"
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
