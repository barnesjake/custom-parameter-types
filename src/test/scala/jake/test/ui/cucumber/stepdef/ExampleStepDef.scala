package jake.test.ui.cucumber.stepdef

import jake.test.ui.helpers.TypesToRegister.Animal

class ExampleStepDef extends BaseStepDef {

  var animal: Animal = _

  Given("""^I have an animal (.*)$""") { a: Animal =>
    animal = a
  }

  Then("""^The animal says (.*)$""") { sound: String =>
    animal.speak should be(sound)
  }

}
