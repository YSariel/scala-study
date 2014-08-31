package ynu.scala.study

/**
 * Created by sariel on 14-8-31.
 */
object list_arr_map_set_scala_study {
  def main(args: Array[String]) {
    //list create
    val list1 = 1 :: 2 :: 3 :: Nil
    val list2 = List(1, 2, 3)
    val x1 = List(1, 2.0, 33D, 4000L) //double
    val x2 = List[Number](1, 2.0, 33D, 4000L)
    val x3 = List.range(1, 10)
    val x4 = List.range(0, 10, 2) //x: List[Int] = List(0, 2, 4, 6, 8)
    val x5 = List.fill(3)("foo")  //x: List[String] = List(foo, foo, foo)
    val x6 = List.tabulate(5)(n => n * n) //x: List[Int] = List(0, 1, 4, 9, 16)
    val x7 = collection.mutable.ListBuffer(1, 2, 3).toList
    "foo".toList  //List[Char] = List(f, o, o)

    //Adding Elements to a List
    val x = List(2) //x: List[Int] = List(2)
    val y = 1 :: x  //y: List[Int] = List(1, 2)
    val z = 0 :: y  //z: List[Int] = List(0, 1, 2)

    val list3 = 3 :: Nil  //List[Int] = List(3)
    val list4 = 2 :: list3  //List[Int] = List(2, 3)
    val list5 = 1 :: list4  //List[Int] = List(1, 2, 3)

    val a = List(1) //List[Int] = List(1)
    val b = 0 +: a  //List[Int] = List(0, 1)
    val c = b :+ 2  //List[Int] = List(1, 2)

    import scala.collection.mutable.ListBuffer
    var fruits = new ListBuffer[String]()
    // add one element at a time to the ListBuffer
    fruits += "Apple"
    fruits += "Banana"
    fruits += "Orange"
    // add multiple elements
    fruits += ("Strawberry", "Kiwi", "Pineapple")
    // remove one element
    fruits -= "Apple"
    // remove multiple elements
    fruits -= ("Banana", "Orange")
    // remove multiple elements specified by another sequence
    fruits --= Seq("Kiwi", "Pineapple")
    // convert the ListBuffer to a List when you need to
    val fruitsList = fruits.toList

    //Deleting Elements from a List (or ListBuffer)
    val originalList = List(5, 1, 4, 3, 2)
    val newList = originalList.filter(_ > 2)  //newList: List[Int] = List(5, 4, 3)
    var o = List(5, 1, 4, 3, 2)
    o = o.filter(_ > 2) //x: List[Int] = List(5, 4, 3)

    import scala.collection.mutable.ListBuffer
    val x8 = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)
    x8 -= 5 //x.type = ListBuffer(1, 2, 3, 4, 6, 7, 8, 9)
    x8 -= (2, 3)  //x.type = ListBuffer(1, 4, 6, 7, 8, 9)
    x8.remove(0)  //res2: Int = 1   ListBuffer(4, 6, 7, 8, 9)
    x8.remove(1, 3) //ListBuffer(4, 9)

    val x9 = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)
    x9 --= Seq(1,2,3) //x.type = ListBuffer(4, 5, 6, 7, 8, 9)

    //Merging (Concatenating) Lists
    val m = List(1,2,3)
    val n = List(4,5,6)
    val l1 = m ++ n
    val l2 = m ::: n
    val l3 = List.concat(m, n)  //l1 = l2 = l3 = List(1, 2, 3, 4, 5, 6)

    //Using Stream, a Lazy Version of a List
    val stream1 = 1 #:: 2 #:: 3 #:: Stream.empty //scala.collection.immutable.Stream[Int] = Stream(1, ?)
    val stream2 = (1 to 100000000).toStream //scala.collection.immutable.Stream[Int] = Stream(1, ?)
    stream1.head  //int = 1
    stream1.tail //scala.collection.immutable.Stream[Int] = Stream(2, ?)
    stream1.take(3)  //scala.collection.immutable.Stream[Int] = Stream(1, ?)
    stream1.filter(_ < 200) //scala.collection.immutable.Stream[Int] = Stream(1, ?)
    stream1.filter(_ > 200) //scala.collection.immutable.Stream[Int] = Stream(201, ?)
    stream1.map { _ * 2 } //scala.collection.immutable.Stream[Int] = Stream(2, ?)

    stream(0) // returns 1
    stream(1) // returns 2 // ...
    stream(10) // returns 11

    //arr create
    val a = Array(1,2,3)
    val fruits = Array("Apple", "Banana", "Orange")
    val x = Array(1, 2.0, 33D, 400L)
    val x = Array[Number](1, 2.0, 33D, 400L)
    // create an array with an initial size
    val fruits = new Array[String](3)
    // somewhere later in the code ...
    fruits(0) = "Apple"
    fruits(1) = "Banana"
    fruits(2) = "Orange"

    // initialize with elements
    val characters = collection.mutable.ArrayBuffer("Ben", "Jerry")
    // add one element
    characters += "Dale"
    // add two or more elements (method has a varargs parameter)
    characters += ("Gordon", "Harry")
    // add multiple elements with any TraversableOnce type
    characters ++= Seq("Andy", "Big Ed")
    // append one or more elements (uses a varargs parameter)
    characters.append("Laura", "Lucy")

    //Deleting Array and ArrayBuffer Elements
    import scala.collection.mutable.ArrayBuffer
    val x = ArrayBuffer('a', 'b', 'c', 'd', 'e')
    // remove one element
    x -= 'a'
    // remove multiple elements (methods defines a varargs param)
    x -= ('b', 'c')
    val x = ArrayBuffer('a', 'b', 'c', 'd', 'e')
    x --= Seq('a', 'b')
    x --= Array('c')
    x --= Set('d')

    var a = ArrayBuffer(1,2,3,4,5)
    a.clear

    val a = Array("apple", "banana", "cherry")
    a(0) = ""
    a(1) = null
    //Array[String] = Array("", null, cherry)

    val a = Array("apple", "banana", "cherry")
    val b = a.filter(! _.contains("apple")) //Array[String] = Array(banana, cherry)
    a = a.take(2) //Array[String] = Array(apple, banana)

    // Sorting Arrays
    val fruits = Array("cherry", "apple", "banana")
    scala.util.Sorting.quickSort(fruits)  //Array(apple, banana, cherry)

    //Creating Multidimensional Arrays
    val rows = 2
    val cols = 3
    val a = Array.ofDim[String](rows, cols)
    a(0)(0) = "a"
    a(0)(1) = "b"
    a(0)(2) = "c"
    a(1)(0) = "d"
    a(1)(1) = "e"
    a(1)(2) = "f"

    for {
      i <- 0 until rows
      j <- 0 until cols
    } println(s"($i)($j) = ${a(i)(j)}")

    val x, y, z = 10
    val a = Array.ofDim[Int](x,y,z)
    for {
      i <- 0 until x
      j <- 0 until y
      k <- 0 until z
    } println(s"($i)($j)($k) = ${a(i)(j)(k)}")

    val a = Array( Array("a", "b", "c"), Array("d", "e", "f") ) //Array[Array[String]] = Array(Array(a, b, c), Array(d, e, f))
    a(0)  //Array[String] = Array(a, b, c)
    a(0)(0) //String = a
    val a = Array(Array("a", "b", "c"), Array("d", "e"))  //Array[Array[String]] = Array(Array(a, b, c), Array(d, e))
    var arr = Array(Array("a", "b", "c"))
    arr ++= Array(Array("d", "e"))
    arr

    //map create
    

  }
}
