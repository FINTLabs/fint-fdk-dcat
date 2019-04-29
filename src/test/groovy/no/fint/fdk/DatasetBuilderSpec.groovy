package no.fint.fdk


import no.fint.fdk.vocabulary.EuMetadataRegistry
import org.apache.jena.riot.Lang
import spock.lang.Specification

class DatasetBuilderSpec extends Specification {

    private dataset

    void setup() {
        dataset = DatasetBuilder.builder().organisation('http://organization', 'http://organization/dataset')
    }

    def "Build basic Dataset"() {
        when:
        def build = dataset.build()
        build.write(System.out, Lang.TURTLE.getName())

        then:
        build.size() == 5
    }

    def "Build full Dataset"() {
        given:
        dataset
                .title("Test")
                .description("Test desc")
                .theme(EuMetadataRegistry.DataTheme.ECON)
                .theme(EuMetadataRegistry.DataTheme.GOVE)
                .type("Data")
                .objective("objective")
                .source("source")
                .accessRights(EuMetadataRegistry.AccessRight.NON_PUBLIC)
                .accrualPeriodicity(EuMetadataRegistry.Frequency.CONT)
                .spatial("https://data.geonorge.no/administrativeEnheter/fylke/doc/173156")
                .keyword("keyword1")
                .keyword("keyword2")
                .provenance("Vedtak")
                .legalBasisForRestriction(LegalBasis.of("lov", "lovtittel"))
                .legalBasisForAccess(LegalBasis.of("lov", "lovtittel"))
                .legalBasisForProcessing(LegalBasis.of("lov", "lovtittel"))
                .completeness("completeness")
                .accuracy("accuracy")
                .currentness("currentness")


        when:
        def build = dataset.build()
        build.write(System.out, Lang.TURTLE.getName())

        then:
        build.size() == 56

    }
}
