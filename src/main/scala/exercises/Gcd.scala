package exercises

object Gcd extends App{

 //try iterative
 @scala.annotation.tailrec
 def gcd(x : Int, y: Int): Int ={

   if(y ==0) x else gcd(y, x%y)

 }

 def gcdIterative( x : Int,  y: Int): Int = {
  var a = x
  var b = y
  if (a == 0)
    b
  else if (b == 0)
   a
  else {
   while (a != b) {
    if (a > b)
     a = a - b
    else
     b = b - a
   }
   a
  }
 }


  println(gcd(8,12))
  println(gcd(12,8))
  println(gcd(0,8))
  println(gcd(8,0))


 println(gcdIterative(8,12))
 println(gcdIterative(12,8))
 println(gcdIterative(0,8))
 println(gcdIterative(8,0))
}
