import re

batRegex= re.compile('''Bat(wo)?man''')
print(batRegex.search('the Batman').group())

print(batRegex.search('the Baman') == None)

print(batRegex.search('the Batwoman').group())

print('_'*20)

batRegex1= re.compile('''Bat(wo)*man''')
print(batRegex1.search('the Batman').group())
print(batRegex1.search('the Batwowowowowoman').group())

print('_'*20)

batRegex2= re.compile('''Bat(wo)+man''')
print(batRegex2.search('the Batman')==None)
print(batRegex2.search('the Batwowowowowoman').group())

print('_'*20)

greedyRegex= re.compile('''(\d){3,5}''')
print(greedyRegex.search('1234567890').group())

print("__________________________________")

reluctantRegex= re.compile('''(\d){3,5}?''')
print(reluctantRegex.search('1234567890').group())

