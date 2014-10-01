package controllers.security

import play.api.mvc.Action
import play.api.mvc.Controller
import scaldi.Injector
import scaldi.Injectable.inject
import services.UserService
import services.RoleService

class SecurityController(implicit inj: Injector) extends Controller {
  private val userService = inject [UserService]
  private val roleService = inject [RoleService]
  
  def login = Action  { implicit request =>
    Ok(views.html.security.login(views.forms.security.loginForm))
  }  
}
