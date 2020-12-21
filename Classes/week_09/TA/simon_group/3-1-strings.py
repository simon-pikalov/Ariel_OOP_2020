# Multiline Strings

a = """All truth passes through three stages. 
First, it is ridiculed. 
Second, it is violently opposed.
Third, it is accepted as being self-evident."""

print(a)  # try it

# access elements of the string:

a = "Hello, World!"
print(a[1])  # output: e

# Slicing:
# Get the characters from position 2 (not included) to position 5:
b = "Hello, World!"
print(b[2:5])  # output: llo

# String Length
# To get the length of a string

a = "Hello, World!"
print(len(a))  # output: 13

# String Methods:
# strip()
a = " Hello, World! "
print(a.strip())  # returns "Hello, World!"
# lower()
a = "Hello, World!"
print(a.lower())  # returns "hello, world!"
# upper() : same as above but makes all upper-case
# replace()
a = "Hello, World!"
print(a.replace("H", "J"))
# split():  splits a string into a list.
a = "Hello, World!"
print(a.split(","))  # returns ['Hello', ' World!']
print(a.split())  # returns ['Hello,', 'World!']
# more methods here: https://www.w3schools.com/python/python_ref_string.asp
# Check String

txt = "The rain in Spain stays mainly in the plain"
x = "ain" not in txt
print(x)  # output: False

# String Concatenation

a = "Hello"
b = "World"
c = a + " " + b
print(c)  # output: Hello World

# String Format
# Use the format() method to insert numbers into strings:

# EX1
quantity = 3
itemno = 567
price = 49.95
myorder = "I want {} pieces of item {} for {} dollars."
print(myorder.format(quantity, itemno, price))

# EX2
quantity = 3
itemno = 567
price = 49.95
myorder = "I want to pay {2} dollars for {0} pieces of item {1}."
print(myorder.format(itemno, quantity, price))  # output: I want to pay 49.95 dollars for 567 pieces of item 3.

# Escape characters
print("We are the so-called \"Vikings\" from the north.")  # output: We are the so-called "Vikings" from the north.
"""
\" 	Double Quote 	
\' 	Single Quote 	
\\ 	Backslash 	
\n 	New Line 	
\r 	Carriage Return 	
\t 	Tab 	
\b 	Backspace 	
\f 	Form Feed 	

"""

# convert from int/float/comlex to string:
a = str(x)

# more methods:https://www.w3schools.com/python/python_ref_string.asp
