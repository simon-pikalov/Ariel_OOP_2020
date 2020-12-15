#_________________________________modules_______________________#

"""
Consider a module to be the same as a code library.
A file containing a set of functions you want to include in your application.
"""

#Save this code in a file named mymodule.py
def greeting(name):
  print("Hello, " + name) 
person1 = {
  "name": "John",
  "age": 36,
  "country": "Norway"
} 
  
#Import the module named mymodule, and call the greeting function:
import mymodule

mymodule.greeting("Jonathan")

#Variables in Module:

import mymodule

a = mymodule.person1["age"]
print(a) 

#Create an alias for mymodule called mx:
import mymodule as mx
a = mx.person1["age"]

#There are several built-in modules in Python, which you can import whenever you like.
import platform

x = platform.system()
print(x) 

#There is a built-in function to list all the function names (or variable names) in a module. The dir() function:
x = dir(platform)

#Import only the person1 dictionary from the module:
from mymodule import person1

print (person1["age"])
