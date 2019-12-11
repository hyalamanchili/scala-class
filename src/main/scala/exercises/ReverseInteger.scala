package exercises

object ReverseInteger extends App {

  println(reverseNumber(0))
  println(reverseNumber(123))
  println(reverseNumber(789))
  println(reverseNumber(-345))

  println("using recursion")

  println(revRecursion(0,0))
  println(revRecursion(123,0))
  println(revRecursion(789,0))
  println(revRecursion(-345,0))


  def reverseNumber(input: Int): Int = {
    var x: Int = input
    var rev: Int = 0
    while (x != 0) {
      rev = rev * 10 + x % 10
      x = x / 10
    }
    rev
  }

val  x: Int = {
  5
}


  def revRecursion(input:Int, result:Int): Int ={
    if(input==0)
      result
    else
      revRecursion(input/10,result * 10 + input % 10)
  }
}
