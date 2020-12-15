'''
The try block lets you test a block of code for errors.
The except block lets you handle the error.
The finally block lets you execute code, regardless of the result of the try- and except blocks.
'''

#The try block will generate an exception, because x is not defined:
try:
  print(x)
except:
  print("An exception occurred") 

#Print one message if the try block raises a NameError and another for other errors:
try:
  print(x)
except NameError:
  print("Variable x is not defined")
except:
  print("Something else went wrong") 

#else:
try:
  print("Hello")
except:
  print("Something went wrong")
else:
  print("Nothing went wrong") 
  
#finally:

try:
  print(x)
except:
  print("Something went wrong")
finally:
  print("The 'try except' is finished") #will execute regardless of above
  
#This can be useful to close objects and clean up resources:

try:
  f = open("demofile.txt")
  f.write("Lorum Ipsum")
except:
  print("Something went wrong when writing to the file")
finally:
  f.close() 
  
#Raise an error and stop the program if x is lower than 0:
x = -1

if x < 0:
  raise Exception("Sorry, no numbers below zero") 
  
#another example:
Raise a TypeError if x is not an integer:
x = "hello"

if not type(x) is int:
  raise TypeError("Only integers are allowed") 
