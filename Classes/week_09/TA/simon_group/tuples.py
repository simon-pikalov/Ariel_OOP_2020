#!/usr/bin/env python

# Python Tuples
#
# A tuple is a collection which is ordered and unchangeable. In Python tuples are written with round brackets.
thistuple = ("apple", "banana", "cherry")

# Access Tuple Items
thistuple = ("apple", "banana", "cherry")
print(thistuple[1])

# Change Tuple Values
# Once a tuple is created, you cannot change its values. Tuples are unchangeable.
thistuple = ("apple", "banana", "cherry")
# thistuple[1] = "blackcurrant"

# The values will remain the same:
print(thistuple)

# Loop Through a Tuple
thistuple = ("apple", "banana", "cherry")
for x in thistuple:
    print(x)

# Tuple Length
thistuple = ("apple", "banana", "cherry")
print(len(thistuple))

# Add Items
# Once a tuple is created, you cannot add items to it. Tuples are unchangeable.
thistuple = ("apple", "banana", "cherry")
# thistuple[3] = "orange" # This will raise an error
print(thistuple)

# Remove Items
#
# Note: You cannot remove items in a tuple
#
# Tuples are unchangeable, so you cannot remove items from it, but you can delete the tuple completely:
thistuple = ("apple", "banana", "cherry")
# del thistuple
print(thistuple)  # this will raise an error because the tuple no longer exists

# The tuple() Constructor
#
# It is also possible to use the tuple() constructor to make a tuple.
thistuple = tuple(("apple", "banana", "cherry"))  # note the double round-brackets
print(thistuple)

# Tuple Methods
#
# Method                    Description
# count()                   Returns the number of times a specified value occurs in a tuple
# index()                   Searches the tuple for a specified value and returns the position of where it was found
