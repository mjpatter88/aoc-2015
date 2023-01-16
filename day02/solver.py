def solve_one(l: int, w: int, h: int) -> int:
    main_size = 2*l*w + 2*w*h + 2*h*l

    side1 = l*w
    side2 = l*h
    side3 = w*h
    extra = min(side1, side2, side3)
    return main_size + extra

def solve1(lines: list[str]) -> int:
    total = 0
    for line in lines:
        values = line.split("x")
        value_ints = [int(x) for x in values]
        total += solve_one(*value_ints)
    return total

def solve2(lines: list[str]) -> int:
    total = 0
    for line in lines:
        values = line.split("x")
        value_ints = [int(x) for x in values]
        l, w, h = value_ints[0], value_ints[1], value_ints[2]
        perim = 2 * min(l+w, l+h, w+h)
        bow = l*w*h
        total += perim
        total += bow
    return total

if __name__ == "__main__":
    with open("input.txt") as in_file:
        in_lines = in_file.readlines()
    print(solve1(in_lines))
    print(solve2(in_lines))
