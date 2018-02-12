package cls
import java.sql.*;
import groovy.sql.Sql
class Pois {
    String nom
    String description
    def myList = []
    def List
    def sql = Sql.newInstance('jdbc:mysql://localhost:3306/Poi','poi', 'poi1234', 'com.mysql.jdbc.Driver')
    //Emplacement adresse
    static hasOne = [emplacement:Emplacement]
    static hasMany = [images:Image]
    String toString() {
        return this.nom+' '+this.description;
    }
    static mapping = {
        emplacement cascade:"all-delete-orphan"
    }
    static constraints = {
        nom blank: false
        description blank: false
    }

    def getdata(){
        sql.rows("select pois.id,pois.nom,pois.description,emplacement.longitude,emplacement.adresse,emplacement.latitude FROM pois LEFT JOIN emplacement ON pois.id=emplacement.poi_id").each {
            myList.add(it);
        }
        return myList;
    }


    def getdataEdit(i){
        sql.rows("select p.id,p.nom as pois_nom,p.description,im.nom as image_nom,im.filedata from pois as p left join pois_image on pois_image.pois_images_id=p.id  left join image as im on pois_image.image_id=im.id  where p.id=?",i).each {
            List=it;
        }
        return List;
    }
    def getdatatoedit(i){
        sql.rows("select pois.id,pois.nom,pois.description,emplacement.longitude,emplacement.adresse,emplacement.latitude FROM pois LEFT JOIN emplacement ON pois.id=emplacement.poi_id  where pois.id=?",i).each {
            List=it;
        }
        return List;
    }

    @Override
    Serializable ident() {
        return null
    }

    def savedata(params){
        def idpois
        def query = "INSERT INTO pois (nom, description,version) values (?, ?,?)"
        try {
            sql.execute(query,[params.nom,params.description,"1234"]);
            sql.rows("select last_insert_id() as id").each {
                idpois= it[0];
            }
            println(idpois+"/"+params.longitude+"/"+params.latitude+"/"+params.adresse)
            sql.execute("INSERT INTO emplacement(longitude,latitude,adresse,poi_id,version)VALUES(?,?,?,?,?)",[params.longitude,params.latitude,params.adresse,idpois,"1234"]);
            return true
        }catch (Exception ex){
            return false
        }

        sql.close()

    }

    def deletedata(params){
        def query = "DELETE FROM pois WHERE id=?"
        try {
            sql.execute(query,params.id);
            return true
        }catch (Exception ex){
            return false
        }

        sql.close()
    }

    def updatedata(params){
        def query = "UPDATE pois set nom=?,description=? WHERE id=?"
        try {
            sql.execute(query,[params.nom,params.description,params.id]);
            return true
        }catch (Exception ex){
            return false
        }

        sql.close()
    }

}
