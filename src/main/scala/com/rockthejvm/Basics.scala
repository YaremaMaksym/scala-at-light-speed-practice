package com.rockthejvm

object Basics extends App{

  val age: Int = 19 // val is constant

  val aBoolean = false // type is optional

  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The age is $age"

  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  val ifExpression = if (age > 18) 10 else 5
  val chainedIfExpression = {
    if (age > 18) 10
    else if (age < 10) 5
    else 0
  }

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 99

    // val of block is the val of the last expression
    aLocalValue + 3
  }

  //func
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  def unitReturningFunction(): Unit = {
    println("Called unitReturningFunction()")
  }

  val theUnit = ()
  println("Unit: " + theUnit)
}
