package scala.essential

/**
  * Created by kkosittaruk on 09/09/2017.
  */
object ScalaEssentialMain {

  def main(args: Array[String]): Unit = {
    val joe = new Person("Joe", 99)
    val joe2 = new Person("Joe", 99)
    val champ = new Person("Champ", 88)
    val joe3 = new Person2("Joe", 99)
    val empty = new Person3

    println(empty.hashCode())

    joe3.equals(joe2)

    joe3.hashCode()

    println(joe.equals(champ))
    println(joe.equals(joe2))

    println(joe.hashCode())
    println(joe2.hashCode())

    println(champ.hashCode())

    println(joe.toString +", "+joe2.toString+","+champ.toString)





  }
}


case class Person(name: String, age: Int) {
  def sayHello = s"Hello, My Name is $name"
}

class Person2(name: String, age: Int)


case class Person3()



