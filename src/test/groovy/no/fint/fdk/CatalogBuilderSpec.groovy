package no.fint.fdk

import org.apache.jena.riot.Lang
import spock.lang.Specification

class CatalogBuilderSpec extends Specification {

    private catalog

    void setup() {
        catalog = CatalogBuilder.builder().organisation("12345", "FK")
    }

    def "Build catalog"() {
        when:
        def model = catalog.build()
        model.write(System.out, Lang.TURTLE.getName())

        then:
        model != null
        model.size() == 3

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
        build.size() == 5

    }
}
