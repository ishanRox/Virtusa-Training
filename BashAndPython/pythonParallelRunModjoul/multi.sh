#!/bin/bash

#this x.py takes 5 seconds to complete its a simple python script

#start time in seconds
start=$(date +%s)

#here specify the device count (times that needed to execute python script)
deviceCount=100

for ((i = 1; i <= deviceCount; i++)); do
    echo "Bash executed python script $i th time"
    #execute the python script parallel
    python x.py &
done 2>/dev/null
wait

#end time and calculate total running time
end=$(date +%s)
runtime=$((end - start))

echo "Bash :- completed all $deviceCount parllel instances in $runtime seconds"

#do all in parallel - by  (wait) keyword to finish all if we add wait before done it means wait for one by one
#if we add wait before done we have to wait for 5 *10 seconds
#but if we put wait after done all of  it execute in 5 seconds

#https://www.geeksforgeeks.org/mv-command-linux-examples/
#https://unix.stackexchange.com/questions/235155/running-a-python-script-200-000-times-in-parallel-using-bash/235168
#https://askubuntu.com/questions/350208/what-does-2-dev-null-mean
