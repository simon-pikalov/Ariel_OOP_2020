import json


class Student:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __str__(self):
        return "{},{}".format(self.name, self.age)


def main():
    rand_dict = {"name": "yossi", "age": 34}
    with open("yossi.json", 'w') as json_file:
        json.dump(rand_dict, json_file)
    fp = open("yossi.json")
    stud_yossi = Student(**json.load(fp))
    print(stud_yossi)


if __name__ == '__main__':
    main()
