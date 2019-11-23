object CallByName extends App {

  def time() = {
    System.nanoTime()
  }

  def printTime(t: => Long) = {
    val time1: Long = t
    val time2: Long = t
    print(time1 == time2)
  }

  printTime(time())
}
