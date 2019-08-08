package jake.test.ui.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver


trait Driver {

  implicit lazy val driver: WebDriver = new ChromeDriver()

}
