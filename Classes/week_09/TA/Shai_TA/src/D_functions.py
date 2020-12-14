def fib(n: int = 10) -> int:
    """
    Print a Fibonacci series up to n
    :param n: The fibonacci number
    :return: The n Fibonacci number
    """
    a, b = 0, 1
    for i in range(n):
        a, b = b, a + b

    return a


f_n = fib(4)
print("f(4):", f_n)
print("f():", fib())


def f(a: int, stat_l: list = []):
    stat_l.append(a)
    print(stat_l)


f(1)
f(2)
f(3)


def p_f():
    pass


p_f()

lam = lambda x, y: print(10 * x + y)
print(lam)
lam(1, 2)

num_list = [1, 5, 3, 6, 2]
print(num_list)
num_list.sort()
print(num_list)

pair_list = [(2, 'two'), (1, 'one'), (3, 'three'), (4, 'four')]
pair_list.sort()
pair_list.sort(reverse=True)
pair_list.sort(key=lambda pair: len(pair[1]))
print(pair_list)


def main():
    print("Main Function!")


if __name__ == "__main__":
    main()
