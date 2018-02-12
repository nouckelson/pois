package cls
import java.sql.*;
import groovy.sql.Sql
class Image {
    String nom
    byte[] filedata
    def sql = Sql.newInstance('jdbc:mysql://localhost:3306/Poi','poi', 'poi1234', 'com.mysql.jdbc.Driver')

    static constraints = {
        nom blank: false
        filedata(blank: true, nullable:true, maxSize:1073741824)
    }

    def saveImage(name,path,poisid){
        def List
        def query = "insert into image(nom,filedata,version) values(?,?,?)"
        try {
           def p= sql.execute(query,[name,path,'1234']);
            sql.rows("select last_insert_id() as id").each {
                List= it;
            }
            sql.execute("INSERT  INTO  pois_image (pois_images_id,image_id) VALUES (?,?)",[poisid,List[0]]);
            return true
        }catch (Exception ex){
            return false
        }

        //sql.close()
    }
}
