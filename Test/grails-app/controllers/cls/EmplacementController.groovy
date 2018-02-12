package cls

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmplacementController {

    EmplacementService emplacementService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond emplacementService.list(params), model:[emplacementCount: emplacementService.count()]
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def show(Long id) {
        respond emplacementService.get(id)
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def create() {
        respond new Emplacement(params)
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def save(Emplacement emplacement) {
        if (emplacement == null) {
            notFound()
            return
        }

        try {
            emplacementService.save(emplacement)
        } catch (ValidationException e) {
            respond emplacement.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'emplacement.label', default: 'Emplacement'), emplacement.id])
                redirect emplacement
            }
            '*' { respond emplacement, [status: CREATED] }
        }
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def edit(Long id) {
        respond emplacementService.get(id)
    }

    def update(Emplacement emplacement) {
        if (emplacement == null) {
            notFound()
            return
        }

        try {
            emplacementService.save(emplacement)
        } catch (ValidationException e) {
            respond emplacement.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'emplacement.label', default: 'Emplacement'), emplacement.id])
                redirect emplacement
            }
            '*'{ respond emplacement, [status: OK] }
        }
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        emplacementService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'emplacement.label', default: 'Emplacement'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'emplacement.label', default: 'Emplacement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
