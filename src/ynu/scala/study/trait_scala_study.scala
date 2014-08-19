package ynu.scala.study

/**
 * Created by sariel on 14-8-19.
 */
object trait_scala_study {

}

//Using a Trait as an Interface
abstract class Animal {
  def speak
}
trait WaggingTail {
  def startTail { println("tail started") }
  def stopTail { println("tail stopped") }
}
trait FourLeggedAnimal {
  def walk
  def run
}
class Dog extends Animal with WaggingTail with FourLeggedAnimal { // implementation code here ...
  def speak { println("Dog says 'woof'") }
  def walk { println("Dog is walking") }
  def run { println("Dog is running") }
}
//Using Abstract and Concrete Fields in Traits
trait PizzaTrait {
  var numToppings: Int // abstract
  var size = 14 // concrete
  val maxNumToppings : Int // concrete
}
class Pizza extends PizzaTrait {
  var numToppings = 0 // 'override' not needed
  size = 16 // 'var' and 'override' not needed
  override val maxNumToppings = 10 // 'override' is required cause val
}

//Using a Trait Like an Abstract Class

trait Pet {
  def speak { println("Yo") } // concrete implementation def comeToMaster // abstract method
}
class Doge extends Pet {
  // don't need to implement 'speak' if you don't need to
  def comeToMaster { ("I'm coming!") }
}
class Cat extends Pet {
  // override the speak method
  override def speak { ("meow") }
  def comeToMaster { ("That's not gonna happen.") }
}
abstract class FlyingPet extends Pet {
  def fly { ("I'm flying!") }
}

//  Using Traits as Simple Mixins
object test_pet extends App{
  trait Tail {
    def wagTail { println("tail is wagging") }
    def stopTail { println("tail is stopped") }
  }
  abstract class Pet (var name: String) {
    def speak // abstract
    def ownerIsHome { println("excited") }
    def jumpForJoy { println("jumping for joy") }
  }
  class Dog (name: String) extends Pet (name) with Tail {
    def speak { println("woof") }
    override def ownerIsHome {
      wagTail
      speak
    }
  }
  val zeus = new Dog("Zeus")
  zeus.ownerIsHome
  zeus.jumpForJoy
}
//Ensuring a Trait Can Only Be Added to a Type That Has a Specific Method
//You only want to allow a trait to be mixed into a type (class, abstract class, or trait) that has a method with a given signature.
trait WarpCore {
  this: {
    def ejectWarpCore(password: String): Boolean
    def startWarpCore: Unit
  } =>
}
class Starship
class Enterprise extends Starship with WarpCore {
  def ejectWarpCore(password: String): Boolean = {
    if (password == "password") {
      println("core ejected")
      true
    } else false
  }
  def startWarpCore { println("core started") }
}

//Adding a Trait to an Object Instance
class DavidBanner
trait Angry {
  println("You won't like me ...")
}
object Test extends App {
  val hulk = new DavidBanner with Angry
}


