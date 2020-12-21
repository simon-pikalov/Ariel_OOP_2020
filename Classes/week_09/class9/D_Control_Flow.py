# OOP: Intro to Python_101, for java programmers: Control Flow: if, while, for
x=4
if x == 3:
    print ("X equals 3.")
elif x == 2:
    print ("X equals 2.")
else:
    print ("X equals something else.")
print ("This is outside the ‘if’.")

while x<10:
    print(x)
    x+=2
    #assert(x!=8) # as in Java can be thought as System.exit

for x in [1,2,3]:
    print(x)

for x in "abcd":
    print(x)
points = [(1,2), (2,3), (4,5)]
for (x,y) in points:
    print(x,y)
for x in points:
    print(x)
mylist = ["aa","bb", "ccc"]
for (i, item) in enumerate(mylist):
    print (i, item)
xx = [ x * 3 for (x, y) in points] # function (aka mapping) is fun and highly useful
print(xx)
yy = [ y * 2 for (x, y) in points if y >= 3] # fiter is fun and very useful
print(yy)
myList2 = [str(x)+"_end" for x in ["start_"+str(x) for x in mylist]]
print (myList2)

for x in range(6):
    print(x)