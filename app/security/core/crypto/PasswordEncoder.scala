package security.core.crypto

// Inspired by the spring-security's PasswordEncoder
trait PasswordEncoder {
  def encode(plainTextPassword: String): String

  def plaintextPassword(encryptedPassword: String, suppliedPassword: String): Boolean
}
