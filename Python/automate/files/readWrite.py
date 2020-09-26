import os

currentDir=os.path.dirname(__file__)

readFile= open(os.path.join(currentDir,'loremipsum.txt'))

content=readFile.read()
print(content)    
readFile.close();

print('_________________')
#w-write a -apend to the file without change exist 
writeFile=open(os.path.join(currentDir,'loremipsum.txt'),'w')
writeFile.write(content.replace('ishan','isahnRox'))
writeFile.close()