# Check if "banana" is present in the set:
thisset = {"apple", "banana", "cherry"}
print("banana" in thisset)

# you cannot change its items, but you can add new items.
# same as lists:
# Get the Length of a Set
# The clear() method
# The del keyword will delete the set completely

# The union() method returns a new set with all items from both sets:
set1 = {"a", "b", "c"}
set2 = {1, 2, 3}
set3 = set1.union(set2)

# Note: Both union() and update() will exclude any duplicate items.
# The update() method inserts the items in set2 into set1:
set1.update(set2)

# To remove an item in a set, use the remove(), or the discard() method.
thisset.remove("banana")
# Note: If the item to remove does not exist, discard() will NOT raise an error.
# pop() will not tell you what item that gets removed.(i.e random deleting)
# TODO: SET METHODS FILE_______________________________NNN______________________________________
