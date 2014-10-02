package app.module

import controllers.security.SecurityController
import scaldi.Module
import controllers.Application
import daos.RoleDAO
import daos.UserDAO
import services.RoleService
import services.UserService
import daos.TokenDAO
import services.TokenService
import controllers.product.CategoryController
import controllers.product.ProductController
import daos.product.CategoryDAO
import services.product.CategoryService
import daos.product.ProductDAO
import services.product.ProductService

import security.core.crypto.BCryptPasswordEncoder
import security.core.crypto.PasswordEncoder

class WebModule extends Module {

  bind [PasswordEncoder] to new BCryptPasswordEncoder

  binding to new Application
  binding to new CategoryController
  binding to new ProductController
  binding to new SecurityController

  binding to new RoleDAO
  binding to new RoleService

  binding to new UserDAO
  binding to new UserService

  binding to new TokenDAO
  binding to new TokenService
  
  binding to new CategoryDAO
  binding to new CategoryService
  
  binding to new ProductDAO
  binding to new ProductService
}
