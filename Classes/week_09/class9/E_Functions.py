# OOP: Intro to Python_101, for java programmers: Functions

def sum(a,b):
    c = a+b
    return c

a,b = 3,7  # fast init
d = sum(a,b)
print(d)

def apply(q, x, y):
    return q(x,y)

ans = apply(sum, a, d)
print(ans)

def apply1(q, x):
    return q(x)

ans = apply1(lambda z: z * 4, 7)
print(ans)

def inc(v,delta=1):
    return v+delta

a=4
a=inc(a)
print(a)
b=inc(a,a)
print(b)

import math as MyMath

t = MyMath.sqrt(20)
print(t)


def divide(x, y):
    result = None
    try:
        result = x / y
    except ZeroDivisionError:
        print ("division by zero!")
    else:
        print("result is",  result)
    finally:
        print  ("executing finally clause")
    return result

print (divide(9,4))
print (divide(9,0))
