# OOP: Intro to Python_101, for java programmers
print("Sequence Types: Strings,Tuples, Lists, ")
s = "hello world" # String: a simple immutable sequence of chars
t = (1,2,5,"abs",2.1) # Tuple: a simple immutable ordered sequence of items mixed types
print(t[2])
l = [1,2,3,"21", 2.1, (2,3,4),[1,2,3], 'a'] # List: Mutable ordered sequence of items of mixed types
print(l[5])
print(type(t[4]))
print(l[-3]) # negative indices starts from the end (-1)
l2 = [0,1,2,3,4,5,6,7,8,9]
l3 = l2[2:6]
l4 = l2[1:-3]
l5 = l2[2:]
l6 = l2[:-2]
l7 = l2[1:-2:2]  # Optional argument allows selection of every nth item
print(l3)
print(l4)
print(l5)
print(l6)
print(l7)

ll2 = l2 # same memory!
lc2 = l2[:] # copy (aka copy constructor)
l2.reverse() # same list (not a new one)
l2[0] = "err"
print(l2)
print(ll2)
print(lc2)

b = 3 in l2
print(b)
b = "err" in lc2
print(b)

l10 = [l2,ll2]
l10 = l10+lc2 # creates a new list (String, Tuple)
print(l10)