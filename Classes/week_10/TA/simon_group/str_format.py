__author__ = "Simon Pikalov"


if __name__ == '__main__':
    print(1, 2, 3, sep=',', end="\n\n\n\n")
    print("@")

    # first way to format str
    my_id = input("Please insert your id :")
    name = input("Please insert your name :")
    s = "Id is :{}, and name is {}."
    print(s.format(my_id, name))

    # second way to format str
    my_id, name = input("plese insert id and name (with a space)  :").split()  # note the unpack
    p = f"Id is :{my_id}, and name is {name}."
    print(p)


