package main

import (
	"log"
)

/**
 * doesListContainTwoSummands takes a list of integers and a target integer, and returns true if the list contains two numbers which sum to the target
 * it is currently stubbed out and the unit test is failing
 * please fill in some code to make the test pass, and then add some more unit tests
 *
 * submitted by ben.solwitz@nytimes.com updated to Go by jonathan.henry@nytimes.com
 */
func doesListContainTwoSummands(summands []int, target int) bool {
	return false
}

func main() {

	test1 := doesListContainTwoSummands([]int{2, 4, 3}, 5)
	if test1 != true {
		log.Fatal("failed assertion for test1")
	}

}
