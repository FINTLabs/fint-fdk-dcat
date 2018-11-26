package no.fint.fdk;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class LegalBasis {
    private String source;
    private String label;
}
