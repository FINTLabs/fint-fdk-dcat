package no.fint.fdk

import no.fint.fdk.vocabulary.EuMetadataRegistry
import org.apache.jena.riot.Lang
import spock.lang.Specification

class OrganisationDataCatalogBuilderSpec extends Specification {

    private organisation
    private catalog
    private dataset1
    private dataset2

    private orgNum = "123456789"

    void setup() {
        organisation = OrganisationBuilder.builder()
                .organisation(orgNum, "FK")
                .build()

        dataset1 = DatasetBuilder.builder()
                .organisation(orgNum, "1")
                .title("Dataset1")
                .description("Dataset1 description")
                .theme(EuMetadataRegistry.DataTheme.ECON)
                .theme(EuMetadataRegistry.DataTheme.GOVE)
                .type("Data")
                .objective("Used for testing")
                .source("The cat")
                .accessRights(EuMetadataRegistry.AccessRight.NON_PUBLIC)
                .accrualPeriodicity(EuMetadataRegistry.Frequency.CONT)
                .spatial("https://data.geonorge.no/administrativeEnheter/fylke/doc/173156")
                .keyword("cat")
                .keyword("mouse")
                .provenance("Vedtak")
                .legalBasisForRestriction(LegalBasis.of("lov", "lovtittel"))
                .legalBasisForAccess(LegalBasis.of("lov", "lovtittel"))
                .legalBasisForProcessing(LegalBasis.of("lov", "lovtittel"))
                .completeness("Never complete")
                .accuracy("Never accurat")
                .currentness("Never current")
                .build()

        dataset2 = DatasetBuilder.builder()
                .organisation(orgNum, "2")
                .title("Dataset2")
                .description("Dataset2 description")
                .theme(EuMetadataRegistry.DataTheme.ECON)
                .theme(EuMetadataRegistry.DataTheme.GOVE)
                .type("Data")
                .objective("Used for testing")
                .source("The universe")
                .accessRights(EuMetadataRegistry.AccessRight.NON_PUBLIC)
                .accrualPeriodicity(EuMetadataRegistry.Frequency.CONT)
                .spatial("https://data.geonorge.no/administrativeEnheter/fylke/doc/173156")
                .keyword("dog")
                .keyword("cat")
                .provenance("Vedtak")
                .legalBasisForRestriction(LegalBasis.of("lov", "lovtittel"))
                .legalBasisForAccess(LegalBasis.of("lov", "lovtittel"))
                .legalBasisForProcessing(LegalBasis.of("lov", "lovtittel"))
                .completeness("Always complete")
                .accuracy("Always accurat")
                .currentness("Always current")
                .build()

        catalog = CatalogBuilder.builder()
                .organisation(orgNum, "FK")
                .dataset(Utilities.getDatasetResourceURI(orgNum, "1"))
                .dataset(Utilities.getDatasetResourceURI(orgNum, "2"))
                .build()
    }

    def "Get organisation data catalog"() {
        given:
        def odc = OrganisationDataCatalogBuilder.builder().dataCatalog()

        when:
        def build = odc.organisation(organisation)
                .catalog(catalog)
                .dataset(dataset1)
                .dataset(dataset2)
                .build()
        build.write(System.out, Lang.TURTLE.getName())

        then:
        build.size() == 103

    }
}
