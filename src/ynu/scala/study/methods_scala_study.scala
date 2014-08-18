package ynu.scala.study

/**
 * Created by sariel on 14-8-18.
 */
object methods_scala_study {
  def main(args: Array[String]) {
    val FFF ="========================================================="

    trait Animal {
      def walk { println("Animal is walking") }
    }


    class FourLeggedAnimal extends Animal {
      override def walk { println("I'm walking on all fours") }
      def run { println("I'm running") }
    }
    class Dog extends FourLeggedAnimal {
      def walkThenRun {
        this.walk
        super.run
        super[FourLeggedAnimal].walk
      }
    }
    val suka = new Dog
    suka.walkThenRun
    suka.walk
    println(1,FFF)

    trait Human {
      def hello = "the Human trait"
    }
    trait Mother extends Human {
      override def hello = "Mother"
    }
    trait Father extends Human {
      override def hello = "Father"
    }
    class Child extends Human with Mother with Father {
      def printSuper = super.hello
      def printMother = super[Mother].hello
      def printFather = super[Father].hello
      def printHuman = super[Human].hello
    }
    val c = new Child
    println(s"c.printSuper = ${c.printSuper}")
    println(s"c.printMother = ${c.printMother}")
    println(s"c.printFather = ${c.printFather}")
    println(s"c.printHuman = ${c.printHuman}")
    println(2,FFF)

    class Connection {
      def makeConnection(timeout: Int = 5000, protocol: String = "http") {
        println("timeout = %d, protocol = %s".format(timeout, protocol))
        // more code here
      }
    }
    val d = new Connection
    d.makeConnection()
    d.makeConnection(2000)
    d.makeConnection(3000, "https")
    println(3,FFF)

    class Pizza {
      var crustSize = 12
      var crustType = "Thin"
      def update(crustSize: Int, crustType: String) {
        this.crustSize = crustSize
        this.crustType = crustType }
      override def toString = {
        "A %d inch %s crust pizza.".format(crustSize, crustType)
      }
    }
    val p = new Pizza
    p.update(crustSize = 16, crustType = "Thick")
    println(p)
    p.update(crustType = "Pan", crustSize = 14)
    println(p)
    println(4,FFF)


    def printAll(strings: String*) {
      strings.foreach(println)
    }
    printAll()
    printAll("foo")
    printAll("foo", "bar")
    printAll("foo", "bar", "baz")
    // a sequence of strings
    val fruits = List("apple", "banana", "cherry")
    // pass the sequence to the varargs field
    printAll(fruits: _*)
    // version 1
    def printAllforNum(numbers: Int*) {
      numbers.foreach(println)
    }
    // version 2
//    def printAll(numbers: Int*) {
//      for (i <- numbers) println
//    }
    println(5,FFF)


  }



}
object BoomTest extends App {

  def boom {
    throw new Exception
  }

  println("Before boom")

  boom

  // this line is never reached
  println("After boom")
}


object emp extends App{
  class Person {
    protected var fname = ""
    protected var lname = ""
    def setFirstName(firstName: String): this.type = {
      fname = firstName
      this
    }
    def setLastName(lastName: String): this.type = {
      lname = lastName
      this
    } }
  class Employee extends Person {
    protected var role = ""
    def setRole(role: String): this.type = {
      this.role = role
      this
    }
    override def toString = {
      "%s, %s, %s".format(fname, lname, role)
    }
  }
  val employee = new Employee
  // use the fluent methods
  employee.setFirstName("Al")
          .setLastName("Alexander")
          .setRole("Developer")
  println(employee)
}

final class Pizza {
  import scala.collection.mutable.ArrayBuffer
  private val toppings = ArrayBuffer[String]()
  private var crustSize = 0
  private var crustType = ""
  def addTopping(topping: String) = {
    toppings += topping
    this
  }
  def setCrustSize(crustSize: Int) = {
    this.crustSize = crustSize
    this
  }
  def setCrustType(crustType: String) = {
    this.crustType = crustType
    this
  }
  def print() {
    println(s"crust size: $crustSize")
    println(s"crust type: $crustType")
    println(s"toppings: $toppings")
  }
}
object FluentPizzaTest extends App {
  val p = new Pizza
  p.setCrustSize(14)
    .setCrustType("thin")
    .addTopping("cheese")
    .addTopping("green olives")
    .print()
}