package cls

import grails.gorm.services.Service

@Service(Pois)
interface PoisService {

    Pois get(Serializable id)

    List<Pois> list(Map args)

    Long count()

    void delete(Serializable id)

    Pois save(Pois pois)

}