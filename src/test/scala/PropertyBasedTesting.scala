import org.scalatest._
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalatestplus.scalacheck._
import prop._


class PropertyBasedTesting extends PropSpec with ScalaCheckPropertyChecks   {
  val first14FiboNums =
    Table("n", 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233)


  forAll (first14FiboNums) { n =>
    //TODO create a class FiboGen that returns next fibonacci number
  //  assert(FiboGen.next == (n))
  }
  forAll { (n: Int, d: Int) =>

    whenever (d != 0 && d != Integer.MIN_VALUE
      && n != Integer.MIN_VALUE) {

      val f = new Fraction(n, d)

      if (n < 0 && d < 0 || n > 0 && d > 0)
        assert(f.numer > 0)
      else if (n != 0)
        assert(f.numer  < 0)
      else
        assert(f.numer === 0)

      assert(f.denom  > 0)
    }
  }


  val invalidCombos =
    Table(
      ("n",               "d"),
      (Integer.MIN_VALUE, Integer.MIN_VALUE),
      (1,                 Integer.MIN_VALUE),
      (Integer.MIN_VALUE, 1),
      (Integer.MIN_VALUE, 0),
      (1,                 0)
    )

  forAll (invalidCombos) { (n: Int, d: Int) =>

  intercept[IllegalArgumentException]{
           new Fraction(n, d)
  }

  }
}



class Fraction(n: Int, d: Int) {

  require(d != 0)
  require(d != Integer.MIN_VALUE)
  require(n != Integer.MIN_VALUE)

  val numer = if (d < 0) -1 * n else n
  val denom = d.abs

  override def toString = numer + " / " + denom
}
