package models

import javax.persistence._
import models.values.Address
import scala.collection.immutable.Set
import java.util.{Set => JSet}
import java.util.HashSet
import javax.persistence.Inheritance
import org.hibernate.FetchMode
import _root_.security.core.{AuthProvider, User => SecureUser}

@Entity
class User extends BaseEntity with SecureUser {

  @Column(nullable = false)
  var firstName: String = _

  @Column(nullable = false)
  var lastName: String = _

  @Column(nullable = false, unique = true)
  var email: String = _

  // password can be nullable since we might allow other auth providers
  @Column(length = 50)
  var password: String = _

  @Embedded
  var address: Address = _

  @ManyToMany(fetch = FetchType.EAGER)
  var roles: JSet[Role] = new HashSet
  
  @Transient
  var currentAuthProvider: AuthProvider = _

  /**
   * A user might log in using different providers, and one or more of
   * them might have the same email address. So, we keep all of them in
   * a separate table, linked with one-another, associated to the same 
   * user-id.
   */
  @ElementCollection(fetch = FetchType.EAGER)
  var linkedAuthProviders: JSet[AuthProvider] = new HashSet
  
  override def toString = {
    """
      User[id: ${id},
      firstName: ${firstName}
      lastName: ${lastName}
      """
  }

  def fullName = {
    firstName + " " + lastName
  }
}

object User {
  val FirstName = "firstName"
  val LastName = "lastName"
  val Email = "email"
  val Password = "password"
}