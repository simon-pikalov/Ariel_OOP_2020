# While loop
a, b = 0, 1

while a < 100:
    print(a, end=',')
    a, b = b, a + b
print()

# For loop
for i in range(3, 10):
    print(i, end=',')
print()

animals = ['cat', 'dog', 'rat', 'pangolin']
for an in animals:
    print(an, end=',')
print()

for i in range(len(animals)):
    print("{:d}:{:s}".format(i, animals[i]))
print()
