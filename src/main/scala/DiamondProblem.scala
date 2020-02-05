import scala.collection.mutable.ArrayBuffer
object DiamondProblem extends App{

  val queue = new BasicIntQueue

  queue.put(10)
  queue.put(20)

  println("Queue output")
  println(queue.get())
  println(queue.get())

  println(queue.size())


  val myQueue = new MyQueue //See what MyQueue is inheriting

  myQueue.put(10)

  println("Myqueue output")
  println(myQueue.get)



  val myQueueWithBasicQueue = new BasicIntQueue with Doubling

  myQueueWithBasicQueue.put(10)

  println("basic queue with doubling")

  println(myQueueWithBasicQueue.get)


  val queueWithFilteringFirst = (new BasicIntQueue
    with Incrementing with Filtering) //Order of calling right to left

  println("queue with filtering first")
  queueWithFilteringFirst.put(-1 )
  queueWithFilteringFirst.put(0)
  queueWithFilteringFirst.put(1)

  println(queueWithFilteringFirst.get())
  println(queueWithFilteringFirst.get())




  val queueWithIncrementingFirst = (new BasicIntQueue
    with Filtering with Incrementing)

  queueWithIncrementingFirst.put(-1)
  queueWithIncrementingFirst.put(0)
  queueWithIncrementingFirst.put(1)

  println("queue with incrementing first")
  println(queueWithIncrementingFirst.get())
  println(queueWithIncrementingFirst.get())
  println(queueWithIncrementingFirst.get())


}


abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}


class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]//Creates with default size of 16
  def get() = buf.remove(0)
  def put(x: Int) = { buf += x }

  def size() = buf.length
}


trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { super.put(2 * x) }
}


class MyQueue extends BasicIntQueue with Doubling


trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = { super.put(x + 1) }
}
trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}
