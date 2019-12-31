object EqualityWithLoop extends App {

  val a0: A = new A(new B(a1))
  val a1: A = new A(new B(a0))
  val a2: A = new A(new B(a0))


  print(a1 == a2)


  class A(val b: B) {


    def canEqual(other: Any): Boolean = other.isInstanceOf[A]

    override def equals(other: Any): Boolean = other match {
      case that: A =>
        (that canEqual this) &&
          b == that.b
      case _ => false
    }

    override def hashCode(): Int = {
      val state = Seq(b)
      state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
    }
  }

  class B(val a: A) {


    def canEqual(other: Any): Boolean = other.isInstanceOf[B]

    override def equals(other: Any): Boolean = other match {
      case that: B =>
        (that canEqual this) &&
          a == that.a

      case _ => false
    }

  }

}
