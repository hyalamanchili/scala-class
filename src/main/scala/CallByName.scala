import CallByName.{compute, param1, param2, param3}

object CallByName extends App {

  //Example 1
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


  //Example 2

  def param1() = {
    2*2
  }

  def param2() = {
    ((3*3)*5)/(4+1)
  }

  def param3() = {
    4*5*3*4*(2+2-(9-88999^7))
  }

  def compute( x : () => Int, y : () => Int, z  : () =>Int): Int = {

    x() * x() //y and z will never be executed
  }




  //Example 3, see function references are passed as values and their evaluation is deferred until called. Another example of call by name

  def double = (i: Int) => { i * 2 }

  println(double)

  def comput( z : Int => Int) : Int = { println(z); 5}

  comput(double)


  //Example 4 call by name
   @scala.annotation.tailrec
   def loop():Int = loop

  def first(x: Int, y : => Int) = x

  first(5,loop) //This will not be infinite loop why. Remove => and try


  //How to write factorial functionally
  def factorial(n: Int): Int = n match {
    case 0 => 1
    case _ => n * factorial(n-1)
  }

  //One more way
 val factorial1: Int => Int = (n:Int) => if (n<1) 1 else n*factorial1(n-1)



  // @scala.annotation.tailrec
 // val loop2:Int = loop2 //just evaluates to zero, do not use this pattern. All right hand side should be evaluated for a val
}
