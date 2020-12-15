#list all directories AND files in current path:
import os
arr = os.listdir()
print(arr)

#LIST FILES ONLY:
import glob
print(glob.glob('C:\\*.*'))


'''
Get the current working direcory: os.getcwd()
Change the current working direcory: os.chdir()
'''
#Get the path of running file (.py) in Python:

import os
print('__file__:    ', __file__) #output: C:\Users\mohamed\Desktop\lol\inherit.py

#get folders only:
getfolder = lambda dir : for i in os.listdir(dir) if not os.path.isfile(i) return i

#to rename:
os.rename('Christmas Photos','Christmas 2017')
