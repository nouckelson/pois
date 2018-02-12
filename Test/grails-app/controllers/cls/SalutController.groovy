package cls

import grails.plugin.springsecurity.annotation.Secured

class SalutController {

    @Secured(["ROLE_USER","ROLE_ADMIN"])
    def index() {

    }
    @Secured("ROLE_ADMIN")
    def show(){
        render "hello"
    }
}
