package demo

import com.demo.Role
import com.demo.User
import com.demo.UserRole
import grails.plugin.springsecurity.annotation.Secured

@Secured(value = ['permitAll'])
class SignUpController {
    def springSecurityService

    def index() {
    }

    def signup() {
        println ""
        println " params.username " + params.username
        println "params.password " + params.password
        println "On Signing Up"
        if (!User.findByUsername(params.username)) {
            User user = new User()
            user.username = params.username
            user.password = params.password
            user.save(flush: true)
            println "*****************"
            Role role = Role.findByAuthority('ROLE_CUSTOMER')
            UserRole.create(user, role, true)
//            springSecurityService.reauthenticate(user?.username)
            redirect(controller: 'demo', action: 'index')
        } else {
            flash.error = "User already Exists"
            redirect(controller: 'login', action: 'auth')
        }
    }
}

