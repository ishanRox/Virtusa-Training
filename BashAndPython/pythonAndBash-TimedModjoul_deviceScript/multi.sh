#!/bin/bash

#start time in seconds
start=$(date +%s)

waitingTimeSeconds=$1
noOfDevices=$2

echo "Bash script initiated invoking python script"
echo "runnning interval $waitingTimeSeconds seconds"
echo "going to simulate $noOfDevices devices"
echo "______________________________________________________"
for i in $(seq -f "%04g" 1 $noOfDevices); do
    #sleep $waitingTimeSeconds
    echo "device $i"
    python x.py "OHIOLT$i" &
done
wait

#end time and calculate total running time
end=$(date +%s)
runtime=$((end - start))

echo "Bash :- completed all process $runtime seconds"
