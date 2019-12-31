import scala.collection.mutable

object ObjectEquality extends App {

  var earth1: Planet = new Planet("Earth", 5)
  var earth2 = new Planet("Earth", 5)
  var mars: Planet = new Planet("Mars", 10)


  println("Comparing earth1 and mars")
  println(earth1 == mars)

  println(earth1 equals mars)

  println(earth1 eq mars)

  println("Comparing earth1 and earth2")

  println(earth2 == earth1)

  println(earth2 equals earth1)

  println(earth2 eq earth1)

  println("When to use == vs equals")


  val a4 = null
  val a5 = "hello"

  println(a4 == a5)

  var map = mutable.HashMap[Planet, String]()

  map += (earth1 -> "One")
  map += (earth2 -> "One")

  print(s"map size ${map.size}")

}

class Planet(var name: String, var weightInKgs: Double) {

  val r = scala.util.Random

  def canEqual(other: Any): Boolean = other.isInstanceOf[Planet]

  override def equals(other: Any): Boolean = other match {
    case that: Planet =>
      (that canEqual this) &&
        name == that.name && //Try commenting this
        weightInKgs == that.weightInKgs
    case _ => false
  }

  override def hashCode(): Int = {
    //  val state = Seq(name, age)
    // state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)

    r.nextInt //This is wrong

  }

  //Right implementation of point class. Basically is symmetrical, reflective and transitive
  class Point(val x: Int, val y: Int) {
    override def hashCode = 41 * (41 + x) + y

    override def equals(other: Any) = other match {
      case that: Point =>
        (that canEqual this) &&
          (this.x == that.x) && (this.y == that.y)
      case _ =>
        false
    }

    def canEqual(other: Any) = other.isInstanceOf[Point]
  }

  object Color extends Enumeration {
    val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
  }

  class ColoredPoint(x: Int, y: Int, val color: Color.Value)
    extends Point(x, y) {

    override def hashCode = 41 * super.hashCode + color.hashCode
    override def equals(other: Any) = other match {
      case that: ColoredPoint =>
        (that canEqual this) &&
          super.equals(that) && this.color == that.color
      case _ =>
        false
    }
    override def canEqual(other: Any) =
      other.isInstanceOf[ColoredPoint]
  }
}
