object SetsAndEquality extends App {

  val strings:Set[String] = Set("hello")

  println(strings.contains("Hello")) //false, case case it not matching

  val cisStrings:Set[CIS] = Set(CIS("hello"))


  println(cisStrings.contains(CIS("Hello")))//true, as we overridden equals method

  val cisSet:Set[CIS] = Set(CIS("Hi"),CIS("hi"), CIS("HI"),CIS("hI"),CIS("hi"),CIS("HI"))


  println(cisSet.size) //Will be 1



  val wisSet:Set[CIS] = Set(CIS("Hi"),CIS("hi      "), CIS("hi"))

  println(wisSet.size) //Will be 2

  case class CIS(value:String){

    val r = scala.util.Random

    def canEqual(other: Any): Boolean = other.isInstanceOf[CIS]

    override def equals(other: Any): Boolean = other match {
      case that: CIS =>
        (that canEqual this) &&
          this.value.toLowerCase() == that.value.toLowerCase()
      case _ => false
    }

    override def hashCode(): Int = {
      val state = Seq(value)
     state.map(_.toLowerCase().hashCode).foldLeft(0)((a, b) => 31 * a + b)
    }
  }

  case class WIS(value:String){

    def canEqual(other: Any): Boolean = other.isInstanceOf[CIS]

    override def equals(other: Any): Boolean = other match {
      case that: CIS =>
        (that canEqual this) &&
          value.trim == that.value.trim
      case _ => false
    }

    override def hashCode(): Int = {
      val state = Seq(value)
      state.map(_.trim().hashCode).foldLeft(0)((a, b) => 31 * a + b)
    }
  }
}

