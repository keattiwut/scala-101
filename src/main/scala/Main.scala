import scala.concurrent.duration.DurationConversions.fromNowConvert.R

/**
  * Created by kkosittaruk on 05/09/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val nums = (1 to 100).toList
    addNumbers(nums)
    val x = new Foo(10, "Bar")
    x.func()
    MySingleton.func()
    Foo.makeFoo(99)

    (1 to 5).map(_*2).map(println)
    val ๆ = (1 to 5).map(_*2).reduceLeft(_+_)
    println(ๆ)

    //Tuple
    var (a,b,c) = (1,2,3)

    var xs = List(1,2,3)
    println(xs(2))

    //for
    for (x <- xs if x%2 == 0) yield x * 10

  }

  def addNumbers(numbers: List[_ >: Int]): Unit = {
    numbers.foreach(println(_))
  }
}

class Foo(value: Int, val message: String) {
  def func() = println("My value is " + value + " and my message is \"" + message + "\"")
}

object Foo {
  def makeFoo(num: Int): Foo = {
    val foo = new Foo(num, "test")
    println("Made a Foo!")
    foo.func()
    foo
  }
}

object MySingleton {
  def func(): Unit = println("A function in a singleton!")
}


class Customer(name: String, address: String)

object Customer {
  def apply(name: String, address: String) = new Customer(name, address)


  def main(args: Array[String]): Unit = {
    Customer.apply("Keattiwut", "1 London Road")
    Customer("Rob Johnson", "99 Los Angelice ")
  }
}

object ArrayExample {
  val numerals = Array("I", "II", "III", "IV", "V", "VI", "VII")

  def main(args: Array[String]): Unit = {
    for (i <- 0 to numerals.length - 1) {
      println(i + " = " + numerals.apply(i))
    }
  }
}