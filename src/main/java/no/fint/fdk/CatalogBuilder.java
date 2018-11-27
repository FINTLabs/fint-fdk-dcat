package no.fint.fdk;

import lombok.Data;
import no.fint.fdk.vocabulary.ISO6391;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCAT;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDF;

@Data
public class CatalogBuilder {

    private Model model;

    private CatalogBuilder() {
        model = ModelFactory.createDefaultModel();
    }

    public static CatalogBuilder builder() {
        return new CatalogBuilder();
    }

    public CatalogResourceBuilder organisation(String organisationNumber, String organisationName) {
        return new CatalogResourceBuilder(organisationNumber, organisationName);
    }

    public CatalogResourceBuilder organisation(String organisationNumber, String organisationName, String lang) {
        return new CatalogResourceBuilder(organisationNumber, organisationName, lang);
    }

    private class CatalogResourceBuilder {
        private Resource resource;

        private CatalogResourceBuilder(String organisationNumber, String organisationName, String lang) {
            init(organisationNumber, organisationName, lang);
        }

        private CatalogResourceBuilder(String organisationNumber, String organisationName) {
           init(organisationNumber, organisationName, ISO6391.NB);
        }

        private void init(String organisationNumber, String organisationName, String lang) {
            resource = model.createResource(Utilities.getCatalogResourceURI(organisationNumber))
                    .addProperty(RDF.type, DCAT.Catalog)
                    .addProperty(DCTerms.title, String.format("Datakatalog for %s", organisationName), lang)
                    .addProperty(DCTerms.description, String.format("Datakatalog for %s", organisationName), lang);
        }


        public CatalogResourceBuilder dataset(String dataset) {
            resource.addProperty(DCAT.dataset, model.createResource(dataset));
            return this;
        }

        public Model build() {
            return model;
        }
    }


}
