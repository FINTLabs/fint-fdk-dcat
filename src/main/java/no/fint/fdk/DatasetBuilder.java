package no.fint.fdk;

import lombok.Data;
import no.fint.fdk.vocabulary.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCAT;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.SKOS;

@Data
public class DatasetBuilder {

    private Model model;
    //private Resource resource;

    private DatasetBuilder() {
        model = ModelFactory.createDefaultModel();
    }

    public static DatasetBuilder builder() {
        return new DatasetBuilder();
    }

    public DatasetResourceBuilder organisation(String organisationNumber, String identifier) {
        return new DatasetResourceBuilder(organisationNumber, identifier);
    }

    private class DatasetResourceBuilder {

        private Resource resource;

        private DatasetResourceBuilder(String organisationNumber, String identifier) {
            resource = model.createResource(Utilities.getDatasetResourceURI(organisationNumber, identifier))
                    .addProperty(RDF.type, DCAT.dataset)
                    .addProperty(DCTerms.language, model.createResource(EuMetadataRegistry.Language.NOR))
                    .addProperty(DCTerms.identifier, identifier)
                    .addProperty(DCTerms.publisher, Utilities.getOrganisationResourceURI(organisationNumber));
        }

        public Model build() {
            return model;
        }

        public DatasetResourceBuilder title(String title) {
            resource.addProperty(DCTerms.title, title, ISO6391.NB);
            return this;
        }

        public DatasetResourceBuilder title(String title, String lang) {
            resource.addProperty(DCTerms.title, title, lang);
            return this;
        }

        public DatasetResourceBuilder description(String description) {
            resource.addProperty(DCTerms.description, description, ISO6391.NB);
            return this;
        }

        public DatasetResourceBuilder description(String description, String lang) {
            resource.addProperty(DCTerms.description, description, lang);
            return this;
        }

        public DatasetResourceBuilder theme(String theme) {
            resource.addProperty(DCAT.theme, theme);
            return this;
        }

        public DatasetResourceBuilder type(String type) {
            resource.addProperty(DCTerms.type, type);
            return this;
        }

        public DatasetResourceBuilder objective(String objective) {
            resource.addProperty(DCATNO.objective, objective);
            return this;
        }

        public DatasetResourceBuilder source(String source) {
            resource.addProperty(DCATNO.source, source);
            return this;
        }

        public DatasetResourceBuilder accessRights(String accessRights) {
            resource.addProperty(DCTerms.accessRights, model.createResource(accessRights));
            return this;
        }

        public DatasetResourceBuilder accrualPeriodicity(String accrualPeriodicity) {
            resource.addProperty(DCTerms.accrualPeriodicity, model.createResource(EuMetadataRegistry.Frequency.CONT));
            return this;
        }

        public DatasetResourceBuilder spatial(String spatial) {
            resource.addProperty(DCTerms.spatial, spatial);
            return this;
        }

        public DatasetResourceBuilder keyword(String keyword) {
            resource.addProperty(DCAT.keyword, keyword, ISO6391.NB);
            return this;
        }

        public DatasetResourceBuilder keyword(String keyword, String lang) {
            resource.addProperty(DCAT.keyword, keyword, lang);
            return this;
        }

        public DatasetResourceBuilder provenance(String provenance) {
            resource.addProperty(DCTerms.provenance, provenance);
            return this;
        }

        public DatasetResourceBuilder legalBasisForRestriction(LegalBasis legalBasis) {
            addLegalBasis(resource, DCATNO.legalBasisForRestriction, legalBasis);
            return this;
        }

        public DatasetResourceBuilder legalBasisForAccess(LegalBasis legalBasis) {
            addLegalBasis(resource, DCATNO.legalBasisForAccess, legalBasis);
            return this;
        }

        public DatasetResourceBuilder legalBasisForProcessing(LegalBasis legalBasis) {
            addLegalBasis(resource, DCATNO.legalBasisForProcessing, legalBasis);
            return this;
        }

        public DatasetResourceBuilder completeness(String completeness) {
            addQualityAnnotation(resource, DQV.Completeness, completeness);
            return this;
        }

        public DatasetResourceBuilder accuracy(String accuracy) {
            addQualityAnnotation(resource, DQV.Accuracy, accuracy);
            return this;
        }

        public DatasetResourceBuilder currentness(String currentness) {
            addQualityAnnotation(resource, DQV.Currentness, currentness);
            return this;
        }

        private void addLegalBasis(Resource resource, Property property, LegalBasis legalBasis) {
            addLegalBasis(resource, property, legalBasis, ISO6391.NB);
        }

        private void addLegalBasis(Resource resource, Property property, LegalBasis legalBasis, String lang) {
            resource.addProperty(property,
                    model.createResource()
                            .addProperty(RDF.type, SKOS.Concept)
                            .addProperty(RDF.type, DCTerms.RightsStatement)
                            .addProperty(DCTerms.source, legalBasis.getSource())
                            .addProperty(SKOS.prefLabel, legalBasis.getLabel(), lang)
            );
        }

        private void addQualityAnnotation(Resource resource, Resource type, String value) {
            resource.addProperty(DQV.hasQualityAnnotation,
                    model.createResource(DQV.QualityAnnotation)
                            .addProperty(DQV.inDimension, type)
                            .addProperty(OA.hasBody, model.createResource()
                                    .addProperty(
                                            RDF.value, value)
                            )
            );
        }

    }
}
