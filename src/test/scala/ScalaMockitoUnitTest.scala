import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._

import org.mockito.ArgumentMatchers.anyString

class ScalaMockitoUnitTest extends FunSuite with BeforeAndAfter with MockitoSugar{


  // a very simple User class
  case class User(name: String)

  // a LoginService must have a 'login' method
  trait LoginService {
    def login(name: String, password: String): Option[User]
  }

  // the code for our real/live LoginService
  class RealLoginService extends LoginService {
    // implementation here ...
    override def login(
      name: String,
      password: String
    ): Option[User] = ???
  }

  test ("test login service") {

    // (1) init
    val service = mock[LoginService]

    // (2) setup: when someone logs in as "johndoe", the service should work;
    //            when they try to log in as "joehacker", it should fail.
    when(service.login("johndoe", "secret")).thenReturn(Some(User("johndoe")))
    when(service.login("joehacker", "secret")).thenReturn(None)

    // (3) access the service
    val johndoe = service.login("johndoe", "secret")
    val joehacker = service.login("joehacker", "secret")

    // (4) verify the results
    assert(johndoe.get == User("johndoe"))
    assert(joehacker == None)

    verify(service, times(1)).login("johndoe", "secret")
    verify(service, times(1)).login("joehacker", "secret")

  }


  test("How a spy works") {

    val list = scala.collection.mutable.ListBuffer.empty[String]
    val spiedList = spy(list)

    // methods can be stubbed on a spy
    when(spiedList.size).thenReturn(100)

    // other methods can also be used
    spiedList.appended("one")
    spiedList.appended("two")

    // and verification can happen on a spy
    verify(spiedList, times(2)).appended(anyString())

    assert(spiedList.size == 100)
  }

}
