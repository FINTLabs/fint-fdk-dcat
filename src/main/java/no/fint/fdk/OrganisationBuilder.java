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
    }

    public static OrganisationBuilder builder() {
        return new OrganisationBuilder();
    }

    public OrganisationResourceBuilder organisation(String organisationNumber, String organisationName) {
        return new OrganisationResourceBuilder(organisationNumber, organisationName);
    }


    private class OrganisationResourceBuilder {

        private OrganisationResourceBuilder(String organisationNumber, String organisationName) {
            model.createResource(Utilities.getOrganisationResourceURI(organisationNumber))
                    .addProperty(DCTerms.identifier, organisationNumber)
                    .addProperty(RDF.type, FOAF.Agent)
                    .addProperty(FOAF.name, organisationName);
        }

        public Model build() {
            return model;

        }
    }
}
