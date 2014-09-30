package views.forms

import play.api.data._
import play.api.data.Forms._
import dtos.product.LoginForm
import dtos.product.SignupForm

package object security {
  val loginForm = Form(
    mapping(
      "email" -> email,
      "password" -> text(minLength = 1, maxLength = 50)
    ) (LoginForm.apply) (LoginForm.unapply)
  )
  

  val signupForm = Form(
    mapping(
      "email" -> email,
      "password" -> text(minLength = 1, maxLength = 50),
      "verifyPassword" -> text(minLength = 1, maxLength = 50)
    ) (SignupForm.apply) (SignupForm.unapply)
  )
}