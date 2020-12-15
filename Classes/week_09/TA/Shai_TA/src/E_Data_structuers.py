def lists():
    num_lst = [1, 2, 3, 4, 5, 6]
    print(num_lst)

    num_lst.append(99)
    num_lst += [22, 33, 44]
    print(num_lst)

    num_lst.insert(3, 9999999)
    print(num_lst)

    num_lst.remove(9999999)
    print(num_lst)

    num_lst.pop()
    print(num_lst)

    num_lst.pop(2)
    print(num_lst)

    idx = num_lst.index(99)
    print("idx for 99:", idx)

    num_lst.clear()
    print(num_lst)


def sets():
    num_set = {7, 4, 8, 4, 2}
    print(num_set)

    num_set.pop()
    print(num_set)

    print(num_set.difference({1, 4, 5}))
    print(num_set - {1, 4, 5})  # In a but not in b

    print(num_set | {4, 2, 1})  # Or
    print(num_set & {4, 2, 1})  # And
    print(num_set ^ {4, 2, 1})  # XOR


def coolLoops():
    squares = []
    for x in range(10):
        squares.append(x ** 2)
    print(squares)

    print([x ** 2 for x in range(10)])

    print(list(map(lambda x: x ** 2, range(10))))

    print([x ** 2 for x in range(10) if x % 2 == 0])

    print("Matrix")
    mat = [[(i, j) for i in range(4)] for j in range(3)]
    for r in mat:
        print(r)


def tuples():
    t = (1, 2, 3, 4)
    print(t)
    print(t[3])
    print(t[2:4])

    w, x, y, z = t
    print(w)
    print(x)
    print(y)
    print(z)


def dictionaries():
    word_dict = {"word": 1, "another": 2}
    print(word_dict)

    word_dict['New_word'] = 5
    print(word_dict)

    print(word_dict['word'])

    print(word_dict.keys())
    print(word_dict.values())

    for k, v in word_dict.items():
        print("\t", k, ":", v)


def looping_tech():
    word_dict = {"word": 1, "another": 2, 'New_word': 5}
    for i, d in enumerate(word_dict.values()):
        print(i, ":", d)
    print()

    lst_a = ["a", "b", "c"]
    lst_b = [1, 2, 3]
    for a, b in zip(lst_a, lst_b):
        print(a, ":", b)
    print()


def main():
    # lists()
    # sets()
    # coolLoops()
    # tuples()
    # dictionaries()
    looping_tech()


if __name__ == '__main__':
    main()
