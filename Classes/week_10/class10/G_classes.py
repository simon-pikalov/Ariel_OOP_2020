# from: https://docs.python.org/3/tutorial/classes.html
class Dog:

    s_tricks = []             # mistaken use of a class variable

    def __init__(self, n):
        self.name = n
        self.tricks = []    # creates a new empty list for each dog
     #   self.s_tricks = []

    def add_trick(self, trick):
        self.tricks.append(trick)

    def add_s_trick(self, s_trick):
        self.s_tricks.append(s_trick)

d = Dog('Dobi')
e = Dog('Lassy')
d.add_trick('roll over')
e.add_trick('play dead')
print(e.tricks)
print(d.tricks)

e.add_s_trick('play')
e.add_s_trick('sleep')
d.add_s_trick('dd')
e.add_s_trick('sleep')
print(d.s_tricks)   # unexpectedly shared by all dogs ['roll over', 'play dead'] --> Static
# print(dir(Dog))