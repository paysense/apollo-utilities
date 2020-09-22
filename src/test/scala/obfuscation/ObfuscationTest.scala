package obfuscation

import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite

class ObfuscationTest extends AnyFunSuite with BeforeAndAfterEach {

    final val DEFAULT_MASKED_STRING: String = "MASKED"

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

    test("Simple E-Mail Obfuscation") {
        val testValue = "payU.support@gmail.com"
        val expectedResult  = "pay****@gmail.com"
        val result = ObfuscationUtil.simpleMailObfuscation(testValue)
        try assert(
            result  == expectedResult, "Verify Test"
        )
    }

    test( "Default small number masking") {
        val testValue = 13456
        val expectedValue = 0
        val result = ObfuscationUtil.defaultNumericObfuscation(testValue)

        try assert(
            result  == expectedValue, "Verify Test"
        )
    }

    test( "Default long number masking") {
        val testValue = 1234553234234L
        val expectedValue = 0
        val result = ObfuscationUtil.defaultNumericObfuscation(testValue)

        try assert(
            result  == expectedValue, "Verify Test"
        )
    }

    test("Default string masking") {
        val testValue = "Any string"
        val result = ObfuscationUtil.defaultStringObfuscation(testValue)

        try assert(
            result == DEFAULT_MASKED_STRING, "Verify Test"
        )
    }




}
