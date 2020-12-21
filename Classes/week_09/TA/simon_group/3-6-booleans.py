"""
Any string is True, except empty strings.
Any number is True, except 0.
Any list, tuple, set, and dictionary are True, except empty ones.
"""
bool("mediate") #output: True
#note: Functions can Return a Boolean
"""
Operators for booleans

== 	Equal 	x == y 	
!= 	Not equal 	x != y 	
> 	Greater than 	x > y 	
< 	Less than 	x < y 	
>= 	Greater than or equal to 	x >= y 	
<= 	Less than or equal to 	x <= y

and  	  Returns True if both statements are true 	x < 5 and  x < 10 	
or 	    Returns True if one of the statements is true 	x < 5 or x < 4 	
not 	  Reverse the result, returns False if the result is true 	not(x < 5 and x < 10) 	
is  	  Returns True if both variables are the same object 	x is y 	
is not  Returns True if both variables are not the same object
in  	  Returns True if a sequence with the specified value is present in the object 	x in y 	
not in 	Returns True if a sequence with the specified value is not present in the object 	x not in y 	
"""

#EX
print(6>=9) #False

x = ["apple", "banana"]

print("banana" in x)

# returns True because a sequence with the value "banana" is in the list
