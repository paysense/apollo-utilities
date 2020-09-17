package obfuscation

import java.nio.charset.StandardCharsets
import java.security.NoSuchAlgorithmException
import java.security.spec.InvalidKeySpecException
import java.util.Base64
import javax.crypto.{Cipher, SecretKeyFactory}
import javax.crypto.spec.{PBEKeySpec, SecretKeySpec}
import scala.util.control.NonFatal

/**
 * ECB - Electronic Code Book is a mode of operation for a block cipher, with the characteristic that each possible block of plaintext has a defined
 * corresponding cipher text value and vice versa.
 *
 * Padding - The length of the input to be encrypted must be an exact multiple of the block length B in bytes.
 * for all AES variants it is 16 bytes (128 bits). If the length of the data to be encrypted is not an exact multiple of B, it must be padded to make it so
 *
 * PKCS5Padding - If the block length is B then add N padding bytes of value N to make the input length up to the next exact multiple of B.
 * If the input length is already an exact multiple of B then add B bytes of value B.
 *
 * PBKDF2 - Password-based-Key-Derivative-Function, a successor of PBKDF1 and is used to implement a pseudorandom function, such as a cryptographic hash,
 * cipher, or HMAC to the input password or passphrase along with a salt value and repeats the process many times to produce a derived key,
 * which can then be used as a cryptographic key in subsequent operations
 *
 * PBKDF2WithHmacSHA512 will produce a hash length of 512 bits.
 * https://stackoverflow.com/questions/19348501/pbkdf2withhmacsha512-vs-pbkdf2withhmacsha1
 *
 * Salt - Random data that is used as an additional input to a one-way function that hashes data
 */

object Encryption {

	private val KeySalt           = "3hoj3jon-jh31-o15c-3h61-8ars8dc1n3lw".getBytes(StandardCharsets.UTF_8)
	private val AES               = "AES"
	private val Algorithm         = AES + "/ECB/PKCS5Padding"
	private val HashingIterations = 9999
	private val KeySizeBits       = 128

	private def hashPassword(password: Array[Char],
	                 salt: Array[Byte],
	                 iterations: Int = HashingIterations,
	                 keyLength: Int = KeySizeBits,
	                 hashingAlgorithm: String = "PBKDF2WithHmacSHA512"): Array[Byte] = {

		try {
			val keyFactory = SecretKeyFactory.getInstance(hashingAlgorithm)
			val keySpec    = new PBEKeySpec(password, salt, iterations, keyLength)
			val key        = keyFactory.generateSecret(keySpec)
			key.getEncoded
		} catch {
			case e @ (_: NoSuchAlgorithmException | _: InvalidKeySpecException) => throw new RuntimeException("Password hashing error", e)
		}
	}

	private def prepareKey(password: String): SecretKeySpec = new SecretKeySpec(hashPassword(password.toCharArray, KeySalt), AES)

	def encryptData(key: String, input: Any): String = {

		try {
			val cipher = Cipher.getInstance(Algorithm)
			cipher.init(Cipher.ENCRYPT_MODE, prepareKey(key))
			val encrypted = cipher.doFinal(input.toString.getBytes(StandardCharsets.UTF_8))
			Base64.getEncoder.encodeToString(encrypted)
		} catch {
			case NonFatal(e) => throw new RuntimeException("Encrypt error", e)
		}
	}

	def decryptData(key: String, encryptedString: String): String = {

		try {
			val cipher: Cipher = Cipher.getInstance(Algorithm)
			cipher.init(Cipher.DECRYPT_MODE, prepareKey(key))
			val decrypted = cipher.doFinal(Base64.getDecoder.decode(encryptedString.getBytes(StandardCharsets.UTF_8)))
			new String(decrypted)
		} catch {
			case NonFatal(e) => throw new RuntimeException("Decrypt error", e)
		}
	}
}
