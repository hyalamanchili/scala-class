/**
  * Classic example in C Call by Reference
  *
  * #include
  * void swapnum ( int *var1, int *var2 )
  * {
  * int tempnum ;
  * tempnum = *var1 ;
  * *var1 = *var2 ;
  * *var2 = tempnum ;
  * }
  * int main( )
  * {
  * int num1 = 35, num2 = 45 ;
  * printf("Before swapping:");
  * printf("\nnum1 value is %d", num1);
  * printf("\nnum2 value is %d", num2);
  *
  * /*calling swap function*/
  * swapnum( &num1, &num2 );
  *
  * printf("\nAfter swapping:");
  * printf("\nnum1 value is %d", num1);
  * printf("\nnum2 value is %d", num2);
  * return 0;
  * }
  *
  *
  * Before swapping:
  * num1 value is 35
  * num2 value is 45
  * After swapping:
  * num1 value is 45
  * num2 value is 35
  */
object NoCallByReference extends App {

  def swapNum( var1: Int,  var2: Int): (Int, Int) = {
    (var2, var1)
  }

  def animalChanger(animal:Animal){

    animal.changeName()
  }




  val num1 = 1
  val num2 = 2
  println("Before swapping:")
  println(s"\nnum1 value is $num1")
  println(s"\nnum2 value is $num2")

  /*calling swap function*/
  var output = swapNum(num1, num2)

  println(s"\nAfter swapping:")
  println(s"\nnum1 value is $num1")
  println(s"\nnum2 value is $num2")
  println("Output of swap function ->" + output)


  println("Using class")
  val customSwapNumber = new CustomNumberSwapper(num1, num2)
  println("Before swapping:")
  println(s"\nnum1 value is $num1")
  println(s"\nnum2 value is $num2")

  /*calling swap function*/
   output = customSwapNumber.swapNumbers()

  println(s"\nAfter swapping:")
  println(s"\nnum1 value is $num1")
  println(s"\nnum2 value is $num2")
  println(s"Output of swap function -> $output")
  customSwapNumber.printVar1AndVar2()


  println("Passing object  ")
  val animal = new Animal("Cat")
  println("Before mutating:")
  println(s"\nanimal name value is ${animal.name}")
  println(s"animal address $animal")
  /*calling swap function*/
  animalChanger(animal)

  println("After mutating :")
  println(s"\nanimal name value is ${animal.name}")
  println(s"animal address $animal")


  println("Swapping object  ")
  val animal1 = new Animal("Lion")
  val animal2 = new Animal("Tiger")
  println("Before mutating:")
  println(s"\nanimal1 name value is ${animal1.name}")
  println(s"animal1 address $animal1")
  println(s"\nanimal2 name value is ${animal2.name}")
  println(s"animal2 address $animal1")
  val swappedObjects = new CustomObjectSwapper(animal1,animal2).returnSwapObjects()
  println("After  swapping:")
  println(s"\nanimal1 name value is ${animal1.name}")
  println(s"animal1 address $animal1")
  println(s"\nanimal2 name value is ${animal2.name}")
  println(s"animal2 address $animal1")
  println(s"swapped objects $swappedObjects")


  class CustomObjectSwapper(var object1: Object, var object2: Object){



    def returnSwapObjects(): (Object, Object) = {
      val temp:Object = object1
      object1 = object2
      object2 = temp
      (object1, object2)
    }



    def printObject1AndObject2(): Unit ={
      println(s"\nobject1 value is $object1")
      println(s"\nobject2 value is $object2")  }
  }


  class CustomNumberSwapper (var var1: Int, var var2: Int){


    def swapNumbers(): (Int, Int) = {
      val temp = var1
      var1 = var2
      var2 = temp
      (var1, var2)
    }



    def printVar1AndVar2(): Unit ={
      println(s"\nnum1 value is $var1")
      println(s"\nnum2 value is $var2")  }
  }



  class Animal (var name :String ){

    def changeName(): Unit ={
      name = "Dog"
    }

    override def toString = s"Animal($name)"
  }

}

