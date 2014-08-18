package ynu.scala.study

/**
 * Created by sariel on 14-8-18.
 */
object package_scala_study {
  def main(args: Array[String]) {
    //Importing One or More Members
    import java.io.File
    import java.io.IOException
    import java.io.FileNotFoundException

    import java.io.{File, IOException, FileNotFoundException}

    import java.io._

    //Renaming Members on Import
    import java.util.{ArrayList => JavaList}
    import java.util.{Date => JDate, HashMap => JHashMap}
    import java.util.{HashMap => JavaHashMap}
    import scala.collection.mutable.{Map => ScalaMutableMap}
    import java.util.{HashMap => JavaHashMap}
    import scala.collection.mutable.Map

    //Hiding a Class During the Import Process
    import java.util.{Random => _, _} //exerything in util import execpt Random
    import java.util.{List => _, Map => _, Set => _, _}

  }
}
// a package containing a class named Foo
package orderentry {
  class Foo { override def toString = "I am orderentry.Foo" }
}
// one package nested inside the other
package customers {
  class Foo { override def toString = "I am customers.Foo"  }
  package database {
    // this Foo is different than customers.Foo or orderentry.Foo
    class Foo { override def toString = "I am customers.database.Foo" }
  }
}
object PackageTests extends App {
  println(new orderentry.Foo)
  println(new customers.Foo)
  println(new customers.database.Foo)
}
