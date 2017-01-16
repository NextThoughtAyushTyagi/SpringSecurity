import grails.plugin.springsecurity.annotation.Secured


@Secured(["ROLE_ADMIN", "ROLE_OWNER", "ROLE_AGENT"])
class DemoController {

    def index() {
        println "====="
        println "====="
        render "Ayush Tyagi"
    }

    def hello() {

    }
}
