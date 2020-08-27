#!/usr/bin/env python3
from time import sleep
from datetime import datetime

# datetime object containing current date and time
now = datetime.now()

for x in range(100000):
    print(now)
