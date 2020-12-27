from abc import ABC, abstractmethod
from typing import List


class Human(ABC):
    _humanId = 0

    def __init__(self, name: str, age: float):
        self.id = Human._humanId
        Human._humanId += 1
        self.name = name[:1].upper() + name[1:]
        self.age = age

    @abstractmethod
    def trick(self):
        """
        This function is an 'abstractmethd' and thus every class that inherits Human
        cannot be initiated without defining it.
        :return:
        """
        pass

    def simple_trick(self):
        """
        This function is *not* an 'abstractmethd' and thus classes that inherits Human
        don't have to define it, but they will raise an exception if it is used/
        :return:
        """
        raise NotImplementedError


class Student(Human):
    _serialId = 0

    def __init__(self, name: str, age: float, classes: List[str] = None):
        super().__init__(name, age)
        self.id = Student._serialId
        Student._serialId += 1
        self.classes = classes if classes else []

    def add_class(self, new_class: str):
        self.classes.append(new_class)

    def get_classes(self):
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
    studA = Student("Yossi", 23, ["Agrostology", "International Relationships"])
    studB = Student("Jhon", 23, ["Chemistry", "Law"])

    # String
    print("\nString")
    print(studA)

    # Static function
    print("\nStatic Functions")
    Student.print(studB)

    # Sort objects
    print("\nSorting")
    sLst = [studB, studA]
    print("Before sort:", sLst)
    sLst.sort()
    print("After sort: ", sLst)

    # Hash
    print("\nHash")
    sSet = set(sLst)
    print(sSet)

    # Inheritance
    print("\nInheritance")
    [print(x.trick()) for x in sLst]

    # EQ
    print("\nEquals")
    studC = Student("Jhon", 23, ["Chemistry", "Law"])
    print("studB == studB:", studB == studB)
    print("studB == studC:", studB == studC)


if __name__ == '__main__':
    main()
