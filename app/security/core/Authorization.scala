package security.core

/**
 * A trait that should be implemented by any custom authorization
 * logic.
 */
trait Authorization[U] {
  def isAuthorized[T <: U](user: T, request: play.api.mvc.RequestHeader)
}