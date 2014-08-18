package ynu.scala.study

/**
 * Created by sariel on 14-8-17.
 */
object class_scala_study {
  def main(args: Array[String]) {
    val FFF ="========================================================="

    val p = new Person("Dark","Sariel")
    println(p)
    println(1,FFF)

    val p1 = new Pizza(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
    val p2 = new Pizza(Pizza.DEFAULT_CRUST_SIZE)
    val p3 = new Pizza(Pizza.DEFAULT_CRUST_TYPE)
    val p4 = new Pizza
    println(p1,p2,p3,p4)
    println(2,FFF)

    //Providing Default Values for Constructor Parameters
    class Socket (val timeout: Int = 10000)
    val s1 = new Socket
    val s2 = new Socket(5000)
    println(s1.timeout)
    println(s2.timeout)
    println(3,FFF)

    class Person2(private var _name: String) {
      def name = _name // accessor
      def name_=(aName: String) { _name = aName } // mutator
    }
    val pn = new Person2("Sariel")
    pn.name = "Dark"
    println(pn.name)
    println(4,FFF)

    case class Employee(name: String, loc: String, role: String)
    val fred = Employee("Fred", "Anchorage", "Salesman")
    val joe = fred.copy(name="Joe", role="Mechanic")
    println(fred.toString)
    println(joe.toString)
    println(5,FFF)

    }
}

class Person(var firstName: String, var lastName: String) {
  println("the constructor begins")
  // some class fields
  private val HOME = System.getProperty("user.home")
  var age = 0
  // some methods
  override def toString = s"$firstName $lastName is $age years old"
  def printHome { println(s"HOME = $HOME") }
  def printFullName { println(this) } // uses toString
  printHome
  printFullName
  println("still in the constructor")
}

// primary constructor
class Pizza (var crustSize: Int, var crustType: String) {
  // one-arg auxiliary constructor
  def this(crustSize: Int) {
    this(crustSize, Pizza.DEFAULT_CRUST_TYPE)
  }
  // one-arg auxiliary constructor
  def this(crustType: String) {
    this(Pizza.DEFAULT_CRUST_SIZE, crustType)
  }
  // zero-arg auxiliary constructor
  def this() {
    this(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  }
  override def toString = s"A $crustSize inch pizza with a $crustType crust"
}
object Pizza {
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "THIN"
}

object CaseClassTest extends App {
  // the case class
  case class Person (var name: String, var age: Int)
  // the companion object
  object Person {
    def apply() = new Person("<no name>", 0)
    def apply(name: String) = new Person(name, 0)
  }

  val a = Person() // corresponds to apply()
  val b = Person("Pam") // corresponds to apply(name: String)
  val c = Person("William Shatner", 82)
  println(a)
  println(b)
  println(c)
  // verify the setter methods work
  a.name = "Leonard Nimoy"
  a.age = 82
  println(a)
}
//Defining a Private Primary Constructor
object SingletonTest extends App {

  class Brain private {
    override def toString = "This is the brain."
  }
  object Brain {
    val brain = new Brain
    def getInstance = brain
  }

  // this won't compile
  // val brain = new Brain
  // this works
  val brain = Brain.getInstance
  println(brain)

}

object Test extends App {
  class Foo {
    // set 'text' equal to the result of the block of code
    val text = {
      var lines = ""
      try {
        lines = io.Source.fromFile("/etc/passwd").getLines.mkString
      } catch {
        case e: Exception => lines = "Error happened"
      }
      lines
    }
    println(text)
  }
  val f = new Foo
}

object Driver extends App {
  class Stock {
    // a private field can be seen by any Stock instance
    private var price: Double = _
    def setPrice(p: Double) { price = p }
    def isHigher(that: Stock): Boolean = this.price > that.price
  }
  val s1 = new Stock
  s1.setPrice(20)
  val s2 = new Stock
  s2.setPrice(100)
  println(s2.isHigher(s1))
}

object new_person extends App{

  case class Person(var username: String, var password: String) {
    var age = 0
    var firstName = ""
    var lastName = ""
    var address = None: Option[Address]
  }
  case class Address(city: String, state: String, zip: String)

  class Employee(username:String , password:String ,val add:Address) extends Person(username,password){
    override def toString = s"$username , $password ,$add"
  }
  val teresa = new Employee("Teresa", "123456",  Address("Louisville", "KY", "650500"))
  val p = Person("alvinalexander", "secret")
  p.address = Some(Address("Talkeetna", "AK", "99676"))
  println(teresa.toString)
  p.address.foreach { a =>
    println(a.city)
    println(a.state)
    println(a.zip)
  }

}

object pet extends App{
  abstract class Pet (name: String) {
    val greeting: String
    var age: Int
    def sayHello { println(greeting) }
    override def toString = s"I say $greeting, and I'm $age"
  }
  class Dog (name: String) extends Pet (name) {
    val greeting = "Woof"
    var age = 2
  }
  class Cat (name: String) extends Pet (name) {
    val greeting = "Meow"
    var age = 5
  }
  val dog = new Dog("Fido")
  val cat = new Cat("Morris")
  dog.sayHello
  cat.sayHello
  println(dog)
  println(cat)
  cat.age = 10
  println(cat)
}


object Dog extends App {
  trait Animal {
    val greeting: Option[String]
    var age: Option[Int] = None
    override def toString = s"I say $greeting, and I'm $age years old."
  }
  class Dog extends Animal {
    val greeting = Some("Woof")
    age = Some(2)
  }
  val d = new Dog
  println(d)
}

object eq extends App{
  class Person (name: String, age: Int) {
    def canEqual(a: Any) = a.isInstanceOf[Person]
    override def equals(that: Any): Boolean = that match {
      case that: Person => that.canEqual(this) && this.hashCode == that.hashCode
      case _ => false
    }
    override def hashCode:Int = {
      val prime = 31
      var result = 1
      result = prime * result + age
      result = prime * result + (if (name == null) 0 else name.hashCode)
      return result
    }
  }
  val nimoy = new Person("Leonard Nimoy", 82)
  val nimoy2 = new Person("Leonard Nimoy", 82)
  val shatner = new Person("William Shatner", 82)
  val ed = new Person("Ed Chigliak", 20)
  // all tests pass
  println("nimoy == nimoy",nimoy == nimoy)
  println("nimoy == nimoy2",nimoy == nimoy2)
  println("nimoy2 == nimoy",nimoy2 == nimoy)
  println("nimoy != shatner",nimoy != shatner)
  println("shatner != nimoy",shatner != nimoy)
  println("nimoy != null",nimoy != null)
  println("nimoy != String",nimoy != "Leonard Nimoy")
  println("nimoy != ed",nimoy != ed)

  class Employee(name: String, age: Int, var role: String) extends Person(name, age)
  {
    override def canEqual(a: Any) = a.isInstanceOf[Employee]
    override def equals(that: Any): Boolean = that match {
      case that: Employee =>
        that.canEqual(this) && this.hashCode == that.hashCode
      case _ => false
    }
    override def hashCode:Int = {
      val ourHash = if (role == null) 0 else role.hashCode
      super.hashCode + ourHash
    }
  }
  // these first two instance should be equal
  val eNimoy1 = new Employee("Leonard Nimoy", 82, "Actor")
  val eNimoy2 = new Employee("Leonard Nimoy", 82, "Actor")
  val pNimoy = new Person("Leonard Nimoy", 82)
  val eShatner = new Employee("William Shatner", 82, "Actor")
  println("eNimoy1 == eNimoy1",eNimoy1 == eNimoy1)
  println("eNimoy1 == eNimoy2",eNimoy1 == eNimoy2)
  println("eNimoy2 == eNimoy1",eNimoy2 == eNimoy1)
  println("eNimoy != pNimoy",eNimoy1 != pNimoy)
  println("pNimoy != eNimoy",pNimoy != eNimoy1)
}

object inner_class extends App{
  class PandorasBox {
    case class Thing (name: String)
    var things = new collection.mutable.ArrayBuffer[Thing]()
    things += Thing("Evil Thing #1")
    things += Thing("Evil Thing #2")
    def addThing(name: String) { things += new Thing(name) }
  }
  val p = new PandorasBox
  p.things.foreach(println)
  p.addThing("Evil Thing #3")
  p.addThing("Evil Thing #4")
  p.things.foreach(println)

}

object ClassInObject extends App {
  // inner classes are bound to the object
  class OuterClass {
    class InnerClass {
      var x = 1
    }
  }
  val oc1 = new OuterClass
  val oc2 = new OuterClass
  val ic1 = new oc1.InnerClass
  val ic2 = new oc2.InnerClass
  ic1.x = 10
  ic2.x = 20
  println(s"ic1.x = ${ic1.x}")
  println(s"ic2.x = ${ic2.x}")
}
