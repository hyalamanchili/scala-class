import scala.collection.mutable

object ObjectEquality extends App{

  var a1: Planet = new Planet("Earth", 5)
  var a2: Planet = new Planet ("Mars", 10)
  var a3 = new Planet("Earth", 5)

  println("Comparing a1 and a2")
  println(a1==a2)

  println(a1 equals a2)

  println(a1 eq a2)

  println("Comparing a1 and a3")


  println(a3==a1)

  println(a3 equals a1)

  println(a3 eq a1)


  println("When to use == vs equals")

  val a4 = null
  val a5 = "hello"

  println( a4 == a5)

  var map = mutable.HashMap[Planet,String]()

  map+=(a1  -> "One")
  map+=(a3  -> "One")


  print(s"map size ${map.size}")


}




class Planet(var name:String,var age:Int){

  val r = scala.util.Random

  def canEqual(other: Any): Boolean = other.isInstanceOf[Planet]

  override def equals(other: Any): Boolean = other match {
    case that: Planet =>
      (that canEqual this) &&
        name == that.name && //Try commenting this
        age == that.age
    case _ => false
  }

  override def hashCode(): Int = {
  //  val state = Seq(name, age)
   // state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)

   r.nextInt
  }
}
