package views.forms

import play.api.data._
import play.api.data.Forms._
import dtos.security.LoginFormDTO
import dtos.security.SignupFormDTO

package object security {
  val loginForm = Form(
    mapping(
      "email" -> email,
      "password" -> nonEmptyText(maxLength = 50)
    ) (LoginFormDTO.apply) (LoginFormDTO.unapply)
  )
  

  val signupForm = Form(
    mapping(
      "email" -> email,
      "password" -> nonEmptyText(maxLength = 50),
      "verifyPassword" -> nonEmptyText(minLength = 1, maxLength = 50)
    ) (SignupFormDTO.apply) (SignupFormDTO.unapply)
  )
}
