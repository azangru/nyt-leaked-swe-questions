# doesListContainTwoSummands takes a list of integers and a target integer, 
# and returns true if the list contains two numbers which sum to the target
# it is currently stubbed out and the unit test is failing
# please fill in some code to make the test pass, and then add some more unit tests
     

class AssertionError < RuntimeError
end

def assert &block
    raise AssertionError unless yield
end


def calculateGCD(a, b)
  # your code here
  return 1
end

assert { calculateGCD(2, 4) == 8 }
puts "All tests passed successfully"
