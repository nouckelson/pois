package cls

class Emplacement {
    String adresse
    Double longitude
    Double latitude

    static belongsTo = [poi: Pois]
    static constraints = {
        longitude blank: false
        latitude blank: false
    }
}
