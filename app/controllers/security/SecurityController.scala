package controllers.security

import play.api.mvc.Action
import play.api.mvc.Controller
import scaldi.Injector
import scaldi.Injectable.inject
import services.UserService
import services.RoleService
import security.core.crypto.PasswordEncoder

import views.forms.security.loginForm
import dtos.security.LoginForm

class SecurityController(implicit inj: Injector) extends Controller {
  private val userService = inject[UserService]
  private val roleService = inject[RoleService]

  private val passwordEncoder = inject[PasswordEncoder]

  def loginPage = Action { implicit request =>
    Ok(views.html.security.login(views.forms.security.loginForm))
  }

  def login = Action { implicit request =>
    loginForm.bindFromRequest.fold(loginFormWithErrors => {
      Ok(views.html.security.login(loginFormWithErrors))
    }, loginForm => {
      Ok(views.html.index("Logged in Successfully"))
    })
  }
}

