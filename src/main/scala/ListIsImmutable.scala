import scala.collection.immutable.Queue
object ListIsImmutable extends App {

  val colors: Seq[String] = List("red", "blue", "green")

  println(colors)
  val colorsWithAppend = colors.appended("yellow")
  println(colorsWithAppend)
  val colorsWithPrepend = colors.prepended("black")
  println(colorsWithPrepend)
  val colorsWithUpdate = colors.updated(0,"Orange")
  println(colorsWithUpdate)



  println(colors)//The original list stayed in tact because lists are immutable

val c  = Vector(1,2,3)
}
