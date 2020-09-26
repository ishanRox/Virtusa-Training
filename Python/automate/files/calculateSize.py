import os

totalSize=0

#__file__ gives the current file and using
# dirname we remove the file and get only dir
#and we list all the thing s inthat files and folders

dirPath=os.path.dirname(__file__)

file_folder_List=os.listdir(dirPath)

totalSize=0

print(dirPath)
for stuff in file_folder_List:
    print(stuff)
    print(os.path.getsize(dirPath+'/'+stuff))
    #same thing as concat dirpath to stuff stuff mean a file or a folder
    print(os.path.isfile(os.path.join(dirPath,stuff)))
    print('_'*10)
    if (os.path.isfile(os.path.join(dirPath,stuff))):
        totalSize+=(os.path.getsize(dirPath+'/'+stuff))

print(totalSize)