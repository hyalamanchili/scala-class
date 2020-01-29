import scala.collection.mutable.{ArrayBuffer, ListBuffer}
object MutableLists extends App {

  val buf = new ListBuffer[Int]

  buf += 1

  buf += 2

  buf += 3

  println(s"Initial buffer $buf")

  val bufAfterTail = buf.tail

  println(s"buffer after performing tail $bufAfterTail")

  println(s"initial after performing tail . Note it stays as is $buf")

  bufAfterTail.append(4)

  println(s"append to new buffer $bufAfterTail")

  println(s" initial buffer still says the same $buf")

  bufAfterTail.insert(3,5)

  bufAfterTail.insert(0,1) //bufAfterTail.insert(1,10) it will shift the elements by 1


  println(s"new buffer after insert operations $bufAfterTail")


  //Now lets do some operations on ArrayBuffer
  val arrBuf = new ArrayBuffer[Int]()

  arrBuf += 1

  arrBuf += 2

  arrBuf += 3

  println(s"Initial buffer $arrBuf")

  val arrBufAfterTail = buf.tail

  println(s"buffer after performing tail $arrBufAfterTail")

  println(s"initial after performing tail . Note it stays as is $arrBuf")

  arrBufAfterTail.append(4)

  println(s"append to new buffer $arrBufAfterTail")

  println(s" initial buffer still says the same $arrBuf")


  arrBufAfterTail.insert(3,5)

  arrBufAfterTail.insert(0,1)

  println(s"new buffer after insert operations $arrBufAfterTail")


}
