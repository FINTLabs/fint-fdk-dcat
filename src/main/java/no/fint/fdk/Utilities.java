package no.fint.fdk;

import static no.fint.fdk.Constants.*;

public enum Utilities {

    ;

    public static String getOrganisationResourceURI(String organisationNumber) {
        return String.format(BRREG_NS, organisationNumber);
    }

    public static String getDatasetResourceURI(String organisationNumber, String datasetId) {
        return String.format(FINT_DATASET_NS, organisationNumber, datasetId);
    }

    public static String getCatalogResourceURI(String organisationNumber) {
        return String.format(FINT_CATALOG_NS, organisationNumber);
    }

}
