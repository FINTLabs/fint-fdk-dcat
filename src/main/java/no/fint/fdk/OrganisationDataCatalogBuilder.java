package no.fint.fdk;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class OrganisationDataCatalogBuilder {

    private Model model;

    private OrganisationDataCatalogBuilder() {
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

    public static OrganisationDataCatalogBuilder builder() {
        return new OrganisationDataCatalogBuilder();
    }

    public OrganisationDataCatalogModelBuilder dataCatalog() {
        return new OrganisationDataCatalogModelBuilder();
    }

    public class OrganisationDataCatalogModelBuilder {

        public OrganisationDataCatalogModelBuilder organisation(Model organisation) {
            model.add(organisation);
            return this;
        }

        public OrganisationDataCatalogModelBuilder catalog(Model catalog) {
            model.add(catalog);
            return this;
        }

        public OrganisationDataCatalogModelBuilder dataset(Model ds) {
            model.add(ds);
            return this;
        }

        public Model build() {
            return model;
        }
    }


}
