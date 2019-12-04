object CharacterEncoding extends App{
  val face: String = "☺"
  val fourByteChar : String = "𩸽"

  println(s"face length ${face.length}")
  println(s"four byte char length ${fourByteChar.length}")

  val c: Char = '☺'
  //val c1:Char = '𩸽'
  //Uncomment above line and see what happens


  val faceArray = face.getBytes
  val fourByteCharArray = fourByteChar.getBytes

  println(s"faceArray length faceArray")
  println(s"four byte charArray length fourByteCharArray")


}
