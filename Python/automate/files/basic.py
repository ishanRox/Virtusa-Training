#!/usr/bin/env python3
import os
import pathlib


print(os.path)

print(os.path.dirname(os.path.abspath(__file__)))

print(os.path.abspath(os.getcwd()))

#new path lib in python 3
#dir that file running in 
print(pathlib.Path(__file__).parent.absolute())
#current working dir 
print(pathlib.Path().absolute())