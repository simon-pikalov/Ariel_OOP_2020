# assign
thisdict = {
    "key": "value",
    "brand": "Ford",
    "model": "Mustang",
    "year": 1964}
# or
thisdict = dict(brand="Ford", model="Mustang", year=1964)

# Accessing Items
# Get the value of the "model" key:

x = thisdict["model"]
x = thisdict.get("model")  # output: Mustang

# Change Values

thisdict["year"] = 2018

# Loop Through a Dictionary
#
# Print all key names in the dictionary, one by one:
for x in thisdict:
    print(x)

# Print all values in the dictionary, one by one:
for x in thisdict:
    print(thisdict[x])

for x in thisdict.values():
    print(x)

# Loop through both keys and values, by using the items() function:
for x, y in thisdict.items():
    print(x, y)

# Check if "model" is present in the dictionary:
if "model" in thisdict:
    print("Yes, 'model' is one of the keys in the thisdict dictionary")

# length
print(len(thisdict))

# Adding Items
#
# Adding an item to the dictionary is done by using a new index key and
thisdict["color"] = "red"
print(thisdict)

# Removing Items

# The del keyword removes the item with the specified key name:
del thisdict["model"]

# The pop() method removes the item with the specified key name:
try :
    thisdict.pop("model")
    print(thisdict)
except:
    print("Cant pop a non existing key")

# The popitem() method removes the last inserted item (in versions before 3.7, a random item is removed instead):
thisdict.popitem()
print(thisdict)


# Make a copy of a dictionary with the copy() method:
mydict = thisdict.copy()


# The clear() keyword empties the dictionary:
thisdict.clear()

# The del keyword can also delete the dictionary completely:
del thisdict



# Nested Dictionaries
# Dictionaries in one dic.

myfamily = {
    "child1": {
        "name": "Emil",
        "year": 2004
    },
    "child2": {
        "name": "Tobias",
        "year": 2007
    },
    "child3": {
        "name": "Linus",
        "year": 2011
    }
}

# OR

child1 = {
    "name": "Emil",
    "year": 2004
}
child2 = {
    "name": "Tobias",
    "year": 2007
}
child3 = {
    "name": "Linus",
    "year": 2011
}

myfamily = {
    "child1": child1,
    "child2": child2,
    "child3": child3
}

# More methods here:https://www.w3schools.com/python/python_ref_dictionary.asp
