package security.core

/**
 * The base trait that will be used for identifying users
 */
trait User {
  def authProvider: AuthProvider
  def id: java.io.Serializable
}