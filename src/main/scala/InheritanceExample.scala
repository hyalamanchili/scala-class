

object InheritanceExample  extends App{


  val cat = new Cat
  cat.burp //Can you try cat.eat

  val dog = new Dog
  println(dog.eat) //You can call dog.eat as this is now public
  println(dog.creatureType)

  val unknownAnimal: Animal = new DogOverrideAnotherWay("Boxer")

  println(unknownAnimal.creatureType) //Note: This is not the case in java , you will get wild


  //println(unknownAnimal.eat) Try this by making animial eat public, you will see DogOverrideAnotherWay eat getting called
}



//Example to explain scope



class Animal {
   val creatureType = "wild"
  //Change this to private and see if you can access & change this to protected. Notice you can access protected from burp

  protected def eat = println("I am eating!")
}

class AnimalWithFinalMethod {
  val creatureType = "wild"
  final def eat = println("I am eating!") //Try overriding the method
}

final class AnimalWithClassBeingFinal {
  val creatureType = "wild"
  def eat = println("I am eating!") //Try overriding variable or method
}

sealed class AnimalSealed {
  val creatureType = "wild"
  def eat = println("I am eating!")
} //You can only do this in same file

abstract class AbstractAnimal {
  val creatureType: String
  def eat: Unit
}  //Can you create an instance of animal?

class DogThatImplementsAbstractAnimal extends AbstractAnimal {
  override val creatureType: String = "Canine"
  override def eat: Unit = println("I am a Dog eating!")
}


class Dog extends Animal {
  override val creatureType = "domestic"
  override def eat = println("I am a dog eating!")
}

class DogOverrideFieldInConstructor(override  val creatureType: String) extends Animal {
  override def eat = println("I am a dog eating!")
}

class DogOverrideAnotherWay(dogType: String) extends Animal {
  override val creatureType = dogType
  override def eat = println("I am a dog eating!")
}

class DogCallingSuperClassEat(dogType: String) extends Animal {
  override val creatureType = dogType
  override def eat = {
    super.eat
    println("I am a dog eating!")
  }
}
class Cat extends Animal{
  def burp = {
    eat
    println("Burp! Pardon me!")
  }
}



//Example to show constructors

class Person( name: String, age: Int){
  def this(name: String) = this(name, 0)

  def this() = this("",0)
}
class Adult(name: String, age: Int, idCard:String) extends Person(name,age)

//This will not work, as you have to call atleast one super class constrcutor. This will work if you uncomment def this() = this("",0)

//class AdultNotWork(name: String, age: Int, idCard:String) extends Person. If person has no argument constructor that will work fine

class AnotherAdult(name: String ,  age:Int , idCard:String) extends Person(name){
}


//Traits

trait Carnivore {
  def eat(animal: Animal): Unit
}
trait ColdBlooded

class Crocodile extends Animal with Carnivore with ColdBlooded {
   override val creatureType: String = "croc"
  override def eat: Unit = println("I am a Crocodile eating!")
  def eat(animal: Animal): Unit = println(s"I am a croc and I am eating ${animal.creatureType}")
}

//trait CarnivoreWithParam(name: String)//Traits cannot have constructor parameter
