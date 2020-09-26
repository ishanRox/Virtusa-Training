#!/usr/bin/env python
import os

#terminal eke py eka execure wena thana
for fileName in os.listdir(os.getcwd()):
    print(fileName)
print('_'*20)
#real file eka thiyena thana
for fileName in os.listdir(os.path.dirname(__file__)):
    print(fileName)