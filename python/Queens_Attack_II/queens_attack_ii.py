import unittest


def queensAttack(n, k, r_q, c_q, obstacles):
    up_obstacle = None
    down_obstacle = None
    right_obstacle = None
    left_obstacle = None
    up_right_obstacle = None
    down_right_obstacle = None
    up_left_obstacle = None
    down_left_obstacle = None
    for obstacle in obstacles:
        if is_over_the_queen(obstacle, r_q, c_q):
            if up_obstacle is None:
                up_obstacle = obstacle
            elif obstacle[0] < up_obstacle[0]:
                up_obstacle = obstacle

        if is_under_the_queen(obstacle, r_q, c_q):
            if down_obstacle is None:
                down_obstacle = obstacle
            elif obstacle[0] > down_obstacle[0]:
                down_obstacle = obstacle

        if is_right_of_the_queen(obstacle, r_q, c_q):
            if right_obstacle is None:
                right_obstacle = obstacle
            elif obstacle[1] < right_obstacle[1]:
                right_obstacle = obstacle

        if is_left_of_the_queen(obstacle, r_q, c_q):
            if left_obstacle is None:
                left_obstacle = obstacle
            elif obstacle[1] > left_obstacle[1]:
                left_obstacle = obstacle

        if is_upper_right_of_the_queen(obstacle, r_q, c_q):
            if up_right_obstacle is None:
                up_right_obstacle = obstacle
            elif obstacle[1] < up_right_obstacle[1]:
                up_right_obstacle = obstacle

        if is_lower_left_of_the_queen(obstacle, r_q, c_q):
            if down_left_obstacle is None:
                down_left_obstacle = obstacle
            elif obstacle[1] > down_left_obstacle[1]:
                down_left_obstacle = obstacle

        if is_upper_left_of_the_queen(obstacle, r_q, c_q):
            if up_left_obstacle is None:
                up_left_obstacle = obstacle
            elif obstacle[0] < up_left_obstacle[0]:
                up_left_obstacle = obstacle

        if is_lower_right_of_the_queen(obstacle, r_q, c_q):
            if down_right_obstacle is None:
                down_right_obstacle = obstacle
            elif obstacle[0] > down_right_obstacle[0]:
                down_right_obstacle = obstacle

    number_of_movements = 0
    if up_obstacle is not None:
        number_of_movements += up_obstacle[0] - r_q - 1
    else:
        number_of_movements += max(n - r_q, 0)

    if up_left_obstacle is not None:
        number_of_movements += up_left_obstacle[0] - r_q - 1
    else:
        number_of_movements += min(max(n - r_q, 0), max(c_q - 1, 0))

    if up_right_obstacle is not None:
        number_of_movements += up_right_obstacle[0] - r_q - 1
    else:
        number_of_movements += min(max(n - r_q, 0), max(n - c_q, 0))

    if down_obstacle is not None:
        number_of_movements += r_q - down_obstacle[0] - 1
    else:
        number_of_movements += max(r_q - 1, 0)

    if down_left_obstacle is not None:
        number_of_movements += r_q - down_left_obstacle[0] - 1
    else:
        number_of_movements += min(max(r_q - 1, 0), max(c_q - 1, 0))

    if down_right_obstacle is not None:
        number_of_movements += r_q - down_right_obstacle[0] - 1
    else:
        number_of_movements += min(max(r_q - 1, 0), max(n - c_q, 0))

    if left_obstacle is not None:
        number_of_movements += c_q - left_obstacle[1] - 1
    else:
        number_of_movements += max(c_q - 1, 0)

    if right_obstacle is not None:
        number_of_movements += right_obstacle[1] - c_q - 1
    else:
        number_of_movements += max(n - c_q, 0)

    return number_of_movements


def is_over_the_queen(obstacle, r_q, c_q):
    return obstacle[1] == c_q and obstacle[0] > r_q


def is_under_the_queen(obstacle, r_q, c_q):
    return obstacle[1] == c_q and obstacle[0] < r_q


def is_right_of_the_queen(obstacle, r_q, c_q):
    return obstacle[0] == r_q and obstacle[1] > c_q


def is_left_of_the_queen(obstacle, r_q, c_q):
    return obstacle[0] == r_q and obstacle[1] < c_q


def is_upper_right_of_the_queen(obstacle, r_q, c_q):
    return obstacle[0] - r_q == obstacle[1] - c_q and obstacle[0] - r_q > 0 and obstacle[1] - c_q > 0


def is_lower_left_of_the_queen(obstacle, r_q, c_q):
    return obstacle[0] - r_q == obstacle[1] - c_q and obstacle[0] - r_q < 0 and obstacle[1] - c_q < 0


def is_upper_left_of_the_queen(obstacle, r_q, c_q):
    return abs(obstacle[0] - r_q) == abs(obstacle[1] - c_q) and obstacle[0] - r_q > 0 and obstacle[1] - c_q < 0


def is_lower_right_of_the_queen(obstacle, r_q, c_q):
    return abs(obstacle[0] - r_q) == abs(obstacle[1] - c_q) and obstacle[0] - r_q < 0 and obstacle[1] - c_q > 0


class TestStringMethods(unittest.TestCase):

    def test_1(self):
        n = 4
        k = 0
        r_q = 4
        c_q = 4
        obstacles = []
        self.assertEqual(queensAttack(n, k, r_q, c_q, obstacles), 9)

    def test_2(self):
        n = 5
        k = 3
        r_q = 4
        c_q = 3
        obstacles = [[5, 5], [4, 2], [2, 3]]
        self.assertEqual(queensAttack(n, k, r_q, c_q, obstacles), 10)

    def test_6(self):
        file = open("./test6.txt", "r")
        line_list = [line.rstrip('\n') for line in file]
        file.close()
        nk = line_list.pop(0).split(" ")
        n = int(nk[0])
        k = int(nk[1])
        rc = line_list.pop(0).split(" ")
        r_q = int(rc[0])
        c_q = int(rc[1])
        obstacles = []
        for line in line_list:
            obstacles.append(list(map(int, line.split())))
        self.assertEqual(queensAttack(n, k, r_q, c_q, obstacles), 40)


if __name__ == '__main__':
    unittest.main()
