package ynu.scala.study

/**
 * Created by sariel on 14-8-18.
 */
object object_scala_study {
  //Putting Common Code in Package Objects
  type Throwable = java.lang.Throwable
  type Exception = java.lang.Exception
  type Error = java.lang.Error
  type RuntimeException = java.lang.RuntimeException
  type NullPointerException = java.lang.NullPointerException
  type ClassCastException = java.lang.ClassCastException


}

class Foo {
  private val secret = 2
}
object Foo {
  // access the private class field 'secret'
  def double(foo: Foo) = foo.secret * 2
}
object Driver extends App {
  val f = new Foo
  println(Foo.double(f)) // prints 4
}

//Creating Static Members with Companion Objects
// Pizza class
class Pizza (var crustType: String) {
  override def toString = "Crust type is " + crustType
}
// companion object
object Pizza {
  val CRUST_TYPE_THIN = "thin"
  val CRUST_TYPE_THICK = "thick"
  def getFoo = "Foo"
}
object Driver2 extends App{
  println(Pizza.CRUST_TYPE_THIN)
  println(Pizza.getFoo)
  var p = new Pizza(Pizza.CRUST_TYPE_THICK)
  println(p)
}
//Creating Object Instances Without Using the new Keyword

//class Person {
//  var name = ""
//  var age = 0
//}
class Person(var name: String, var age: Int)
object Person {
  def apply() = new Person("<no name>", 0)
  def apply(name: String) = new Person(name, 0)
  def apply(name: String, age: Int) = new Person(name,age)
}
object Test extends App {
  val a = Person()
  val b = Person("Al")
  val c = Person("William Shatner", 82)
  println(a.name,a.age)
  println(b.name,b.age)
  println(c.name,c.age)
  // test the mutator methods
  a.name = "Leonard Nimoy"
  a.age = 82
  println(a.name,a.age)
}

//Factory Method in Scala with apply
trait Animal {
  def speak
}
object Animal {
  private class Dog extends Animal {
    override def speak { println("woof") }
  }
  private class Cat extends Animal {
    override def speak { println("meow") }
  }
  // the factory method
  def apply(s: String): Animal = {
    if (s == "dog") new Dog else new Cat
  }
  def getAnimal(s: String): Animal = {
    if (s == "dog") return new Dog else return new Cat
  }
}
object Test2 extends App{
  val cat = Animal("cat") // returns a Cat
  val dog = Animal("dog") // returns a Dog
  val cat2 = Animal.getAnimal("cat") // returns a Cat
  val dog2 = Animal.getAnimal("dog") // returns a Dog
}