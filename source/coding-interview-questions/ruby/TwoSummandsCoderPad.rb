# doesListContainTwoSummands takes a list of integers and a target integer, 
# and returns true if the list contains two numbers which sum to the target
# it is currently stubbed out and the unit test is failing
# please fill in some code to make the test pass, and then add some more unit tests
     

class AssertionError < RuntimeError
end

def assert &block
    raise AssertionError unless yield
end



def doesListContainTwoSummands(summands, target)
  # your code here
  return true
end

assert { doesListContainTwoSummands([1,2,3], 5) == true }
puts "All tests passed successfully"

