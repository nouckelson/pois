package test

import demo.Role
import demo.User
import demo.UserRole

class BootStrap {

    def init = { servletContext ->
        def user1=new User(username:'user',enabled: true,password:'user',email: 'user@mbds.ht').save(flush:true)
        def admin=new User(username:'admin',enabled: true,password:'admin',email: 'admin@mbds.ht').save(flush:true)
        def media=new User(username:'media',enabled: true,password:'media',email: 'media@mbds.ht').save(flush:true)

        def userRole=new Role(authority:"ROLE_USER").save(flush: true)
        def adminRole=new Role(authority:"ROLE_ADMIN").save(flush: true)
        def mediaRole=new Role(authority:"ROLE_MEDIATOR").save(flush: true)

        new UserRole(user:user1,role:userRole).save(flush:true)
        new UserRole(user:admin,role:adminRole).save(flush:true)
        new UserRole(user:media,role:mediaRole).save(flush:true)
    }
    def destroy = {
    }
}
