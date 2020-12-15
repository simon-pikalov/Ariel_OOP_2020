'''
There are four different methods (modes) for opening a file:

"r" - Read - Default value. Opens a file for reading, error if the file does not exist
"a" - Append - Opens a file for appending, creates the file if it does not exist
"w" - Write - Opens a file for writing, creates the file if it does not exist
"x" - Create - Creates the specified file, returns an error if the file exists

In addition you can specify if the file should be handled as binary or text mode

"t" - Text - Default value. Text mode
"b" - Binary - Binary mode (e.g. images)
'''

f = open("demofile.txt")

#The code above is the same as:
f = open("demofile.txt", "rt")

# read() method for reading the content of the file:

f = open("demofile.txt", "r")
print(f.read()) 

#If the file is located in a different location
f = open("D:\\myfiles\welcome.txt", "r")

#Return the 5 first characters of the file:

print(f.read(5))   

#You can return one line by using the readline() method:
print(f.readline())

# read the two first lines:
print(f.readline())
print(f.readline()) 

#By looping:
for x in f:
  print(x) 
  
#It is a good practice to always close the file
f.close() 
