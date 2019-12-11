package exercises

object Palindrome extends App {

  println(isPalindrome("mom".toList))
  println(isPalindrome("Dog".toList))


  println(isPalindrome1("mom"))
  println(isPalindrome1("Dog"))


  //Try iterative
  def isPalindrome[A](l: List[A]): Boolean = l match {
    case yes if(l.length < 2) => true  // true if small enough
    case head::tail if (head==tail.last) => isPalindrome(tail.init) // recurse without first and last
    case _ =>  false // this is like an else

  }


  //same as above using string in-build method. Check how reverse is implemented in scala
  def isPalindrome1(l: String): Boolean = l.reverse == l




}
