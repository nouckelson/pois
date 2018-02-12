package cls

import grails.gorm.services.Service

@Service(Emplacement)
interface EmplacementService {

    Emplacement get(Serializable id)

    List<Emplacement> list(Map args)

    Long count()

    void delete(Serializable id)

    Emplacement save(Emplacement emplacement)

}