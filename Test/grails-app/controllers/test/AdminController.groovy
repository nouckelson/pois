package test

import grails.plugin.springsecurity.annotation.Secured

class AdminController {
    @Secured(["ROLE_USER","ROLE_ADMIN","ROLE_MEDIATOR"])
    def index() {}
}
