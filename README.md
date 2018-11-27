# FINT Felles Datakatalog DCAT bibliotek
Bibliotek for å bygge DCAT modeller for integrasjon med Felles Datakatalog. Se [https://fellesdatakatalog.brreg.no](https://fellesdatakatalog.brreg.no)

## Installation

## Usage

**Organisation**
```java
Model rfk = OrganisationBuilder.builder().organisation("971045698", "RFK").build();
rfk.write(System.out, Lang.TURTLE.getName());

```

**Catalog**
```java
Model rfkCatalog = CatalogBuilder.builder().organisation("971045698", "RFK").build()
rfkCatalog.write(System.out, Lang.TURTLE.getName());
```

**Dataset**
```java
Model rfkDataset = DatasetBuilder.builder().organisation("12345", "1234")
    .title("Test")
    .description("Test desc")
    .theme(EuMetadataRegistry.DataTheme.ECON)
    .theme(EuMetadataRegistry.DataTheme.GOVE)
    .type("Data")
    .objective("objective")
    .source("source")
    .accessRights(EuMetadataRegistry.AccessRight.NON_PUBLIC)
    .accrualPeriodicity(EuMetadataRegistry.Frequency.CONT)
    .spatial("https://data.geonorge.no/administrativeEnheter/fylke/doc/173156")
    .keyword("keyword1")
    .keyword("keyword2")
    .provenance("Vedtak")
    .legalBasisForRestriction(LegalBasis.of("lov", "lovtittel"))
    .legalBasisForAccess(LegalBasis.of("lov", "lovtittel"))
    .legalBasisForProcessing(LegalBasis.of("lov", "lovtittel"))
    .completeness("completeness")
    .accuracy("accuracy")
    .currentness("currentness")
    .build();
rfkDataset.write(System.out, Lang.TURTLE.getName());

```

**Organisation data catalog**
```java
Model rfkDataCatalog = OrganisationDataCatalogBuilder.builder().dataCatalog()
    .organisation(organisation)
    .catalog(catalog)
    .dataset(dataset1)
    .dataset(dataset2)
    .build();
build.write(System.out, Lang.TURTLE.getName());

```

**Example output (Turtle)**
```ttl
@prefix schema: <http://schema.org/> .
@prefix iso:   <http://iso.org/25012/2008/dataquality/> .
@prefix spdx:  <http://spdx.org/rdf/terms#> .
@prefix adms:  <http://www.w3.org/ns/adms#> .
@prefix owl:   <http://www.w3.org/2002/07/owl#> .
@prefix dqv:   <http://www.w3.org/ns/dqv#> .
@prefix xsd:   <http://www.w3.org/2001/XMLSchema#> .
@prefix skos:  <http://www.w3.org/2004/02/skos/core#> .
@prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#> .
@prefix vcard: <http://www.w3.org/2006/vcard/ns#> .
@prefix oa:    <http://www.w3.org/ns/prov#> .
@prefix dct:   <http://purl.org/dc/terms/> .
@prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
@prefix dcatno: <http://difi.no/dcatno#> .
@prefix dcat:  <http://www.w3.org/ns/dcat#> .
@prefix foaf:  <http://xmlns.com/foaf/0.1/> .

<http://data.felleskomponent.no/123456789/dataset/1>
        a                               dcat:dataset ;
        dcatno:legalBasisForAccess      [ a               skos:Concept , dct:RightsStatement ;
                                          dct:source      "lov" ;
                                          skos:prefLabel  "lovtittel"@nb
                                        ] ;
        dcatno:legalBasisForProcessing  [ a               skos:Concept , dct:RightsStatement ;
                                          dct:source      "lov" ;
                                          skos:prefLabel  "lovtittel"@nb
                                        ] ;
        dcatno:legalBasisForRestriction
                [ a               skos:Concept , dct:RightsStatement ;
                  dct:source      "lov" ;
                  skos:prefLabel  "lovtittel"@nb
                ] ;
        dcatno:objective                "Used for testing" ;
        dcatno:source                   "The cat" ;
        dct:accessRights                <http://publications.europa.eu/resource/authority/access-right/NON_PUBLIC> ;
        dct:accrualPeriodicity          <http://publications.europa.eu/resource/authority/frequency/CONT> ;
        dct:description                 "Dataset1 description"@nb ;
        dct:identifier                  "1" ;
        dct:language                    <http://publications.europa.eu/resource/authority/language/NOR> ;
        dct:provenance                  "Vedtak" ;
        dct:publisher                   "http://data.brreg.no/enhetsregisteret/enhet/123456789" ;
        dct:spatial                     "https://data.geonorge.no/administrativeEnheter/fylke/doc/173156" ;
        dct:title                       "Dataset1"@nb ;
        dct:type                        "Data" ;
        dcat:keyword                    "cat"@nb , "mouse"@nb ;
        dcat:theme                      "http://publications.europa.eu/resource/authority/data-themes/GOVE" , "http://publications.europa.eu/resource/authority/data-themes/ECON" ;
        dqv:hasQualityAnnotation        [ a                dqv:QualityAnnotation ;
                                          dqv:inDimension  iso:Currentness ;
                                          oa:hasBody       [ rdf:value  "Never current" ]
                                        ] ;
        dqv:hasQualityAnnotation        [ a                dqv:QualityAnnotation ;
                                          dqv:inDimension  iso:Completeness ;
                                          oa:hasBody       [ rdf:value  "Never complete" ]
                                        ] ;
        dqv:hasQualityAnnotation        [ a                dqv:QualityAnnotation ;
                                          dqv:inDimension  iso:Accuracy ;
                                          oa:hasBody       [ rdf:value  "Never accurat" ]
                                        ] .

<http://data.felleskomponent.no/123456789/catalog>
        a                dcat:Catalog ;
        dct:description  "Datakatalog for FK"@nb ;
        dct:title        "Datakatalog for FK"@nb ;
        dcat:dataset     <http://data.felleskomponent.no/123456789/dataset/1> , <http://data.felleskomponent.no/123456789/dataset/2> .

<http://data.brreg.no/enhetsregisteret/enhet/123456789>
        a               foaf:Agent ;
        dct:identifier  "123456789" ;
        foaf:name       "FK" .

<http://data.felleskomponent.no/123456789/dataset/2>
        a                               dcat:dataset ;
        dcatno:legalBasisForAccess      [ a               skos:Concept , dct:RightsStatement ;
                                          dct:source      "lov" ;
                                          skos:prefLabel  "lovtittel"@nb
                                        ] ;
        dcatno:legalBasisForProcessing  [ a               skos:Concept , dct:RightsStatement ;
                                          dct:source      "lov" ;
                                          skos:prefLabel  "lovtittel"@nb
                                        ] ;
        dcatno:legalBasisForRestriction
                [ a               skos:Concept , dct:RightsStatement ;
                  dct:source      "lov" ;
                  skos:prefLabel  "lovtittel"@nb
                ] ;
        dcatno:objective                "Used for testing" ;
        dcatno:source                   "The universe" ;
        dct:accessRights                <http://publications.europa.eu/resource/authority/access-right/NON_PUBLIC> ;
        dct:accrualPeriodicity          <http://publications.europa.eu/resource/authority/frequency/CONT> ;
        dct:description                 "Dataset2 description"@nb ;
        dct:identifier                  "2" ;
        dct:language                    <http://publications.europa.eu/resource/authority/language/NOR> ;
        dct:provenance                  "Vedtak" ;
        dct:publisher                   "http://data.brreg.no/enhetsregisteret/enhet/123456789" ;
        dct:spatial                     "https://data.geonorge.no/administrativeEnheter/fylke/doc/173156" ;
        dct:title                       "Dataset2"@nb ;
        dct:type                        "Data" ;
        dcat:keyword                    "cat"@nb , "dog"@nb ;
        dcat:theme                      "http://publications.europa.eu/resource/authority/data-themes/ECON" , "http://publications.europa.eu/resource/authority/data-themes/GOVE" ;
        dqv:hasQualityAnnotation        [ a                dqv:QualityAnnotation ;
                                          dqv:inDimension  iso:Accuracy ;
                                          oa:hasBody       [ rdf:value  "Always accurat" ]
                                        ] ;
        dqv:hasQualityAnnotation        [ a                dqv:QualityAnnotation ;
                                          dqv:inDimension  iso:Completeness ;
                                          oa:hasBody       [ rdf:value  "Always complete" ]
                                        ] ;
        dqv:hasQualityAnnotation        [ a                dqv:QualityAnnotation ;
                                          dqv:inDimension  iso:Currentness ;
                                          oa:hasBody       [ rdf:value  "Always current" ]
                                        ] .

```

## References

* [Veileder for beskrivelse av datasett](https://doc.difi.no/veiledere/veileder-for-beskrivelse-av-datasett/)
* [Standard for beskrivelse av datasett og datakataloger (DCAT-AP-NO)](https://doc.difi.no/dcat-ap-no/)
* [Felles datakatalog](https://fellesdatakatalog.brreg.no)
