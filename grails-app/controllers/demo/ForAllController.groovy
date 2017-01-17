package demo


import grails.plugin.springsecurity.annotation.Secured

@Secured(["permitAll"])
class ForAllController {

    def index() {}

    def hello() {
        render "Hello this is for all Users"
    }
}
