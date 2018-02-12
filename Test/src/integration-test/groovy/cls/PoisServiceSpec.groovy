package cls

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PoisServiceSpec extends Specification {

    PoisService poisService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pois(...).save(flush: true, failOnError: true)
        //new Pois(...).save(flush: true, failOnError: true)
        //Pois pois = new Pois(...).save(flush: true, failOnError: true)
        //new Pois(...).save(flush: true, failOnError: true)
        //new Pois(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pois.id
    }

    void "test get"() {
        setupData()

        expect:
        poisService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pois> poisList = poisService.list(max: 2, offset: 2)

        then:
        poisList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        poisService.count() == 5
    }

    void "test delete"() {
        Long poisId = setupData()

        expect:
        poisService.count() == 5

        when:
        poisService.delete(poisId)
        sessionFactory.currentSession.flush()

        then:
        poisService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pois pois = new Pois()
        poisService.save(pois)

        then:
        pois.id != null
    }
}
