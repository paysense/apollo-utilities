package obfuscation

import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite

class ObfuscationTest extends AnyFunSuite with BeforeAndAfterEach {

    test("Simple String Obfuscation: Small String") {
        val testValue = "abc"
        val expectedResult = "a"
        val result = ObfuscationUtil.simpleStringObfuscation(testValue)
        try assert(
            result == expectedResult , "Verify Test"
        )
    }
}
