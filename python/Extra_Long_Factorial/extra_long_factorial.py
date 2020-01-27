import unittest


def extraLongFactorials(n):
    if n == 2:
        return 2
    else:
        return n * extraLongFactorials(n - 1)


class TestStringMethods(unittest.TestCase):

    def test_1(self):
        self.assertEqual(extraLongFactorials(25), 15511210043330985984000000)


if __name__ == '__main__':
    unittest.main()
