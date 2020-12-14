x = 10

if x < 0:
    print("Num is negative")
elif x > 10:
    print("X is larger then ZERO")
else:
    print("x is boring")

x = 0
while True:
    print(x)
    if x == 4:
        x += 1.1
        continue
    x += 1

    if x == 2:
        x += 1
    if x > 20:
        break
