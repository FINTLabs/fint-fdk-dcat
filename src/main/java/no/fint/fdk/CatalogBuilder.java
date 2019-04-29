package no.fint.fdk;

import lombok.Data;
import no.fint.fdk.vocabulary.ISO6391;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.DCAT;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDF;

@Data
public class CatalogBuilder {

    private Model model;

    private CatalogBuilder() {
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

    public static CatalogBuilder builder() {
        return new CatalogBuilder();
    }

    public CatalogResourceBuilder organisation(String organizationResourceURI) {
        return new CatalogResourceBuilder(organizationResourceURI);
    }

    public CatalogResourceBuilder organisation(String lang, String organizationResourceURI) {
        return new CatalogResourceBuilder(lang, organizationResourceURI);
    }

    public class CatalogResourceBuilder {
        private final Resource resource;
        private final String lang;

        private CatalogResourceBuilder(String lang, String organizationResourceURI) {
            this.lang = lang;
            resource = model.createResource(organizationResourceURI)
                    .addProperty(RDF.type, DCAT.Catalog);
        }

        private CatalogResourceBuilder(String organizationResourceURI) {
            this(ISO6391.NB, organizationResourceURI);
        }

        public CatalogResourceBuilder title(String title) {
            resource.addProperty(DCTerms.title, title, lang);
            return this;
        }

        public CatalogResourceBuilder description(String description) {
            resource.addProperty(DCTerms.description, description, lang);
            return this;
        }

        public CatalogResourceBuilder publisher(String publisher, String name) {
            resource.addProperty(DCTerms.publisher, model.createResource(publisher).addProperty(RDF.type, FOAF.Agent).addProperty(FOAF.name, name));
            return this;
        }

        public CatalogResourceBuilder dataset(String dataset) {
            resource.addProperty(DCAT.dataset, model.createResource(dataset));
            return this;
        }

        /*

        TODO: Check required RDF types for these
        public CatalogResourceBuilder language(String language) {
            resource.addProperty(DCTerms.language, model.createResource(language));
            return this;
        }

        public CatalogResourceBuilder type(String type) {
            resource.addProperty(DCTerms.type, model.createResource(type));
            return this;
        }
         */

        public Model build() {
            return model;
        }
    }


}
