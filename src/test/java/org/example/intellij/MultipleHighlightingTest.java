package org.example.intellij;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.MultipleFailuresError;

public class MultipleHighlightingTest {
    @Test
    void multipleAssertionFailed() {
        AssertionFailedError aFailure1 = createAFailure();
        AssertionFailedError aFailure2 = createAFailure();

        List<AssertionFailedError> failures = List.of(aFailure1, aFailure2);
        throw new MultipleFailuresError(null, failures);
    }

    @Test
    void multipleSoftAssertions() {
        SoftAssertions softly = new SoftAssertions();
        softly.collectAssertionError(createAFailure());
        softly.collectAssertionError(createAFailure());
        softly.assertAll();
    }

    private AssertionFailedError createAFailure() {
        return new AssertionFailedError("I have failed");
    }
}
