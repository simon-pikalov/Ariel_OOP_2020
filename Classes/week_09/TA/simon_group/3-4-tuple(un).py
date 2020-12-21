# stuff same as lists:
# Access Tuple Items
# Negative Indexing
# Range of Indexes
# Loop Through a Tuple
# Check if Item Exists
# Tuple Length
# create tuple with one item:
# One item tuple, remember the commma:
thistuple = ("apple",)
print(type(thistuple))
# NOT a tuple
thistuple = ("apple")
print(type(thistuple))

# Change Tuple Values
# you can't!, but convert to list then convert back to tuple:
x = ("apple", "banana", "cherry")
y = list(x)
y[1] = "kiwi"
x = tuple(y)

# tuple method:
thistuple = tuple(("apple", "banana", "cherry"))
# Return the number of times the value 5 appears in the tuple:
thistuple = (1, 3, 7, 8, 7, 5, 4, 6, 8, 5)
print(thistuple.count(5))

# Search for the first occurrence of the value 8, and return its position:
thistuple = (1, 3, 7, 8, 7, 5, 4, 6, 8, 5)
print(thistuple.index(8))
# https://www.w3schools.com/python/python_ref_tuple.asp
