package jake.test.ui.cucumber.stepdef

import cucumber.api.scala.{EN, ScalaDsl}
import jake.test.ui.driver.Driver
import org.scalatest.Matchers
import org.scalatest.concurrent.Eventually

trait BaseStepDef extends ScalaDsl with EN with Driver with Eventually with Matchers {

  sys.addShutdownHook {

  }
}
