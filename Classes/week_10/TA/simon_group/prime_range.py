import math
from datetime import time


class PrimeRange:

    def __init__(self,start  = 1,end = 10):
        if start < 0 or end < 1:
            raise  Exception("range is undefined")
        self.start = start
        self.end= end
        self.num = start

    def __iter__(self):
        return self



    def __next__(self):
        for num in range(self.num, self.end + 1):
            if num > 1:
                for i in range(2, int(math.sqrt(num))):
                    if (num % i) == 0:
                        break
                else:
                    self.num = num+1
                    return num
            if num == self.end:
                raise StopIteration



if __name__ == '__main__':
    for i in PrimeRange(1,100000):
        print(i)

