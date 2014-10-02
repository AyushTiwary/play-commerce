package security.core.crypto

import java.security.SecureRandom
import org.mindrot.jbcrypt.BCrypt

// Somewhat inspired by the spring-security's BCryptPasswordEncoder
final class BCryptPasswordEncoder(
  val rounds: Option[Int] = None,
  val random: Option[SecureRandom] = None
) extends PasswordEncoder {

  assert(rounds.isDefined || rounds.get > 0)

  def encode(plainTextPassword: String) = {
    val numRounds = if (rounds.isDefined && rounds.get > 0) rounds.get else BCryptPasswordEncoder.DefaultRounds

    val salt = if (random.isDefined) {
      BCrypt.gensalt(numRounds, random.get);
    } else {
      BCrypt.gensalt(numRounds);
    }

    BCrypt.hashpw(plainTextPassword, salt);
  }

  def plaintextPassword(plainTextPassword: String, encryptedPassword: String) = {
    BCrypt.checkpw(plainTextPassword, encryptedPassword)
  }
}

object BCryptPasswordEncoder {
  // The BCrypt library internally uses 10 as the default.
  val DefaultRounds = 10
}
