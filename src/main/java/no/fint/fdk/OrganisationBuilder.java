package no.fint.fdk;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDF;

public class OrganisationBuilder {


    private Model model;

    private OrganisationBuilder() {
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

    public static OrganisationBuilder builder() {
        return new OrganisationBuilder();
    }

    public OrganisationResourceBuilder organisation(String organisationNumber, String organisationName, String organizationResourceURI) {
        return new OrganisationResourceBuilder(organisationNumber, organisationName, organizationResourceURI);
    }


    public class OrganisationResourceBuilder {

        private OrganisationResourceBuilder(String organisationNumber, String organisationName, String organizationResourceURI) {
            model.createResource(organizationResourceURI)
                    .addProperty(DCTerms.identifier, organisationNumber)
                    .addProperty(RDF.type, FOAF.Agent)
                    .addProperty(FOAF.name, organisationName);
        }

        public Model build() {
            return model;

        }
    }
}
