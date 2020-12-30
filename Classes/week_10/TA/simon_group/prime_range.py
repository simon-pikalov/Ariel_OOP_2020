

import math

from datetime import time


class PrimeRange:

    def __init__(self, start=1, end=10):
        if start < 0 or end < 1:
            raise Exception("range is undefined")
        self.start = start
        self.end = end
        self.num = start
        self.__author__ = "Simon Pikalov"


    def __iter__(self):
        return self

    def __next__(self):
        for num in range(self.num, self.end + 1):
            if num > 1:
                for i in range(2, int(math.sqrt(num) + 1)):
                    if (num % i) == 0:
                        break
                else:
                    self.num = num + 1
                    return num
            if num == self.end:
                raise StopIteration


if __name__ == '__main__':
    for i in PrimeRange(1, 100):
        print(i)

    list_primes2 = list(map(lambda  i :i ,PrimeRange(1,1000))) # map function
    list_primes = [p for p in PrimeRange(1,1000)] # list comprehension
    print(list_primes)
    print(list_primes2)