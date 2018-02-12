package test

class LoginController {

    def index() {
        //println()
        redirect(controller:'login',action:"auth")
    }
}
