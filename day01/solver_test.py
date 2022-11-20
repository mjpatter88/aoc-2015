import solver

def test_zero_result():
    assert solver.solve("(())") == 0
    assert solver.solve("()()") == 0

def test_three_result():
    assert solver.solve("(((") == 3
    assert solver.solve("(()(()(") == 3
    assert solver.solve("))(((((") == 3

def test_negative_one_result():
    assert solver.solve("())") == -1
    assert solver.solve("))(") == -1

def test_negative_three_result():
    assert solver.solve(")))") == -3
    assert solver.solve(")())())") == -3

def test_part2_first():
    assert solver.solve2(")") == 1

def test_part2_second():
    assert solver.solve2("()())") == 5
