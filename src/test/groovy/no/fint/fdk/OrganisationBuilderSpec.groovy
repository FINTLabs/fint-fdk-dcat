package no.fint.fdk

import org.apache.jena.riot.Lang
import spock.lang.Specification

class OrganisationBuilderSpec extends Specification {

    private organisation

    void setup() {
        organisation = OrganisationBuilder.builder().organisation("971045698", "RFK")
    }

    def "Build organisation"() {
        when:
        def model = organisation.build()
        model.write(System.out, Lang.TURTLE.getName())

        then:
        model != null
        model.size() == 3
    }


}
