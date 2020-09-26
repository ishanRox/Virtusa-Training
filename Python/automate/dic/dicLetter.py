#!/usr/bin/env python3
import pprint
line='xhello my name is ishanjxxxx'

dic={}

for i in line.replace(" ",""):
    dic.setdefault(i,0)
    dic[i]=dic[i]+1
  
pprint.pprint(dic)
    