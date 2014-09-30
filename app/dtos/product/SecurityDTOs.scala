package dtos.product

case class LoginForm(email: String, password: String)

case class SignupForm(email: String, password: String, confirmPassword: String)