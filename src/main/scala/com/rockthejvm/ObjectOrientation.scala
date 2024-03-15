package com.rockthejvm

object ObjectOrientation extends App {
  // class and instance
  class Animal {
    val age: Int = 0
    def eat(): Unit = println("Animal is eating")
  }
  val anAnimal = new Animal

  //inheritance
  class Dog(val name: String) extends Animal

  val aDog = new Dog("Lassie")

  // constructor arguments aren't fields: need to put val before constructor argument
  println(aDog.name + " " + aDog.age)

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat()

  // abstract class
  abstract class WalkingAnimal {
    private val hasLegs = true
    def walk(): Unit
  }

  // interface
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

//  single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {

    override def eat(animal: Animal): Unit = println("Crocodile is eating animal")
    override def eat(): Unit = super.eat()

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
}

  val aCroc = new Crocodile
  aCroc.eat(anAnimal)
  aCroc eat anAnimal // infix notation = object method argument, only available for methods with ONE argument
  aCroc ?! "What if we could fly?"

//  operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm dinosaur, so I can eat anything")
  }

  /*
  What does compiler
  class Carnivore_Anonymous_1254 extends Carnivore {
    override def eat(animal: Animal): Unit = println("I'm dinosaur, so I can eat anything")
  }

  val dinosaur = new Carnivore_Anonymous_1254
  */

  object MySingleton { // the only instance of MySingleton type
    val specialValue = 54123
    def specialMethod() = 512
    def apply(x: Int): Int = x + 1
  }

  MySingleton.specialMethod()
  MySingleton.apply(99)
  MySingleton(99) // equivalent


  object Animal { // companions - companion object
//    companions can access each other's private fields/methods
//    singleton Animal and instances of Animal are different things
    val canBuildSpaceShip = false
  }

  val animalsCanBuildSpaceShip = Animal.canBuildSpaceShip // "static" fields methods

  /*
    case classes = lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serializable
    - companion with apply()
    - pattern matching
  */

  case class Person(name: String, age: Int)

//  may be constructed without "new"
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)

//  exceptions
  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some error message"
  } finally {
    // execute some code no matter what
  }

// generics
  trait MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  val aList: List[Int] = List(1, 2, 3) //List.apply(1, 2, 3, 4)
  val first = aList.head
  val rest = aList.tail

  val aStringList = List("hello", "Scala")

//  Point #1: In Scala we usually operate with IMMUTABLE values/objects
//            Any modification to an object must return ANOTHER object
/*
  Benefits:
  1) works miracles in multi-threaded/distributed env
  2) helps making sense of the code ("reasoning about")
*/
  val reversedList = aList.reverse // returns a NEW list

//  Point #2: Scala is closest to the OO ideal
}
