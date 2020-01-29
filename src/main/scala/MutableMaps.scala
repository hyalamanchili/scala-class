object MutableMaps extends App {
  val immutableStateMap = Map("AL" -> "Alabama", "AK" -> "Alaska")

  val mutaleStateMap = collection.mutable.Map("AL" -> "Alabama", "AK" -> "Alaska")
  val modifyImmStateMap = mutaleStateMap += ("CO" -> "Colorado")
  val modifyMutableStateMap = mutaleStateMap += ("CO" -> "Colorado")

  println(immutableStateMap)
  println(mutaleStateMap)
}
