package no.fint.fdk

import spock.lang.Specification

class LegalBasisSpec extends Specification {

    def "Create object"() {
        when:
        def legalBasis = LegalBasis.of("test", "test")

        then:
        legalBasis.label.contains("test")
        legalBasis.source.contains("test")
    }
}
