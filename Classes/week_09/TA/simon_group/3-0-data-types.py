"""
Data-types def
"""
# _____________________________________________Strings_____________________________________________#


# Text Type: 	str
m = "Hello World"

# same as

m = 'Hello World'

# _____________________________________________Numbers_____________________________________________#


# Numeric Types: 	int, float, complex
x, y, z = 1, 35656222554887711, -3255522  # int:  whole number, positive or negative, without decimals, of unlimited length.
a, b, c = 2.8, -35.59, -87.7e100  # float: positive or negative, containing one or more decimals.

# _____________________________________________Sequences_____________________________________________#
# Sequence Types: 	list, tuple, range
# ______________________________________________#

# Lists:
x = ["apple", "banana", "cherry"]  # list: ordered and changeable. Allows duplicate members

thislist = ["apple", "banana", "cherry"]
print(thislist)

# ______________________________________________#


# tuple:  ordered and unchangeable. Allows duplicate members.
y = ("apple", "banana", "cherry")  # assign

# ______________________________________________#
x = range(6)  # range(start, stop, step)
# ______________________________________________#
# Mapping Type: 	dict
a = {"name": "John", "age": 36}  # dict: unordered, changeable and indexed. No duplicate members.
# _____________________________________________Sets_____________________________________________#
# Set Types: 	set, frozenset
# set: unordered and unindexed. No duplicate members.
z = {"apple", "banana", "cherry"}
thisset = set(("apple", "banana", "cherry"))

b = frozenset({"apple", "banana", "cherry"})  # immutable version of a Python set
# ______________________________________________#

# _____________________________________________Booleans_____________________________________________#


# Boolean Type: 	bool
m = True
l = False

# _____________________________________________Binary Types_____________________________________________#

# Binary Types: 	bytes, bytearray, memoryview
x = b"Hello"
x = bytearray(5)
x = memoryview(bytes(5))
