package no.fint.fdk.vocabulary;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;

public class OA {
    public static final String NS = "http://www.w3.org/ns/prov#";
    private static final Model model = ModelFactory.createDefaultModel();
    public static final Property hasBody = model.createProperty(NS, "hasBody");

}

