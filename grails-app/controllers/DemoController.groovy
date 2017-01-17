import com.demo.User
import grails.plugin.springsecurity.annotation.Secured


@Secured(["ROLE_ADMIN", "ROLE_OWNER", "ROLE_AGENT", "ROLE_CUSTOMER"])
class DemoController {
    def springSecurityService

    def index() {
        User user = springSecurityService?.currentUser as User
        println "====="
        println "=====" + user.username
        [user: user]
    }

    @Secured(["ROLE_CUSTOMER"])
    def hello() {
        User user = springSecurityService?.currentUser as User
        println "====="
        println "=====" + user.username
        render "${user?.authorities}"
    }
}
