package dtos

package object security {
  case class LoginForm(email: String, password: String)
  case class SignupForm(email: String, password: String, confirmPassword: String)


  object LoginForm {
    val Email = "email"
    val Password = "password"
  }

  object SignupForm {
    val Email = "email"
    val Password = "password"
    val ConfirmPassword = "confirmPassword"
  }
}
