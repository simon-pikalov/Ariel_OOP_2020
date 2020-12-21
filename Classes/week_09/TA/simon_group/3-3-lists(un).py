# Access Items
# You access the list items by referring to the index number:
thislist = ["apple", "banana", "cherry"]
print(thislist[1])  # output: apple

# Negative Indexing
# Negative indexing means beginning from the end, -1 refers to the last item, -2 refers to the second last item etc.

thislist = ["apple", "banana", "cherry"]
print(thislist[-1])

# Range of Indexes
# the return value will be a new list with the specified items.
# Note: The search will start at index 2 (included) and end at index 5 (not included).
thislist = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thislist[2:5])
# first item has index 0

# By leaving out the start value, the range will start at the first item:
print(thislist[:4])
# same with end value

# Check if "apple" is present in the list:
thislist = ["apple", "banana", "cherry"]
if "apple" in thislist:
    print("Yes, 'apple' is in the fruits list")

# Change Item Value
# To change the value of a specific item, refer to the index number:
thislist = ["apple", "banana", "cherry"]
thislist[1] = "blackcurrant"
print(thislist)  # output: ['blackcurrant', 'banana', 'cherry']

# Loop Through a List
# You can loop through the list items by using a for loop:
thislist = ["apple", "banana", "cherry"]
for x in thislist:
    print(x)

# List Length
# To determine how many items a list have, use the len() method:
thislist = ["apple", "banana", "cherry"]
print(len(thislist))

# Add Items
# To add an item to the end of the list, use the append() method:
thislist = ["apple", "banana", "cherry"]
thislist.append("orange")
print(thislist)

# To add an item at the specified index, use the insert() method:
thislist = ["apple", "banana", "cherry"]
thislist.insert(1, "orange")
print(thislist)

# Remove Item
# There are several methods to remove items from a list:
thislist = ["apple", "banana", "cherry"]
thislist.remove("banana")
print(thislist)

# The pop() method removes the specified index, (or the last item if index is not specified):
thislist = ["apple", "banana", "cherry"]
thislist.pop()
print(thislist)

# The del keyword removes the specified index:
thislist = ["apple", "banana", "cherry"]
del thislist[0]
print(thislist)

#################################################### Wont Work
# # The del keyword can also delete the list completely:
# thislist = ["apple", "banana", "cherry"]
# del thislist
# print(thislist)  # this will cause an error because "thislist" no longer exists
#################################################### Wont Work

# The clear() method empties the list:
thislist = ["apple", "banana", "cherry"]
thislist.clear()
print(thislist)

# The list() Constructor
# It is also possible to use the list() constructor to make a list.
# note the double round-brackets
thislist = list(("apple", "banana", "cherry"))
print(thislist)

list1 = ["a", "b", "c"]
list2 = [1, 2, 3]

# Join Two Lists
# method 1
list3 = list1 + list2
# method 2
for x in list2:
    list1.append(x)

print(list1)
# method 3
list1.extend(list2)
print(list1)  # append list1 to the end of list 2

# List Methods

# Method            Description

# count()           Returns the number of elements with the specified value
# index()           Returns the index of the first element with the specified value
# reverse()         Reverses the order of the list
# sort()            Sorts the list according to it's data-type
# https://www.w3schools.com/python/python_ref_list.asp
