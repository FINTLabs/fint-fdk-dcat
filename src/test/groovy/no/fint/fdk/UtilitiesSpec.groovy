package no.fint.fdk

import spock.lang.Specification

import static no.fint.fdk.Constants.BRREG_NS

class UtilitiesSpec extends Specification {

    private orgNumber = "12324"

    def "Get Organisation URI"() {
        when:
        def uri = Utilities.getOrganisationResourceURI(orgNumber)

        then:
        uri == String.format(BRREG_NS, orgNumber)
    }

}
