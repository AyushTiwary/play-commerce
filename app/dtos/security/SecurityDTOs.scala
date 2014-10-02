package dtos

package object security {
  case class LoginFormDTO(email: String, password: String)
  case class SignupFormDTO(email: String, password: String, confirmPassword: String)

  object LoginFormDTO {
    val Email = "email"
    val Password = "password"
  }

  object SignupFormDTO {
    val Email = "email"
    val Password = "password"
    val ConfirmPassword = "confirmPassword"
  }
}
