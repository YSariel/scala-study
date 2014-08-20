package ynu.scala.study

/**
 * Created by sariel on 14-8-19.
 */
object function_scala_study {
  def main(args: Array[String]) {

    val FFF ="========================================================="


    var votingAge = 18
    val isOfVotingAge = (age: Int) => age >= votingAge

    println(isOfVotingAge(16)) // false
    println(isOfVotingAge(20)) // true

    def printResult(f: Int => Boolean, x: Int) {
      println(f(x))
    }
    printResult(isOfVotingAge, 20) // true
    votingAge = 21
    printResult(isOfVotingAge, 20) // now false
    println(1,FFF)

    import scala.collection.mutable.ArrayBuffer
    val fruits = ArrayBuffer("apple")
    // the function addToBasket has a reference to fruits
    val addToBasket = (s: String) => {
      fruits += s
      println(fruits.mkString(", "))
    }
    def buyStuff(f: String => Unit, s: String) {
      f(s)
    }
    buyStuff(addToBasket, "cherries")
    buyStuff(addToBasket, "grapes")
    println(2,FFF)

    val sum = (a: Int, b: Int, c: Int) => a + b + c
    val f = sum(1, 2, _: Int)
    println(f(3))
    println(3,FFF)

    def wrap(prefix: String, html: String, suffix: String) = {
      prefix + html + suffix
    }
    val wrapWithDiv = wrap("<div>", _: String, "</div>")
    println(wrapWithDiv("<p>Hello, world</p>"))
    println(wrapWithDiv("<img src=\"/images/foo.png\" />"))
    println(4,FFF)

    //Creating a Function That Returns a Function
    //(s: String) => { prefix + " " + s }
    def saySomething(prefix: String) = (s: String) => { prefix + " " + s }
    val sayHello = saySomething("Hello")
    println(sayHello("Al"))
    println(5,FFF)

    def greeting(language: String) = (name: String) => {
      val english = () => "Hello, " + name
      val spanish = () => "Buenos dias, " + name
      language match {
        case "english" => println("returning 'english' function")
          english()
        case "spanish" => println("returning 'spanish' function")
          spanish()
      }
    }
    val hello = greeting("english")
    val buenosDias = greeting("spanish")
    println(hello("Al"))
    println(buenosDias("Lorenzo"))
    println(6,FFF)

//    trait PartialFunction[-A, +B] //extends (A) => B
//    PartialFunction[Int, String]
//    // converts 1 to "one", etc., up to 5
//    val convert1to5 = new PartialFunction[Int, String] {
//      val nums = Array("one", "two", "three", "four", "five")
//      def apply(i: Int) = nums(i-1)
//      def isDefinedAt(i: Int) = i > 0 && i < 6
//    }
//    val convert6to10 = new PartialFunction[Int, String] {
//      val nums = Array("six", "seven", "eight", "nine", "ten")
//      def apply(i: Int) = nums(i-6)
//      def isDefinedAt(i: Int) = i > 5 && i < 11
//    }
//    val handle1to10 = convert1to5 orElse convert6to10
//    println(handle1to10(3),handle1to10(8))

    }

}

object NewtonsMethod {
  def main(args: Array[String]) {
    driver
  }
  /**
   * A "driver" function to test Newton's method.
   * Start with (a) the desired f(x) and f'(x) equations,
   * (b) an initial guess and (c) tolerance values.
   */
  def driver {
    // the f(x) and f'(x) functions
    val fx = (x: Double) => 3*x + math.sin(x) - math.pow(math.E, x)
    val fxPrime = (x: Double) => 3 + math.cos(x) - math.pow(Math.E, x)
    val initialGuess = 0.0
    val tolerance = 0.00005
    // pass f(x) and f'(x) to the Newton's Method function, along with // the initial guess and tolerance
    val answer = newtonsMethod(fx, fxPrime, initialGuess, tolerance)
    println(answer)
  }
  /**
   * Newton's Method for solving equations.
   * @todo check that |f(xNext)| is greater than a second tolerance value
   * @todo check that f'(x) != 0
   */
  def newtonsMethod(fx: Double => Double,
                    fxPrime: Double => Double,
                    x: Double,
                    tolerance: Double): Double = {
    var x1 = x
    var xNext = newtonsMethodHelper(fx, fxPrime, x1)
    while (math.abs(xNext - x1) > tolerance) {
      x1 = xNext
      println(xNext) // debugging (intermediate values)
      xNext = newtonsMethodHelper(fx, fxPrime, x1)
    }
    xNext
  }
  /**
   * This is the "x2 = x1 - f(x1)/f'(x1)" calculation
   */
  def newtonsMethodHelper(fx: Double => Double,
                          fxPrime: Double => Double,
                          x: Double): Double = {
    x - fx(x) / fxPrime(x)
  }
}