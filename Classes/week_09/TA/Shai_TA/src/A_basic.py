# Hello world
print('Hello World')

# Basic variables
x = 42
y = 3.14159265359
z = "Dude"
print("x =", x)
print("x =" + str(x))
print("y =", y)
print("z =", z)

# var value change
x = "42"
print("x =", x)

# String Format use
print("y =\t{:f}".format(y))
print("y =\t{:.3f}".format(y))
print("z =\t{:s}".format(z))

# Conversion
print(float(str(y)))

# Calculator
print("5+3 =", 5 + 3)
print("5*3 =", 5 * 3)
print("5/3 =", 5 / 3)
print("5//3 =", 5 // 3)
print("5**3 =", 5 ** 3, "(power(5,3))")

# Strings
word = "mongoose"
print(word)
print(word[1])
print(word[:1])
print(word[:2])
print(word[2:5])
print(word[2:])
print(len(word))

# Lists
num_lst = [1, 2, 3]
print(num_lst)
num_lst.append(123)
print(num_lst)

num_lst.append("Dude")
print(num_lst)

num_lst += [11, 22, 33]
print(num_lst)

shallow_copy = num_lst
shallow_copy += [99]
print(num_lst)

copy_lst = num_lst[:]
copy_lst += [-1]
print("num_lst  = ", num_lst)
print("copy_lst = ", copy_lst)

print(num_lst[:4])
num_lst[0] = 10000
print(num_lst)

num_lst[0:2] = [88, 88]
print(num_lst)

dub_lst = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
print(dub_lst)
print(dub_lst[1])
print(dub_lst[1][2])
