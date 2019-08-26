#!/bin/python3
import unittest


def non_divisible_subset(k, s):
    dictionary_for_different_sets = {}

    initialize_dictionary_with_empty_sets_for_each_possible_remainder(dictionary_for_different_sets, k)

    populate_the_dictionary(dictionary_for_different_sets, s, k)

    solution = set()

    for remainder in range(k):
        if remainder == 0:
            set_of_0 = dictionary_for_different_sets.get(0)
            if len(set_of_0) > 0:
                solution.add(next(iter(set_of_0)))
        else:
            set_1 = remainder
            set_2 = k - remainder
            if set_1 > set_2:
                break
            elif set_1 == set_2:
                set_of_1 = dictionary_for_different_sets.get(set_1)
                if len(set_of_1) > 0:
                    solution.add(next(iter(set_of_1)))
            else:
                set_1_size = len(dictionary_for_different_sets.get(set_1))
                set_2_size = len(dictionary_for_different_sets.get(set_2))
                solution.update(dictionary_for_different_sets.get(set_1 if set_1_size > set_2_size else set_2))

    return len(solution)


def initialize_dictionary_with_empty_sets_for_each_possible_remainder(dictionary, k):
    for i in range(k):
        dictionary[i] = set()


def populate_the_dictionary(dictionary, s, k):
    for number in s:
        add_the_number_to_the_set_of_each_remainder(dictionary, number, k)


def add_the_number_to_the_set_of_each_remainder(dictionary, number, k):
    remainder = number % k
    set_of_numbers = dictionary.get(remainder, set())
    set_of_numbers.add(number)


class TestStringMethods(unittest.TestCase):

    def test_1(self):
        k = 9
        string = "61197933 56459859 319018589 271720536 358582070 849720202 481165658 675266245 541667092 615618805 129027583 755570852 437001718 86763458 791564527 163795318 981341013 516958303 592324531 611671866 157795445 718701842 773810960 72800260 281252802 404319361 757224413 682600363 606641861 986674925 176725535 256166138 827035972 124896145 37969090 136814243 274957936 980688849 293456190 141209943 346065260 550594766 132159011 491368651 3772767 131852400 633124868 148168785 339205816 705527969 551343090 824338597 241776176 286091680 919941899 728704934 37548669 513249437 888944501 239457900 977532594 140391002 260004333 911069927 586821751 113740158 370372870 97014913 28011421 489017248 492953261 73530695 27277034 570013262 81306939 519086053 993680429 599609256 639477062 677313848 950497430 672417749 266140123 601572332 273157042 777834449 123586826"
        s = list(map(int, string.split(" ")))

        self.assertEqual(non_divisible_subset(k, s), 50)

    def test_2(self):
        k = 4
        string = "1 2 3 4 5 6 7 8 9 10"
        s = list(map(int, string.split(" ")))

        self.assertEqual(non_divisible_subset(k, s), 5)

    def test_3(self):
        k = 100
        file = open("./100.txt", "r")
        string = file.read()
        file.close()
        s = list(map(int, string.split(" ")))

        self.assertEqual(non_divisible_subset(k, s), 49747)


if __name__ == '__main__':
    unittest.main()
