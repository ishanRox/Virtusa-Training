#!/usr/bin/env python3
import re

message=' 0115629090 is my landphone and 0783433434 us mobile no'

phoneNoRegex=re.compile('''\d{10}''')

matched= phoneNoRegex.search(message)

print(matched.group())

print(phoneNoRegex.findall(message))