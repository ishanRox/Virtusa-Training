#!/usr/bin/env python3
import math
import random
import threading
import time

# simple output and input
print("hello world by ishan")
name = input("What is your name ")
print("hi", name)

# type in multi line
v1 = (
    1+3 +
    3+3)

# yes u can use semicolans
a = 12
b = 34
print(a+b)

'''And this is a multi line comment 
quit usefull'''

# dont do this u can initialize multiple var
x1 = x2 = x3 = 123
print(x1, x2)

# data can change
changingThing = 123
print(type(changingThing))
changingThing = "ssdf"
print(type(changingThing))

# casting
print("cast", type(int(4.5)))
print("cast", type(str(4.5)))
print("cast", type(chr(45)))
print("cast", type(ord('d')))

# output  advance
print(1, 26, 1996, sep='/')
# no need new line
print("no new line", end='')
print()

# math functions

print(abs(-23))
print(max(12, 123))
print(min(5, 3))
print(pow(2, 2))
print("celi ", math.ceil(2.333))
print("floor", 4.5)
print("random ", random.randint(1, 101))

#infinity and nan
print(math.inf > 0)
print(math.inf-math.inf)

# conditionals
age = 30
if age > 21:
    print("ok u can buy weed ")
elif age >= 16:
    print("go screw urself")
else:
    print("u ra kid")

print("________________________________")

# with and
size = 122

if size < 5:
    print("liliputtek")
elif(size >= 5) and (size <= 8):
    print("medium ok")
elif(size > 8) and (size < 12):
    print("large")
else:
    print("african")

#ternary operator
votingAge=18
canVote="Yes u can vote to gota "if votingAge>20 else "no u cnt vote to gota"
print(canVote)