package no.fint.fdk

import org.apache.jena.riot.Lang
import spock.lang.Specification

class CatalogBuilderSpec extends Specification {

    private catalog

    void setup() {
        catalog = CatalogBuilder
                .builder()
                .organisation('http://organization')
                .title('Some title')
                .description('Some description')
                .publisher(Utilities.getOrganisationResourceURI('12345'))
    }

    def "Build catalog"() {
        when:
        def model = catalog.build()
        model.write(System.out, Lang.TURTLE.getName())

        then:
        model != null
        model.size() == 4

    }

    def "Build catalog with datasets"() {
        when:
        def build = catalog
                .dataset("http://test.no/dataset1")
                .dataset("http://test.no/dataset2")
                .build()
        build.write(System.out, Lang.TURTLE.getName())

        then:
        build != null
        build.size() == 6

    }
}
