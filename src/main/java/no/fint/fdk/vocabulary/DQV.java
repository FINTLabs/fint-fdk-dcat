package no.fint.fdk.vocabulary;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class DQV {
    private static Logger logger = LoggerFactory.getLogger(DQV.class);

    private static final Model model = ModelFactory.createDefaultModel();

    public static final String NS = "http://www.w3.org/ns/dqv#";
    public static final String ISO = "http://iso.org/25012/2008/dataquality/"; // TODO - this is not an official uri

    public static final Property hasQualityAnnotation = model.createProperty(NS, "hasQualityAnnotation");
    public static final Property inDimension = model.createProperty(NS, "inDimension");

    public static final Resource QualityAnnotation = model.createResource(DQV.NS + "QualityAnnotation");

    public static final Resource Accuracy = model.createResource(ISO + "Accuracy");
    public static final Resource Availability = model.createResource(ISO + "Availability");
    public static final Resource Completeness = model.createResource(ISO + "Completeness");
    public static final Resource Currentness = model.createResource(ISO + "Currentness");
    public static final Resource Relevance = model.createResource(ISO + "Relevance");

    public static final Resource[] dimensions = {Accuracy, Availability, Completeness, Currentness, Relevance};

    public static final Resource resolveDimensionResource(String dimension) {

        if (dimension == null) {
            return null;
        }

        if (dimension.startsWith("iso:")) {
            dimension = dimension.replace("iso:", ISO);
        }

        final String dimensionUri = dimension;

        try {
            return Arrays.stream(dimensions).filter(dim -> dim.getURI().equals(dimensionUri)).findFirst().get();
        } catch (Exception e) {
            logger.warn("Cannot resolve dimension resource with uri: {}", dimension);
            return null;
        }

    }
}

//
//
//import org.apache.jena.rdf.model.Model;
//import org.apache.jena.rdf.model.ModelFactory;
//import org.apache.jena.rdf.model.Property;
//import org.apache.jena.rdf.model.Resource;
//
///**
// * Vocabulary definition for the <a href="https://www.w3.org/TR/vocab-dqv/">Data Quality vocabulary</a>.
// *
// * @see <a href="https://github.com/w3c/dwbp/blob/gh-pages/dqv.ttl">Turtle specification</a>
// *
// * https://github.com/FranckCo/SDMX-Metadata/blob/master/src/main/java/fr/insee/stamina/utils/DQV.java
// */
//public class DQV {
//	/**
//	 * The RDF model that holds the DQV entities
//	 */
//	public static Model model = ModelFactory.createDefaultModel();
//	/**
//	 * The namespace of the DQV vocabulary as a string
//	 */
//	public static final String uri = "http://www.w3.org/ns/dqv#";
//	/**
//	 * Returns the namespace of the DQV vocabulary as a string
//	 * @return the namespace of the DQV vocabulary
//	 */
//	public static String getURI() {
//		return uri;
//	}
//	/**
//	 * The namespace of the DQV vocabulary
//	 */
//	public static final Resource NAMESPACE = model.createResource(uri);
//	/* ##########################################################
//	 * Defines DQV Classes
//	   ########################################################## */
//
//	public static final Resource Category = model.createResource(uri + "Category");
//	public static final Resource Dimension = model.createResource(uri + "Dimension");
//	public static final Resource Metric = model.createResource(uri + "Metric");
//	public static final Resource QualityAnnotation = model.createResource(uri + "QualityAnnotation");
//	public static final Resource QualityCertificate = model.createResource(uri + "QualityCertificate");
//	public static final Resource QualityMeasurement = model.createResource(uri + "QualityMeasurement");
//	public static final Resource QualityMeasurementDataset = model.createResource(uri + "QualityMeasurementDataset");
//	public static final Resource QualityMetadata = model.createResource(uri + "QualityMetadata");
//	public static final Resource QualityPolicy = model.createResource(uri + "QualityPolicy");
//	public static final Resource UserQualityFeedback = model.createResource(uri + "UserQualityFeedback");
//	/* ##########################################################
//	 * Defines DQV Properties
//	   ########################################################## */
//	// DQV object properties
//	public static final Property computedOn = model.createProperty(uri + "computedOn");
//	public static final Property expectedDataType = model.createProperty(uri + "expectedDataType");
//	public static final Property inCategory = model.createProperty(uri + "inCategory");
//	public static final Property inDimension = model.createProperty(uri + "inDimension");
//	public static final Property isMeasurementOf = model.createProperty(uri + "isMeasurementOf");
//	public static final Property hasQualityAnnotation = model.createProperty(uri + "hasQualityAnnotation");
//	public static final Property hasQualityMeasurement = model.createProperty(uri + "hasQualityMeasurement");
//	public static final Property hasQualityMetadata = model.createProperty(uri + "hasQualityMetadata");
//	public static final Property value = model.createProperty(uri + "value");
//}
