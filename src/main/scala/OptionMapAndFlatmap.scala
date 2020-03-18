object OptionMapAndFlatmap extends App {
  val l = List(1,2,3,4,5)

  println(l.map( x => x*2 ))

  def f(x: Int) = if (x > 2) Some(x) else None


  println(l.map(x => f(x))) //What happens if you try flatmap

  println(l.map(x => f(x)).flatMap( x=>x))

  def g(v:Int) = List(v-1, v, v+1)

  println(l.map(x => g(x)))



  println(l.flatMap(x => g(x)))


  //Where map excels

  val fee = 1.25
  val cost = Some(4.50)
  val finalCost =
    if (cost.isDefined) Some(cost.get+fee) else None

  //Better way to do this

  val finalCost1 = cost.map(_+fee)

  cost.flatMap { x => if (x < 1.00) None else Some(x+fee) }



}
