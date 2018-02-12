package cls

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PoisController {

    //PoisService poisService

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(["ROLE_ADMIN","ROLE_MEDIATOR","ROLE_USER"])
    def index() {
        def lis=new Pois().getdata()
        respond poisCount:lis.size(),poisData:lis
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIATOR"])
    def create(){
        def lis=new Pois().getdata()
        respond poisCount:lis.size(),poisData:lis
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIATOR"])
    def save(){
        new Pois().savedata(params)
        flash.message="Les donnees sont enregistre  avec succes......"
        redirect(action:"create")
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIATOR"])
    def delete(){
        boolean x=new Pois().deletedata(params)
        if (x){
            flash.message="Les donnees sont eliminees avec succes......"
        }else{
            flash.message="Erreur......"
        }
        redirect(action:"index")
    }
    @Secured(["ROLE_ADMIN","ROLE_MEDIATOR"])
    def edit(){
        def info=new Pois().getdatatoedit(params.id)
        respond poisData:info
    }

    @Secured(["ROLE_ADMIN","ROLE_MEDIATOR"])
    def update(){
        boolean  is_update=new Pois().updatedata(params)
        if(is_update){
            flash.message="Les donnees sont mises a jour avec succes......"
        }else{
            flash.message="Erreur......"
        }
        redirect(action:"index")
    }

    @Secured(["ROLE_ADMIN","ROLE_MEDIATOR"])
def show(){
    def info=new Pois().getdataEdit(params.id)
    respond poisData:info
}

    @Secured(["ROLE_ADMIN","ROLE_MEDIATOR"])
    def upload(){
         def file = request.getFile('files')
         def is_update=new Image().saveImage(file.originalFilename,file.getBytes(),params.id)

            if(is_update){
                flash.message="Les donnees sont enregistre  avec succes......"
            }else{
                flash.message="Erreur......"
            }
            redirect(action:"index")
    }

}
