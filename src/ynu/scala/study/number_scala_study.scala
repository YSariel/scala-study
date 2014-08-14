package ynu.scala.study

/**
 * Created by sariel on 14-8-14.
 */
object number_scala_study {

  def main(args: Array[String]) {
    val FFF ="========================================================="


    println(Int.MaxValue)
    println(Int.MinValue)
    println(1,FFF)

    println("2".toFloat)
    println(BigInt("1"))
    println(BigDecimal("3.1415926"))
    println(2,FFF)

    println(Integer.parseInt("1", 2))
    println(Integer.parseInt("10", 2))
    println(Integer.parseInt("100", 2))
    println(Integer.parseInt("1", 8))
    println(Integer.parseInt("10", 8))
    println(3,FFF)

    implicit class StringToInt(s: String) {
      def toInt(radix: Int) = Integer.parseInt(s, radix)
    }
    println("1".toInt(2))
    println("100".toInt(8))
    println(3,FFF)

    def toInt(s: String):Option[Int] = {
      try {
        Some(s.toInt(10))
      } catch {
      case e: NumberFormatException => None }
    }
    println(toInt("1").getOrElse(0))
    println(toInt("a").getOrElse(0))
    val result = toInt("1024") match {
      case Some(x) => x
      case None => 0 // however you want to handle this
    }
    println(result)
    println(4,FFF)

    val a = 1000L
    println(a.isValidByte)
    println(a.isValidShort)
    println(5,FFF)

    val a1 = 1
    val a2 = 1d
    val a3 = 1f
    val a4 = 1000L
    val a5 = 0: Byte
    val a6 = 0: Int
    val a7 = 0: Short
    val a8 = 0: Float
    val a9 = 0: Double
    val a10 = 0x20
    val a11 = 0x20L
    println(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11)
    println(6,FFF)

    def ~=(x: Double, y: Double, precision: Double) = {
      if ((x - y).abs < precision) true else false
    }
    val b = 0.3
    val c = 0.1 + 0.2
    println(b == c)
    println(~=(c, b, 0.0001))
    println(~=(b, c, 0.0001))
    println(7,FFF)

    println(Double.PositiveInfinity)
    println(1.7976931348623157E308 > Double.PositiveInfinity)
    println(8,FFF)

    val r = scala.util.Random
    println(r.nextInt)
    println(r.nextInt(100))
    println(r.nextFloat)
    println(r.nextDouble)
    println(r.nextPrintableChar)
    // create a random length range
    val range = 0 to r.nextInt(10)
    println(range)
    println(for (i <- 0 to r.nextInt(10)) yield i * 2)
    println(for (i <- 0 to r.nextInt(10)) yield (i * r.nextFloat))
    println(for (i <- 0 to r.nextInt(10)) yield r.nextPrintableChar)
    println(for (i <- 1 to 5) yield r.nextInt(100))
    println(9,FFF)

    val r0 = 1 to 10
    println(r0)
    val r1 = 1 to 10 by 2
    println(r1)
    val r2 = 1 to 10 by 3
    println(r2)
    for (i <- 1 to 5) println(i)
    for (i <- 1 until 5) println(i)
    println(10,FFF)

    val x0 = 1 to 10 toArray
    val x1 = 1 to 10 toList
    val x2 = (1 to 10).toList
    val x3 = (1 to 10).toArray
    println(x0,x1,x2,x3)
    println(11,FFF)

    val pi = scala.math.Pi
    println(f"$pi%1.8f")
    println(f"$pi%06.4f")
    println("%06.2f".format(pi))
    println(12,FFF)

    val formatter0 = java.text.NumberFormat.getIntegerInstance
    println(formatter0.format(10000))
    println(formatter0.format(1000000))
    val locale = new java.util.Locale("de", "DE")
    println(locale)
    val formatter1 = java.text.NumberFormat.getIntegerInstance(locale)
    println(formatter1.format(1000000))
    val formatter2 = java.text.NumberFormat.getInstance
    println(formatter2.format(10000.33))
    val formatter3 = java.text.NumberFormat.getCurrencyInstance
    println(formatter3.format(123.456789))
    println(formatter3.format(1234.56789))
    println(formatter3.format(12345.6789))
    println(formatter3.format(123456.789))
    import java.util.{Currency, Locale}
    val de = Currency.getInstance(new Locale("de", "DE"))
    val formatter4 = java.text.NumberFormat.getCurrencyInstance
    formatter4.setCurrency(de)
    println(formatter4.format(123456.789))
    println(13,FFF)

  }



}
