if __name__ == '__main__':
    # first way to format str
    idd = input("Please insert your id :")
    name = input("Please insert your name :")
    s = "Id is :{}, and name is {}."
    print(s.format(idd, name))

    # second way to format str
    idd, name = input("plese insert id and name (with a space)  :").split()  # note the unpack
    p = f"Id is :{idd}, and name is {name}."
    print(p)
