import scala.util.Random

object PatternMatching extends App{

  //Matching values

  val command: String = "test"

  command match {
    case "ls" => println("matched ls")
    case "ps" => println("matched ps")
    case "exit" => println("matched exit")
    case _ => println("default")
  }


  //Pattern
//Variable pattern matching How casing effects
  val lowercase = 5
  val UPPERCASE = 10


  def validate(input: Int): Unit ={

    input match {

      case this.lowercase => println("lower case matched "+lowercase) //remove this everything matches

      case UPPERCASE => println("upper case matched" + UPPERCASE )

     case _ => println("default case" + _ )
    }
  }

 println(validate(4))

  println(validate(10))

  println (validate(5))


  //How Equals effects

  class NotEqualToAnything {
    override def equals(obj: Any): Boolean = false
  }

  val x = new NotEqualToAnything()
  val y = new NotEqualToAnything()

  println(x.equals(y)) // false

  x match {
    case y =>
      println("Whaaaaa! What has just happened?")
  }

  //Solution quote variable naming using ` `
 /* x match {
    case `y` =>
      println("Whaaaaa! What has just happened?")
    case _ =>
      println("no-match")
  }*/



  // Constant matching

  def constantsPatternMatching(constant: Any): String = {
    constant match {
      case 0 => "I'm equal to zero"
      case 4.5d => "I'm a double"
      case false => "I'm the contrary of true"
      case _ => s"I'm unknown and equal to $constant"
    }
  }

  //Typed patter
  def typedPatternMatching(any: Any): String = {
    any match {
      case string: String => s"I'm a string. My value: $string"
      case integer: Int => s"I'm an integer. My value: $integer"
      case _ => s"I'm from an unknown type. My value: $any"
    }
  }

  //Pattern binder

  sealed trait Shape
  case class Rectangle(height: Int, width: Int) extends Shape
  case class Circle(radius: Int) extends Shape
  case object Point extends Shape

  (Circle(5): Shape) match {
    case Rectangle(h, w) => s"rectangle, $h x $w."
    case Circle(r) if r > 9 => s"large circle"
    case c @ Circle(_) => s"small circle: ${c.radius}"  // Whole matched object is bound to c
    case Point => "point"
  }

  Seq(Some(1), Some(2), None) match {
    // Only the first element of the matched sequence is bound to the name 'c'
    case Seq(c @ Some(1), _*) => c.head
    case _ => None
  }

  //Literal pattern

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  //Stable identifier pattern

  val b = 2
  def simpleMatch(a: Int): String = a match{
    case `b` => "OK"
    case _ => a + " NOK"}
  println((0 to 5).map(simpleMatch))


//Constructor pattern matching
case class Dog(breed:String,name:String,age:Int)
val leo= Dog("Dogue de Bordeaux","Leo",2)
val fluffy= Dog("Lesser Indian Spitz","Fluffy",8)
val candy= Dog("Pug","Candy",6)

for(dog<-List(leo,fluffy,candy)){
   dog match{
    case Dog("Dogue de Bordeaux","Leo",2)=>println("Hi, Leo")
    case Dog("Lesser Indian Spitz","Fluffy",8)=>println("Hi, Fluffy")
    case Dog(breed,name,age)=>println("Hi, "+ breed + name + age)
     }
   }


//Tuple pattern matching

val planets = List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6), ("Mars", 227.9), ("Jupiter", 778.3))
planets.foreach{
  case ("Earth", distance) =>
    println(s"Our planet is $distance million kilometers from the sun")
  case _ =>
}
  //Extractor pattern matching

  object CustomerID {

    def apply(name: String) = s"$name--${Random.nextLong}"

    def unapply(customerID: String): Option[String] = {
      val stringArray: Array[String] = customerID.split("--")
      if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
    }
  }

  val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
  customer1ID match {
    case CustomerID(name) => println(name)  // prints Sukyoung
    case _ => println("Could not extract a CustomerID")
  }

  //Sequence pattern match & regex

  def f(ints: Seq[Int]): Unit = ints match {
    case Seq(first, second, tail @ _*) =>
      println(s"The seq has at least two elements : $first, $second. The rest of the Seq is $tail")
    case Seq(first, tail @ _*) =>
      println(s"The seq has at least one element : $first. The rest of the Seq is $tail")
    // alternative syntax
    // here of course this one will never match since it checks
    // for the same thing as the one above
    case first +: tail =>
      println(s"The seq has at least one element : $first. The rest of the Seq is $tail")
    case _ =>
      println("The seq didn't match any of the above, so it must be empty")
  }

  f(Seq(1,2,3))


  //Alternative pattern

  val cmd = "stop"
  cmd match {
    case "start" | "go" => println("starting")
    case "stop" | "quit" | "exit" => println("stopping")
    case _ => println("doing nothing")
  }

 //Regex pattern

  def regexPatterns(toMatch: String): String = {
    val numeric = """([0-9]+)""".r
    val alphabetic = """([a-zA-Z]+)""".r
    val alphanumeric = """([a-zA-Z0-9]+)""".r

    toMatch match {
      case numeric(value) => s"I'm a numeric with value $value"
      case alphabetic(value) => s"I'm an alphabetic with value $value"
      case alphanumeric(value) => s"I'm an alphanumeric with value $value"
      case _ => s"I contain other characters than alphanumerics. My value $toMatch"
    }
  }

println(regexPatterns("123"))
  println(regexPatterns("abc"))
  println(regexPatterns("abc123"))
  println(regexPatterns("$123abc"))


}
