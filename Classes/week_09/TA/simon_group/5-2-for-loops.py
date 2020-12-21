# _____________________________________for loop_____________________________________#
# for loop: iterating(repeating) over a sequence (that is either a list, a tuple, a dctionary, a set, or a string).

fruits = ["apple", "banana", "cherry"]
for x in fruits:
    print(x)

# Loop Through a String
for x in "banana":
    print(x)

# Exit the loop when x is "banana":
fruits = ["apple", "banana", "cherry"]
for x in fruits:
    print(x)
    if x == "banana":
        break

# Exit the loop when x is "banana", but this time the break comes before the print:(banana is not printed)
fruits = ["apple", "banana", "cherry"]
for x in fruits:
    if x == "banana":
        break
    print(x)

# The continue Statement
fruits = ["apple", "banana", "cherry"]
for x in fruits:
    if x == "banana":
        continue
    print(x)  # doesn't print banana but continues loop

# The range() Function
# To loop through a set of code a specified number of timtes, we can use the range() function,
# The range() starts from 0 by default, and increments by 1 (by default), and ends at a specified number.

for x in range(6):
    print(x)

# Note that range(6) is not the values of 0 to 6, but the values 0 to 5.


# range(2, 6), which means values from 2 to 6 (but no including 6):
for x in range(2, 6):
    print(x)

# increment value by 3
for x in range(2, 30, 3):
    print(x)

# Else in For Loop
#
# The else keyword in a for loop specifies a block of code to be executed when the loop is finished:

# Print all numbers from 0 to 5, and print a message when the loop has ended:
for x in range(6):
    print(x)
else:
    print("Finally finished!")

# Nested Loops
#
# A nested loop is a loop inside a loop.
# The "inner loop" will be executed one time for each iteration of the "outer loop":
adj = ["red", "big", "tasty"]
fruits = ["apple", "banana", "cherry"]

for x in adj:
    for y in fruits:
        print(x, y)  # tryit: https://www.w3schools.com/python/trypython.asp?filename=demo_for_nested
# you can make for loops empty by pass statement:

for x in [0, 1, 2]:
    pass


# Recursion
def tri_recursion(k):
    if (k > 0):
        result = k + tri_recursion(k - 1)
        print(result)
    else:
        result = 0
    return result


print("\n\nRecursion Example Results")
tri_recursion(6)
# ---------------
i = 1
while i < 6:
    print(i)
    i += 1

# The break Statement
#
# With the break statement we can stop the loop even if the wile condition is true:
i = 1
while i < 6:
    print(i)
    if i == 3:
        break
    i += 1

# The continue Statement
#
# With the continue statement we can stop the current iteration, and continue with the next:
i = 0
while i < 6:
    i += 1
    if i == 3:
        continue
    print(i)
