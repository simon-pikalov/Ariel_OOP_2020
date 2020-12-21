from typing import List


class Human(object):
    _human_id = 0

    def __init__(self, name: str, age: float):
        self.id = Human._human_id
        Human._human_id += 1
        self.name = name[:1].upper() + name[1:]
        self.age = age

    def trick(self):
        raise NotImplementedError


class Student(Human):
    _serial_id = 0

    def __init__(self, name: str, age: float, classes: List[str] = None):
        super().__init__(name, age)
        self.id = Student._serial_id
        Student._serial_id += 1
        self.classes = classes if classes else []

    def addClass(self, new_class: str):
        self.classes.append(new_class)

    def getClasses(self):
        return self.classes

    def trick(self):
        return "Pop Pop!!"

    def __str__(self):
        return "<Student:{:s},ID:{:.2f}>".format(self.name, self.id)

    def __repr__(self):
        return str(self)

    def __eq__(self, other):
        # return self.id is other.id
        return self.name is other.name

    def __lt__(self, other):
        return self.id < other.id

    def __hash__(self):
        return self.id

    @staticmethod
    def print(student):
        print("Student Name: {:s}".format(student.name))
        print("ID: {:d}".format(student.id))
        print("Classes:")
        for c in student.classes:
            print("\t{:s}".format(c))


def main():
    stud_a = Student("Yossi", 23, ["Agrostology", "International Relationships"])
    stud_b = Student("Jhon", 23, ["Chemistry", "Law"])

    # String
    print("\nString")
    print(stud_a)

    # Static function
    print("\nStatic Functions")
    Student.print(stud_b)

    # Sort objects
    print("\nSorting")
    s_lst = [stud_b, stud_a]
    print("Before sort:", s_lst)
    s_lst.sort()
    print("After sort: ", s_lst)

    # Hash
    print("\nHash")
    s_set = set(s_lst)
    print(s_set)

    # Inheritance
    print("\nInheritance")
    [print(x.trick()) for x in s_lst]

    # EQ
    print("\nEquals")
    stud_c = Student("Jhon", 23, ["Chemistry", "Law"])
    print("stud_b == stud_b:", stud_b == stud_b)
    print("stud_b == stud_c:", stud_b == stud_c)


if __name__ == '__main__':
    main()
