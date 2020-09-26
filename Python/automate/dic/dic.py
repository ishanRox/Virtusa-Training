#!/usr/bin/env python3
car = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}

x = car.setdefault("color")

print(x)
#if key is present it dosent set val but give the already present val
y = car.setdefault("color", "Red")

print(y)

car['color']="nickelblack"
#it dosent set new value bt give the existing val
z= car .setdefault("color","sfd")
print(z)