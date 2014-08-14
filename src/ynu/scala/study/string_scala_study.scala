package ynu.scala.study

/**
 * Created by sariel on 14-8-14.
 */
object string_scala_study {
  def main(args: Array[String]) {
    val FFF ="========================================================="
    val str = "Hello Scala  ,  this is YS"

    println(str.getClass.getName)
    println(1,FFF)

    str.foreach(println)
    println(2,FFF)

    for(c <- str) println(c)
    println(3,FFF)

    str.getBytes.foreach(println)
    println(4,FFF)

    str.filter(_ != 'l').foreach(println)
    println(5,FFF)

    println(str.drop(2).take(2).capitalize)
    println(6,FFF)

    val s1 = null
    val s2 = null
    println(s1 == s2)
    println(7,FFF)

    val foo =
      """This is
        # a multiline
        #  String""".stripMargin('#')
    println(foo)
    println(8,FFF)

    val speech = """Four score and
                   |seven years ago
                   |our fathers""".stripMargin.replaceAll("\n", " ")
    println(speech)
    println(9,FFF)

    str.split(' ')foreach(println)
    println(10,FFF)

    str.split(',').map(_.trim).foreach(println)
    println(11,FFF)

    str.split("\\s+").foreach(println)
    println(12,FFF)

    val name = "Sariel"
    val age = 23
    val weight = 70.00
    println(s"$name is $age years old, and weights $weight kg!")
    println(13,FFF)

    println(s"Age next year: ${age + 1}")
    println(s"You are 23 years old ?  ${age == 23}")
    println(14,FFF)

    case class Student(name : String, age : Int, weight : Double ){
      override def toString:String = "%s , age %d, weights %f".format(name , age, weight)
    }
    val YS = Student(name, age, weight)
    println(s"${YS.name} is ${YS.age} years old, and weights ${YS.weight} kg!")
    println(15,FFF)

    println(s"Y\nS")
    println(raw"Y\nS")
    println(16,FFF)

    println("%s is %d years old!".format(name,age))
    println(17,FFF)

    println(YS.toString)
    println(18,FFF)

    println(str.map(_.toUpper))
    println(19,FFF)

    println(for(c <- str)yield c.toUpper)
    println(20,FFF)

    val result = for {
      c <- str
      if c != 'l'
    }yield c.toUpper
    println(result)
    println(21,FFF)

    val numPattern = "[0-9]+".r
    val address = "123 Main Street Suite 101"
    val address2 = "Just for test"
    val match1 = numPattern.findAllIn(address)
    val result2 = numPattern.findFirstIn(address2).getOrElse("no match")
    match1.foreach(println)
    println(result2)

    val result3 = address.replaceAll("[0-9]","x")
    val address3 = numPattern.replaceAllIn(address,"x")
    println(result3)
    println(address3)

    val regex = "H".r
    val result4 = regex.replaceFirstIn("Hello world", "J")
    println(result4)
    println(22,FFF)

    val pattern = "([0-9]+) ([A-Za-z]+)".r
    val pattern(count, fruit) = "100 Bananas"
    println(count,fruit)
    println(23,FFF)

    //    val textUserTyped = List("movies near 80301",
    //                      "movies 80301",
    //                      "80301 movies",
    //                      "movie: 80301",
    //                      "movies: 80301",
    //                      "movies near boulder, co",
    //                      "movies near boulder, colorado")
    //    // match "movies 80301"
    //    val MoviesZipRE = "movies (\\d{5})".r
    //    // match "movies near boulder, co"
    //    val MoviesNearCityStateRE = "movies near ([a-z]+), ([a-z]{2})".r
    //    textUserTyped match {
    //      case MoviesZipRE(zip) => getSearchResults(zip)
    //      case MoviesNearCityStateRE(city, state) => getSearchResults(city, state)
    //      case _ => println("did not match a regex")
    //    }
    //    println(24,FFF)

    println(str(0))
    println(24,FFF)

    class StringImprovements(val s: String) {
      def increment = s.map(c => (c + 1).toChar)
      def decrement = s.map(c => (c - 1).toChar)
      def hideAll = s.replaceAll(".", "*")
      def plusOne = s.toInt + 1
      def asBoolean = s match {
        case "0" | "zero" | "" | " " => false
        case _ => true
      }
    }
    implicit def stringToString(s: String) = new StringImprovements(s)
    println("HAL".increment)
    println("4".plusOne)
    println("0".asBoolean)
    println(25,FFF)


  }
}
