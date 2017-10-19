sealed abstract class Result

case object Win extends Result

case object Draw extends Result

case object Lose extends Result

def resultMessage(result: Result) = result match {
  case Win => "a winner is your"
  case Draw => "so close"
  case Lose => "game over"
}

resultMessage(Lose)


sealed trait MyBoolean {
  def not: MyBoolean

  def and(b: MyBoolean): MyBoolean
}

case object MyTrue extends MyBoolean {
  override def not: MyBoolean = MyFalse

  override def and(b: MyBoolean): MyBoolean = b
}

case object MyFalse extends MyBoolean {
  override def not: MyBoolean = MyTrue

  override def and(b: MyBoolean): MyBoolean = b
}


sealed abstract class Currency(code: String) {
  def getCode = code
}

case object USD extends Currency("USD")

case class Other(code: String) extends Currency(code.toUpperCase)


sealed trait BinaryTree

case class Branch(left: BinaryTree, right: BinaryTree) extends BinaryTree

case class Leaf(value: Int) extends BinaryTree


//Warming: Traffic Light
sealed abstract class TrafficLight

case object Red extends TrafficLight

case object Yellow extends TrafficLight

case object Green extends TrafficLight


//Warmming: HttpMethod
sealed abstract class HttpMethod(httpMethod: String)

case object Get extends HttpMethod("GET")

case object Post extends HttpMethod("POST")

case object Put extends HttpMethod("PUT")

case object Delete extends HttpMethod("DELETE")

case object Patch extends HttpMethod("PATCH")

case class OtherMethod(httpMethod: String) extends HttpMethod(httpMethod)

//Optional Integer
sealed trait Optional

case class Some(value: Int) extends Optional

case object None extends Optional


//Domain Model: Pet
sealed trait Pet

case class Fish(name: String) extends Pet

case class Dog(name: String, breed: String) extends Pet

case class Cat(name: String, noOfCaught: Int) extends Pet {
  def meet(consumer: Pet) = consumer match {
    case _: Fish => Cat("cat meet fish", noOfCaught + 1)
    case _: Dog => Cat("cat meet dog", 0)
    case _: Cat => this
  }
}

//Domain Model: Shapes
sealed trait Shapes {
  def circumference = Double

  def area = Double
}

class Circle(diameter: Double, radius: Double) extends Shapes {
  override def circumference: Double = math.pow(2, math.Pi) * radius

  override def area: Double = math.Pi * math.pow(radius, 2)
}

class Triangle(a: Double, b: Double, c: Double) extends Shapes {
  override def circumference: Double = a + b + c

  override def area: Double =
    math.sqrt(s * (s - a) * (s - b) * (s * c))

  def determine = (a == b, b == c, c == a) match {
    case (true, true, true) => "Equilateral"
    case (true, true, false) => "Isosceles"
    case (true, false, true) => "Isosceles"
    case (false, true, true) => "Isosceles"
    case (false, false, false) => "Scalene"
  }

  private def s: Double = circumference / 2
}

class Rectangle(width: Double, height: Double) extends Shapes {
  override def circumference: Double = 2 * (height * width)

  override def area: Double = width * height
}


//Extra Hard Challenge: Poker Game

case class Rank(value: Int)
case object Ace extends Rank(14)
case object King extends Rank(13)
case object Queen extends Rank(12)
case object Jack extends Rank(11)
case object Ten extends Rank(10)
case object Nine extends Rank(9)
case object Eight extends Rank(8)
case object Seven extends Rank(7)
case object Six extends Rank(6)
case object Five extends Rank(5)
case object Four extends Rank(4)
case object Three extends Rank(3)
case object Two extends Rank(2)

sealed abstract class Suit
case object Club extends Suit
case object Diamonds extends Suit
case object Hearts extends Suit
case object Spades extends Suit

case class Card(rank: Rank, suit: Suit) {
}

object Hand {

  def findHihgestRank(cards: List[Card]) = cards.maxBy(_.rank.value)

}


def main(args: Array[String]): Unit = {
  val cards = List(
    new Card(Ace, Hearts),
    new Card(Queen, Spades),
    new Card(Three, Hearts),
    new Card(Ten, Club),
    new Card(Jack, Hearts))

  Hand.findHihgestRank(cards)
}











