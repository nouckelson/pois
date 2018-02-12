package cls

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmplacementServiceSpec extends Specification {

    EmplacementService emplacementService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Emplacement(...).save(flush: true, failOnError: true)
        //new Emplacement(...).save(flush: true, failOnError: true)
        //Emplacement emplacement = new Emplacement(...).save(flush: true, failOnError: true)
        //new Emplacement(...).save(flush: true, failOnError: true)
        //new Emplacement(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //emplacement.id
    }

    void "test get"() {
        setupData()

        expect:
        emplacementService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Emplacement> emplacementList = emplacementService.list(max: 2, offset: 2)

        then:
        emplacementList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        emplacementService.count() == 5
    }

    void "test delete"() {
        Long emplacementId = setupData()

        expect:
        emplacementService.count() == 5

        when:
        emplacementService.delete(emplacementId)
        sessionFactory.currentSession.flush()

        then:
        emplacementService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Emplacement emplacement = new Emplacement()
        emplacementService.save(emplacement)

        then:
        emplacement.id != null
    }
}
