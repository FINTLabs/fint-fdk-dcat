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

        model.setNsPrefix("adms", "http://www.w3.org/ns/adms#");
        model.setNsPrefix("dcat", "http://www.w3.org/ns/dcat#");
        model.setNsPrefix("dct", "http://purl.org/dc/terms/");
        model.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
        model.setNsPrefix("owl", "http://www.w3.org/2002/07/owl#");
        model.setNsPrefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
        model.setNsPrefix("schema", "http://schema.org/");
        model.setNsPrefix("skos", "http://www.w3.org/2004/02/skos/core#");
        model.setNsPrefix("spdx", "http://spdx.org/rdf/terms#");
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
        model.setNsPrefix("vcard", "http://www.w3.org/2006/vcard/ns#");
        model.setNsPrefix("dqv", "http://www.w3.org/ns/dqv#");
        model.setNsPrefix("iso", "http://iso.org/25012/2008/dataquality/");
        model.setNsPrefix("oa", "http://www.w3.org/ns/prov#");
        model.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        model.setNsPrefix("dcatno", "http://difi.no/dcatno#");
    }

    public static DatasetBuilder builder() {
        return new DatasetBuilder();
    }

    public DatasetResourceBuilder organisation(String organizationResourceURI, String datasetResourceURI) {
        return new DatasetResourceBuilder(organizationResourceURI, datasetResourceURI);
    }

    public class DatasetResourceBuilder {

        private Resource resource;

        private DatasetResourceBuilder(String organizationResourceURI, String datasetResourceURI) {
            resource = model.createResource(datasetResourceURI)
                    .addProperty(RDF.type, DCAT.Dataset)
                    .addProperty(DCTerms.language, model.createResource(EuMetadataRegistry.Language.NOR))
                    .addProperty(DCTerms.identifier, datasetResourceURI)
                    .addProperty(DCTerms.publisher,
                            model.createResource(organizationResourceURI));
        }

        public Model build() {
            return model;
        }

        public DatasetResourceBuilder title(String title) {
            return this.title(title, ISO6391.NB);
        }

        public DatasetResourceBuilder title(String title, String lang) {
            resource.addProperty(DCTerms.title, title, lang);
            return this;
        }

        public DatasetResourceBuilder description(String description) {
            return this.description(description, ISO6391.NB);
        }

        public DatasetResourceBuilder description(String description, String lang) {
            resource.addProperty(DCTerms.description, description, lang);
            return this;
        }

        public DatasetResourceBuilder theme(String theme) {
            resource.addProperty(DCAT.theme, model.createResource(theme));
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
            resource.addProperty(DCTerms.accrualPeriodicity, model.createResource(accrualPeriodicity));
            return this;
        }

        public DatasetResourceBuilder spatial(String spatial) {
            resource.addProperty(DCTerms.spatial, model.createResource(spatial));
            return this;
        }

        public DatasetResourceBuilder keyword(String keyword) {
            return this.keyword(keyword, ISO6391.NB);
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
