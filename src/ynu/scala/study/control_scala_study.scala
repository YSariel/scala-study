package ynu.scala.study


/**
 * Created by sariel on 14-8-15.
 */
object control_scala_study {
  def main(args: Array[String]) {
    val FFF ="========================================================="

    val a = Array("apple", "banana", "orange")
    for (e <- a) println(e)
    for (e <- a) {
      val s = e.toUpperCase()
      println(s)
    }
    for (i <- 0 until a.length) {
      println(s"$i is ${a(i)}")
    }
    for ((e, count) <- a.zipWithIndex) {
      println(s"$count is $e")
    }
    println(1,FFF)

    for (i <- 1 to 10 if i < 4) println(i)
    println(2,FFF)

    val names = Map("fname" -> "Dark", "lname" -> "Sariel")
    for ((k,v) <- names)
      println(s"key: $k, value: $v")
    println(3,FFF)

    a.foreach(println)
    a.foreach(e => println(e.toUpperCase))
    a.foreach { e =>
      val s = e.toUpperCase
      println(s)
    }
    println(4,FFF)

    val nums = List(1,2,3)
    for (i <- nums) println(i)
    nums.foreach(((i) => println(i)))
    println(5,FFF)

    for { i <- 1 to 5 } yield println(i)
    1.to(5).map(((i) => println(i)))
    println(6,FFF)

    for (i <- 1 to 2; j <- 1 to 2)
      println(s"i = $i, j = $j")
    for {
      i <- 1 to 2
      j <- 1 to 3
      k <- 1 to 5
    } println(s"i = $i, j = $j, k = $k")
    println(7,FFF)

    val array = Array.ofDim[Int](2,2)
    for {
      i <- 0 to 1
      j <- 0 to 1
     } println(s"($i)($j) = ${array(i)(j)}")
    println(8,FFF)

    var fruits = scala.collection.mutable.ArrayBuffer[String]()
    fruits += "apple"
    fruits += "banana"
    fruits += "orange"
    for (e <- fruits) yield println(e.toUpperCase)
    println(9,FFF)

    val fruits2 = "apple" :: "banana" :: "orange" :: Nil
    for (e <- fruits2) yield println(e.toUpperCase)
    val out = fruits2.map(_.toUpperCase)
    println(out)
    println(10,FFF)

    def sumToMax(arr: Array[Int], limit: Int): Int = { var sum = 0
      for (i <- arr) {
        sum += i
        if (sum > limit) return limit }
      sum
    }
    val arr = Array.range(0,10)
    println(sumToMax(arr, 10))
    println(11,FFF)

    import scala.annotation.tailrec
    def factorial(n: Int): Int = {
      @tailrec def factorialAcc(acc: Int, n: Int): Int = {
        if (n <= 1) acc
        else factorialAcc(n * acc, n - 1)
      }
      factorialAcc(1, n)
    }
    println(factorial(5))
    println(12,FFF)

    import scala.annotation.switch

    val i = 1
    val x = (i: @switch) match {
      case 1 => "One"
      case 2 => "Two"
      case _ => "Other"
    }
    println(x)
    println(13,FFF)

    def getClassAsString(x: Any): String = x match {
      case s: String => s + " is a String"
      case i: Int => "Int"
      case f: Float => "Float"
      case l: List[_] => "List"
      case _ => "Unknown"
    }
    println(getClassAsString(123))
    println(14,FFF)

    val monthNumberToName = Map(
      1 -> "January",
      2  -> "February",
      3  -> "March",
      4  -> "April",
      5  -> "May",
      6  -> "June",
      7  -> "July",
      8  -> "August",
      9  -> "September",
      10 -> "October",
      11 -> "November",
      12 -> "December"
    )
    val monthName = monthNumberToName(4)
    println(monthName) // prints "April"
    println(15,FFF)


    val xx = 5
    xx match {
      case 1 | 3 | 5 | 7 | 9 => println("odd")
      case 2 | 4 | 6 | 8 | 10 => println("even")
    }
    val cmd = "stop"
    cmd match {
      case "start" | "go" => println("starting")
      case "stop" | "quit" | "exit" => println("stopping")
      case _ => println("doing nothing")
    }
    println(16,FFF)

    def isTrue(a: Any) = a match {
      case 0 | "" => false
      case _ => true
    }
    val t = 5
    println(isTrue(t))
    println(17,FFF)

    case class Person(firstName: String)
    case class Dog(name: String)
    def echoWhatYouGaveMe(x: Any): String = x match {
      // constant patterns
      case 0 => "zero"
      case true => "true"
      case "hello" => "you said 'hello'" case Nil => "an empty List"
      // sequence patterns
      case List(0, _, _) => "a three-element list with 0 as the first element"
      case List(1, _*) => "a list beginning with 1, having any number of elements"
      case Vector(1, _*) => "a vector starting with 1, having any number of elements"
      // tuples
      case (a, b) => s"got $a and $b"
      case (a, b, c) => s"got $a, $b, and $c"
      // constructor patterns
      case Person(first) => s"found an Person, first name = $first"
      case Dog("Suka") => "found a dog named Suka"
      // typed patterns
      case s: String => s"you gave me this string: $s"
      case i: Int => s"thanks for the int: $i"
      case f: Float => s"thanks for the float: $f"
      case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
      case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
      case d: Dog => s"dog: ${d.name}"
      case list: List[_] => s"thanks for the List: $list" case m: Map[_, _] => m.toString
      // the default wildcard pattern
      case _ => "Unknown"
    }
    // trigger the constant patterns
    println(echoWhatYouGaveMe(0))
    println(echoWhatYouGaveMe(true))
    println(echoWhatYouGaveMe("hello"))
    println(echoWhatYouGaveMe(Nil))
    // trigger the sequence patterns
    println(echoWhatYouGaveMe(List(0,1,2)))
    println(echoWhatYouGaveMe(List(1,2)))
    println(echoWhatYouGaveMe(List(1,2,3)))
    println(echoWhatYouGaveMe(Vector(1,2,3)))
    // trigger the tuple patterns
    println(echoWhatYouGaveMe((1,2)))
    println(echoWhatYouGaveMe((1,2,3)))
    // trigger the constructor patterns
    // two element tuple
    // three element tuple
    println(echoWhatYouGaveMe(Person("Melissa")))
    println(echoWhatYouGaveMe(Dog("Suka")))
    // trigger the typed patterns
    println(echoWhatYouGaveMe("Hello, world"))
    println(echoWhatYouGaveMe(42))
    println(echoWhatYouGaveMe(42F))
    println(echoWhatYouGaveMe(Array(1,2,3)))
    println(echoWhatYouGaveMe(Array("coffee", "apple pie")))
    println(echoWhatYouGaveMe(Dog("Fido")))
    println(echoWhatYouGaveMe(List("apple", "banana")))
    println(echoWhatYouGaveMe(Map(1->"Al", 2->"Alexander")))
    // trigger the wildcard pattern
    println(echoWhatYouGaveMe("33d"))
    println(18,FFF)

    def toInt(s: String): Option[Int] = {
      try {
        Some(Integer.parseInt(s.trim))
      } catch {
        case e: Exception => None
      }
    }
    toInt("42") match {
      case Some(i) => println(i)
      case None => println("That wasn't an Int.")
    }
    println(19,FFF)

    i match {
      case a if 0 to 9 contains a => println("0-9 range: " + a)
      case b if 10 to 19 contains b => println("10-19 range: " + b)
      case c if 20 to 29 contains c => println("20-29 range: " + c)
      case _ => println("Hmmm...")
    }
    i match {
      case x if x == 1 => println("one, a lonely number")
      case x if (x == 2 || x == 3) => println(x)
      case _ => println("some other value")
    }
//    stock match {
//      case x if (x.symbol == "XYZ" && x.price < 20) => buy(x)
//      case x if (x.symbol == "XYZ" && x.price > 50) => sell(x)
//      case _ => // do nothing
//    }
    println(20,FFF)

    def speak(p: Person) = p match {
      case Person(name) =>
        if (name == "Fred") println("Yubba dubba doo1") else if (name == "Bam Bam") println("Bam bam!")
      case Person(name) if name == "Fred" => println("Yubba dubba doo2")
      case Person(name) if name == "Bam Bam" => println("Bam bam!")
      case _ => println("Watch the Flintstones!")
    }
    def isPerson(x: Any): Boolean = x match {
      case p: Person => true
      case _ => false
    }
    speak(Person("Fred"))
    println(isPerson(Person("Sariel")))
    println(21,FFF)

    def listToString(list: List[String]): String = list match {
      case s :: rest => s + " " + listToString(rest)
      case Nil => ""
    }
    val fruitss = "Apples" :: "Bananas" :: "Oranges" :: Nil
    println(listToString(fruitss))

    def sum(list: List[Int]): Int = list match {
      case Nil => 0
      case n :: rest => n + sum(rest)
    }
    def multiply(list: List[Int]): Int = list match {
      case Nil => 1
      case n :: rest => n * multiply(rest)
    }
    val numss = List(1,2,3,4,5)
    println(sum(numss))
    println(multiply(numss))
    println(22,FFF)

    @throws(classOf[NumberFormatException])
    def toInt2(s: String): Option[Int] =
      try { Some(s.toInt)
      } catch {
        case e: NumberFormatException => throw e
    }
    toInt2("12")
    println(23,FFF)




  }
}

import util.control.Breaks._
object BreakAndContinueDemo extends App {
  println("\n=== BREAK EXAMPLE ===")
  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i > 4)
        break // break out of the for loop
    }
  }
  println("\n=== CONTINUE EXAMPLE ===")
  val searchMe = "peter piper picked a peck of pickled peppers"
  var numPs = 0
  for (i <- 0 until searchMe.length) {
    breakable {
      if (searchMe.charAt(i) != 'p') {
        break // break out of the 'breakable', continue the outside loop
      } else {
        numPs += 1
      }
    }
  }
  println("Found " + numPs + " p's in the string.")
}

object LabeledBreakDemo extends App {
  import scala.util.control._
  val Inner = new Breaks
  val Outer = new Breaks
  Outer.breakable {
    for (i <- 1 to 5) {
      Inner.breakable {
        for (j <- 'a' to 'e') {
          if (i == 1 && j == 'c') Inner.break else println(s"i: $i, j: $j")
          if (i == 2 && j == 'b') Outer.break
        }
      }
    }
  }
}

object Test2 extends App {
  case class Person(firstName: String, lastName: String)
  def matchType(x: Any): String = x match {
    //case x: List(1, _*) => s"$x" // doesn't compile
    case x @List(1, _*) => s"$x" // works; prints the list
    //case Some(_) => "got a Some" // works, but can't access the Some //
    //case Some(x) => s"$x" // works, returns "foo"
    case x @Some(_) => s"$x" // works, returns "Some(foo)"
    case p @Person(first, "Doe") => s"$p" // works, returns "Person(John,Doe)"
  }
  println(matchType(List(1, 2, 3))) // prints "List(1, 2, 3)"
  println(matchType(Some("foo"))) // prints "Some(foo)"
  println(matchType(Person("John", "Doe"))) // prints "Person(John,Doe)"
}

object CaseClassTest extends App {
  trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal
  case object Woodpecker extends Animal

  def determineType(x: Animal): String = x match {
    case Dog(moniker) => "Got a Dog, name = " + moniker
    case _:Cat => "Got a Cat (ignoring the name)"
    case Woodpecker => "That was a Woodpecker"
    case _ => "That was something else"
  }
  println(determineType(new Dog("Rocky")))
  println(determineType(new Cat("Rusty the Cat")))
  println(determineType(Woodpecker))
}

object CopyBytes extends App {
  import java.io._
  var in = None: Option[FileInputStream]
  var out = None: Option[FileOutputStream]
  try {
    in = Some(new FileInputStream("/Users/sariel/Desktop/beautifulsentense"))
    out = Some(new FileOutputStream("/Users/sariel/Desktop/beautifulsentense.copy"))
//    out.foreach { outputStream =>
//      var c = 0
//      while ( {c = inputStream.read;c != -1}) {
//        outputStream.write(c)
//      }
//    }
    var c = 0
    while ({c = in.get.read; c != -1 }) {
      out.get.write(c)
    }
  } catch {
    case e: IOException => e.printStackTrace
  } finally {
    println("entered finally ...")
    if (in.isDefined) in.get.close
    if (out.isDefined) out.get.close
  }
}