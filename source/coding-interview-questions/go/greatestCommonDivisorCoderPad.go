package main

import (
	"log"
)

/**
 * calculateGCD takes two integers and returns the greatest common divisor
 * it is currently stubbed out and the unit test is failing
 * please fill in some code to make the test pass, and then add some more unit tests
 *
 * submitted by ben.solwitz@nytimes.com updated to Go by jonathan.henry@nytimes.com
 */
func calculateGCD(a, b int) int {

	return 0
}

func main() {

	test1 := calculateGCD(8, 2)
	if test1 != 2 {
		log.Fatal("failed assertion for test1")
	}

}
