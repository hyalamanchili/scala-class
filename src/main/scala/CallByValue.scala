object CallByValue extends App {

  def time(): Long = {
    System.nanoTime()
  }

  def printTime(t: Long) = {
    val time1: Long = t
    val time2: Long = t
    println(s"$time1 $time2")
    println(time1 == time2)
  }

  printTime(time)

}
