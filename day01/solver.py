
def solve(input_string: str) -> int:
    floor = 0
    for c in input_string:
        if c == "(":
            floor += 1
        elif c == ")":
            floor -= 1
        else:
            raise ValueError(f"Unexpected input char: {c}")
    return floor

def solve2(input_string: str) -> int:
    floor = 0
    for index, c in enumerate(input_string):
        if c == "(":
            floor += 1
        elif c == ")":
            floor -= 1
        else:
            raise ValueError(f"Unexpected input char: {c}")
        if floor < 0:
            return index+1

    raise ValueError(f"Basement never reached.")

if __name__ == "__main__":
    with open("input.txt") as in_file:
        in_string = in_file.read()
    print(solve(in_string.strip()))
    print(solve2(in_string.strip()))
