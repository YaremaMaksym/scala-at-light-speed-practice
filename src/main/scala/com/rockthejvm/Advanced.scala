package com.rockthejvm

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced extends App {

  /**
   * Lazy evaluation
   */
  lazy val aLazyVal = 2
  lazy val aLazyValueWithSideEffect = {
    println("lazy evaluation")
    43
  }

  val eagerValue = aLazyValueWithSideEffect
  // useful in infinite collections

  /**
   * "pseudo-collections": Option, Try
   */
  def methodWhichCanReturnNull(): String = "hello, Scala"
  val anOption = Option(methodWhichCanReturnNull())
  // option = type which either contains or doesn't contain value: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a string $string"
    case None => "I obtained nothing"
  }

  def methodWhichCanThorwException(): String = throw new RuntimeException()
  val aTry = Try(methodWhichCanThorwException())
  // try contains: value, or an exception if code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid value $validValue"
    case Failure(exception) => s"I obtained an exception: $exception"
  }
  // map, flatMap, filter

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */

  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }

  // Future is a type which contains a value when it's evaluated
  // Future is composable with map, flatMap and filter

  /**
   * Implicits basics
   */
  // #1 implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // #2 implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // new MyRichInteger(23).isEven()
  // use carefully
}
