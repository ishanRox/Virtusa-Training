package main

import (
	"fmt"
	"math"
)

//package level variable
var packageLevelVariable = 1996

func main() {
	//hello world
	fmt.Println("hello go world !")

	//variables but u must use it
	var num = 1
	var num1 = 10

	fmt.Println(num + num1)

	//U can specify type too and for default values
	//you need to specify types
	var no int = 1000
	var no1 int

	//assign multiples
	var no2, no3 = 11, 22

	fmt.Println(no + no1)
	fmt.Println(no2+no3, "multiple values assgin in one line")

	//amazing var ishan=1000 then why var
	//why we cant simply say ishan=1000
	//prblem is how compiler know its
	//assignment or var creation
	//solution is := for creation

	ishan := "ishan is my name"
	ishan = "ishan is awsome"
	fmt.Println(ishan)

	const birthDay = "1996 1 26"
	fmt.Println(birthDay)

	//loops
	//rob pike and ken u beauty only one for loop
	counter := 1
	for {
		if counter == 10 {
			break
		}
		counter++
		fmt.Println(counter, "this is while true loop")
	}

	//normal for loop
	for i := 0; i <= 100; i++ {
		fmt.Println(i, "hello for loop")
	}

	println(square(10))

	added, substracted := returnAddAndSub(20, 10)
	println(added, substracted)

	a, s := ageAndsalary()
	println(a, s)

	valOutsideFun()

	//Math functions

	println(math.Sqrt(10))

}

//functions

//simple one
func square(x int) int {
	x = x * x
	return x

}

//2 return types ohh ken
func returnAddAndSub(x, y int) (int, int) {
	var add = x + y
	var minus = x - y
	return add, minus
}

//return without names at return

func ageAndsalary() (age int, salary int) {
	age = 24
	salary = 50

	return

}

//Function scopes

func valOutsideFun() {
	fmt.Println(packageLevelVariable)

}
