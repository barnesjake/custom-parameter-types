package jake.test.ui.helpers

object TypesToRegister {

  case class Animal(name: String) {
    def speak: String = name.toLowerCase match {
      case "lion" => "ROAR"
      case _ => "some noise"
    }
  }

}
