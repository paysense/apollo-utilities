package obfuscation

import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite

class ObfuscationTest extends AnyFunSuite with BeforeAndAfterEach {

    test("Simple String Obfuscation: Small String") {
        val testValue = "Relax, its only ONES and ZEROS!"
        val expectedResult = "****************************OS!"
        val result = ObfuscationUtil.simpleStringObfuscation(testValue)
        try assert(
            result == expectedResult , "Verify Test"
        )
    }

    test("Simple Numeric Obfuscation: Small String") {
        val testValue = 12332345233L
        val expectedResult = 49329380932L
        val result = ObfuscationUtil.simpleNumericObfuscation(testValue)
        try assert(
            result == expectedResult , "Verify Test"
        )
    }
}
