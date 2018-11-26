package no.fint.fdk

import spock.lang.Specification

import static no.fint.fdk.Constants.*

class UtilitiesSpec extends Specification {

    private orgNumber = "12324"

    def "Get Organisation URI"() {
        when:
        def uri = Utilities.getOrganisationResourceURI(orgNumber)

        then:
        uri == String.format(BRREG_NS, orgNumber)
    }

    def "Get Catalog URI"() {

        when:
        def uri = Utilities.getCatalogResourceURI(orgNumber)

        then:
        uri == String.format(FINT_CATALOG_NS, orgNumber)
    }

    def "Get Dataset URI"() {

        when:
        def uri = Utilities.getDatasetResourceURI(orgNumber, "1")

        then:
        uri == String.format(FINT_DATASET_NS, orgNumber, "1")
    }
}
