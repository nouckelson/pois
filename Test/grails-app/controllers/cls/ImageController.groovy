package cls

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ImageController {
    ImageService imageService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(["ROLE_USER","ROLE_ADMIN","ROLE_MEDIADOR"])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond imageService.list(params), model:[imageCount: imageService.count()]
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def show(Long id) {
        respond imageService.get(id)
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def create() {
        respond new Image(params)
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def save(Image image) {
        if (image == null) {
            notFound()
            return
        }

        try {
            imageService.save(image)
        } catch (ValidationException e) {
            respond image.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'image.label', default: 'Image'), image.id])
                redirect image
            }
            '*' { respond image, [status: CREATED] }
        }
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def edit(Long id) {
        respond imageService.get(id)
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def update(Image image) {
        if (image == null) {
            notFound()
            return
        }

        try {
            imageService.save(image)
        } catch (ValidationException e) {
            respond image.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'image.label', default: 'Image'), image.id])
                redirect image
            }
            '*'{ respond image, [status: OK] }
        }
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIADOR"])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        imageService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'image.label', default: 'Image'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'image.label', default: 'Image'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
