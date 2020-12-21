a = 33
b = 200
if b > a:
    print("b is greater than a")
# Indentation is a must
"""

 Equals: a == b
 Not Equals: a != b
 Less than: a < b
 Less than or equal to: a <= b
 Greater than: a > b
 Greater than or equal to: a >= b
"""
# Elif(i.e.: python says "if the previous conditions were not true, then try this condition".)
a = 33
b = 33
if b > a:
    print("b is greater than a")
elif a == b:
    print("a and b are equal")

# Else

a = 200
b = 33
c = 50
if b > a:
    print("b is greater than a")
elif a == b:
    print("a and b are equal")
else:
    print("a is greater than b")

# Short Hand If
#
# If you have only one statement to execute
if a > b: print("a is greater than b")

# Short Hand If ... Else
print("A") if a > b else print("B")

# One line if else statement, with 3 conditions:
print("A") if a > b else print("=") if a == b else print("B")

# And
if a > b and c > a:
    print("Both conditions are True")
# or
if a > b or a > c:
    print("At least one of the conditions are True")

# You can have if statements inside if statement(Nested if):
x = 41

if x > 10:
    print("Above ten,")
    if x > 20:
        print("and also above 20!")
    else:
        print("but not above 20.")

    # put in the pass statement to make it empty:

a = 33
b = 200

if b > a:
    pass
