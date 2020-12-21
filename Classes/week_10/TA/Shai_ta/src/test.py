import unittest

from src.main import Student


class Testing(unittest.TestCase):
    def test_name(self):
        std_a = Student("Dude", 23.4, [])
        self.assertEqual(std_a.name, 'Dwude')


if __name__ == '__main__':
    unittest.main()
