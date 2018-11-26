package no.fint.fdk.vocabulary;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;

/**
 * Created by bjg on 11.11.2016.
 * Norwegian extensions to DCAT standard
 * https://doc.difi.no/dcat-ap-no
 */
public class DCATNO {
    public static final String NS = "http://difi.no/dcatno#";
    private static final Model model = ModelFactory.createDefaultModel();
    public static final Property source = model.createProperty(NS, "source");
    public static final Property accessRightsComment = model.createProperty(NS, "accessRightsComment");
    public static final Property objective = model.createProperty(NS, "objective");
    public static final Property legalBasisForProcessing = model.createProperty(NS, "legalBasisForProcessing");
    public static final Property legalBasisForRestriction = model.createProperty(NS, "legalBasisForRestriction");
    public static final Property legalBasisForAccess = model.createProperty(NS, "legalBasisForAccess");
    public static final Property informationModel = model.createProperty(NS, "informationModel");
    public static final Property organizationPath = model.createProperty(NS, "organizationPath");

    public static String getURI() {
        return NS;
    }
}