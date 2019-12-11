import CallByName.{compute, param1, param2, param3}

object CallByName extends App {

  def time() = {
    System.nanoTime()
  }

  def printTime(t: => Long): Unit = {
    val time1: Long = t //Time function is called here

    val time2: Long = t //Time function is called here as well

    println(s"$time1 $time2")
    println(time1 == time2)
  }

  printTime(time)

  print(compute(param1,param2, param3))



  def param1() = {
    2*2
  }

  def param2() = {
    ((3*3)*5)/(4+1)
  }

  def param3() = {
    4*5*3*4*(2+2-(9-88999^7))
  }


  //Imagine we have the following functions
  def compute( x : => Int, y : => Int, z : =>Int): Int = x * x




   @scala.annotation.tailrec
   def loop1():Int = loop1

  def first(x: Int, y : => Int) = x

  first(5,loop1) //This will not be infinite loop why

  def factorial(n: Int): Int = 5 match {
    case 0 => 1
    case _ => n * factorial(n-1)
  }

 val factorial1: Int => Int = (n:Int) => if (n<1) 1 else n*factorial1(n-1)



  // @scala.annotation.tailrec
 // val loop2:Int = loop2 //just evaluates to zero, do not use this pattern. All right hand side should be evaluated for a val
}
