import com.domazey.kotlinexpansion.console.color.blue
import com.domazey.kotlinexpansion.console.color.purpleBg
import com.domazey.kotlinexpansion.console.color.red
import org.junit.Test

class ConsoleTest {

  @Test
  fun consoleTest() {
    println("${red("Hello")}${purpleBg(blue(" World"))} What's up")
  }

}