package cls

import grails.plugin.springsecurity.annotation.Secured

class DefaultsController {
    @Secured("ROLE_USER")
    def index() { }
}
