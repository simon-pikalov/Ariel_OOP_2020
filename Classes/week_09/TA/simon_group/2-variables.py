# Creating Variables
x = 5
y = "John"
print(x)
print(y)

# Variable Names
#
# A variable name can only contain alpha-numeric characters and underscores (A-z, 0-9, and _ )
# (case sensitive and don't start with a number)

x = 4  # x is of type int
x = "Sally"  # x is now of type str
print(x)
# Ouput Variables
x = "awesome"

print("Python is " + x)

x = "Python is "
y = "awesome"
z = x + y
print(z)

x = 5
y = 10
print(x + y)

#################################################### Wont Work
# x = 5
# y = "John"
# print(x + y)
####################################################


# Assignment Operators

"""
Operator 	Example 	Same As
= 	      x = 5 	x = 5 	
+= 	      x += 3 	x = x + 3 	
-=       	x -= 3 	x = x - 3 	
*=       	x *= 3 	x = x * 3 	
/=      	x /= 3 	x = x / 3 	
%=      	x %= 3 	x = x % 3 	
//=       	x //= 3 	x = x // 3 	
**=       	x **= 3 	x = x ** 3 	
&=      	x &= 3 	x = x & 3 	
|=      	x |= 3 	x = x | 3 	
^=      	x ^= 3 	x = x ^ 3 	
>>=       	x >>= 3 	x = x >> 3 	
<<=       	x <<= 3 	x = x << 3 	

"""

# Multiple Variables

x, y, z = "Orange", "Banana", "Cherry"
print(x)
print(y)
print(z)

# Multiple Value for same variables

x = y = z = "Orange"
print(x)
print(y)
print(z)

# global and local variables

"""
If you create a variable with the same name inside a function, this variable will be local, 
and can only be used inside the function. The global variable with the same name will remain as it was, 
global and with the original value.
"""
# Example
x = "awesome"


def myfunc():
    x = "fantastic"
    print("Python is " + x)


myfunc()  # the output will be the local one (fantastic)

print("Python is " + x)  # the output will be the global one (awesome)


# If you use the global keyword, the variable belongs to the global scope:

def myfunc():
    global x
    x = "fantastic"


myfunc()

print(
    "Python is " + x)  # print the var x assigned globally by the latter function, try it without global to better understanding.

# ----------------------------------------------#
# Also, use the global keyword if you want to change a global variable inside a function.
