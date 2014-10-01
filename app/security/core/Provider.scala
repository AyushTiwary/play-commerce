package security.core

import javax.persistence.Access
import javax.persistence.AccessType
import javax.persistence.Embeddable

@Embeddable
@Access(AccessType.FIELD)
sealed abstract class AuthProvider(val name: String) {
  final override def toString = name
}

case object EmailPassword extends AuthProvider("email-password")

case object Google extends AuthProvider("google")

case object Twitter extends AuthProvider("twitter")

case object GitHub extends AuthProvider("github")

object AuthProvider {
  val values: Array[AuthProvider] = Array(EmailPassword, Google, Twitter, GitHub)
  def valueOf(name: String): Option[AuthProvider] = values.find(_.name == name)
  def apply(name: String) = valueOf(name)
}
