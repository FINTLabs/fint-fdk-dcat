package no.fint.fdk.vocabulary;

/**
 * http://publications.europa.eu/mdr/authority/index.html
 */

public class EuMetadataRegistry {

    public enum DataTheme {
        ;
        public static final String GOVE = "http://publications.europa.eu/resource/authority/data-themes/GOVE";
        public static final String REGI = "http://publications.europa.eu/resource/authority/data-themes/REGI";
        public static final String AGRI = "http://publications.europa.eu/resource/authority/data-themes/AGRI";
        public static final String ECON = "http://publications.europa.eu/resource/authority/data-themes/ECON";
        public static final String EDUC = "http://publications.europa.eu/resource/authority/data-themes/EDUC";
        public static final String ENER = "http://publications.europa.eu/resource/authority/data-themes/ENER";
        public static final String ENVI = "http://publications.europa.eu/resource/authority/data-themes/ENVI";
        public static final String HEAL = "http://publications.europa.eu/resource/authority/data-themes/HEAL";
        public static final String INTR = "http://publications.europa.eu/resource/authority/data-themes/INTR";
        public static final String JUST = "http://publications.europa.eu/resource/authority/data-themes/JUST";
        public static final String SOCI = "http://publications.europa.eu/resource/authority/data-themes/SOCI";
        public static final String TECH = "http://publications.europa.eu/resource/authority/data-themes/TECH";
        public static final String TRAN = "http://publications.europa.eu/resource/authority/data-themes/TRAN";
    }

    public enum Language {
        ;
        public static final String NOR = "http://publications.europa.eu/resource/authority/language/NOR";
    }

    public enum AccessRight {
        ;
        public static final String NON_PUBLIC = "http://publications.europa.eu/resource/authority/access-right/NON_PUBLIC";
        public static final String PUBLIC = "http://publications.europa.eu/resource/authority/access-right/PUBLIC";
        public static final String RESTRICTED = "http://publications.europa.eu/resource/authority/access-right/RESTRICTED";
    }

    /**
     * http://publications.europa.eu/mdr/resource/authority/frequency/html/frequencies-eng.html
     */
    public enum Frequency {
        ;
        public static final String CONT = "http://publications.europa.eu/resource/authority/frequency/CONT";
        public static final String ANNUAL = "http://publications.europa.eu/resource/authority/frequency/ANNUAL";
        public static final String ANNUAL_2 = "http://publications.europa.eu/resource/authority/frequency/ANNUAL_2";
        public static final String ANNUAL_3 = "http://publications.europa.eu/resource/authority/frequency/ANNUAL_3";
        public static final String BIENNIAL = "http://publications.europa.eu/resource/authority/frequency/BIENNIAL";
        public static final String BIMONTHLY = "http://publications.europa.eu/resource/authority/frequency/BIMONTHLY";
        public static final String BIWEEKLY = "http://publications.europa.eu/resource/authority/frequency/BIWEEKLY";
        public static final String DAILY = "http://publications.europa.eu/resource/authority/frequency/DAILY";
        public static final String DAILY_2 = "http://publications.europa.eu/resource/authority/frequency/DAILY_2";
        public static final String IRREG = "http://publications.europa.eu/resource/authority/frequency/IRREG";
        public static final String MONTHLY = "http://publications.europa.eu/resource/authority/frequency/MONTHLY";
        public static final String MONTHLY_2 = "http://publications.europa.eu/resource/authority/frequency/MONTHLY_2";
        public static final String MONTHLY_3 = "http://publications.europa.eu/resource/authority/frequency/MONTHLY_3";
        public static final String NEVER = "http://publications.europa.eu/resource/authority/frequency/NEVER";
        public static final String OTHER = "http://publications.europa.eu/resource/authority/frequency/OTHER";
        public static final String QUARTERLY = "http://publications.europa.eu/resource/authority/frequency/QUARTERLY";
        public static final String TRIENNIAL = "http://publications.europa.eu/resource/authority/frequency/TRIENNIAL";
        public static final String UNKNOWN = "http://publications.europa.eu/resource/authority/frequency/UNKNOWN";
        public static final String UPDATE_CONT = "http://publications.europa.eu/resource/authority/frequency/UPDATE_CONT";
        public static final String WEEKLY = "http://publications.europa.eu/resource/authority/frequency/WEEKLY";
        public static final String WEEKLY_2 = "http://publications.europa.eu/resource/authority/frequency/WEEKLY_2";
        public static final String WEEKLY_3 = "http://publications.europa.eu/resource/authority/frequency/WEEKLY_3";
    }
}
