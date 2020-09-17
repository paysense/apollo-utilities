package obfuscation

import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite

class EncryptionTest extends AnyFunSuite with BeforeAndAfterEach {

	test("Encrypt string data test") {
		val key = "Hp92nq12my4b7buz"
		val testInput = "Apollo"
		val expectedResult = "64lIHi7GOJ2AV7dT4CmFjw=="
		val result = Encryption.encryptData(key, testInput)
		assert(
			result == expectedResult , "Verify Test"
		)
	}

	test("Decrypt string data test") {
		val key = "Hp92nq12my4b7buz"
		val testInput = "64lIHi7GOJ2AV7dT4CmFjw=="
		val expectedResult = "Apollo"
		val result = Encryption.decryptData(key, testInput)
		assert(
			result == expectedResult , "Verify Test"
		)
	}

	test("Encrypt empty string data test") {
		val key = "Hp92nq12my4b7buz"
		val testInput = ""
		val expectedResult = "5BX6x3h+JwewnnV0Jef36w=="
		val result = Encryption.encryptData(key, testInput)
		assert(
			result == expectedResult , "Verify Test"
		)
	}

	test("Decrypt empty string data test") {
		val key = "Hp92nq12my4b7buz"
		val testInput = "5BX6x3h+JwewnnV0Jef36w=="
		val expectedResult = ""
		val result = Encryption.decryptData(key, testInput)
		assert(
			result == expectedResult , "Verify Test"
		)
	}

	test("Encrypt int data test") {
		val key = "Hp92nq12my4b7buz"
		val testInput = 2020
		val expectedResult = "cGGyWpqg3/yxlLua0igqkQ=="
		val result = Encryption.encryptData(key, testInput)
		assert(
			result == expectedResult , "Verify Test"
		)
	}

	test("Decrypt int data test") {
		val key = "Hp92nq12my4b7buz"
		val testInput = "cGGyWpqg3/yxlLua0igqkQ=="
		val expectedResult = "2020"
		val result = Encryption.decryptData(key, testInput)
		assert(
			result == expectedResult , "Verify Test"
		)
	}
}
