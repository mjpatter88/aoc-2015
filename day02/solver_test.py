import solver

def test_solve_one_first():
    assert solver.solve_one(2,3,4) == 58

def test_solve_one_second():
    assert solver.solve_one(1,1,10) == 43
