package org.example.intellij;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.MultipleFailuresError;

public class HighlightingTest {
    @Test
    void underlinesInSameLine() {
        this.throwAFailure();
    }

    @Test
    void noUnderlineInMultiLine() {
        this
            .throwAFailure();
    }

    @Test
    void underlineForComparisonFailure() {
        throwAComparisonFailure();
    }

    @Test
    void underlineForMultiFailure() {
        throwAMultipleFailuresWrappedFailure();
    }

    @Test
    void noUnderlineForMultiComparisonFailure() {
        throwAMultipleFailuresWrappedComparisonFailure();
    }

    private void throwAFailure() {
        throw createAFailure();
    }

    private void throwAComparisonFailure() {
        throw createAComparisonFailure();
    }

    private void throwAMultipleFailuresWrappedFailure() {
        AssertionFailedError aFailure = createAFailure();
        throw new MultipleFailuresError(null, List.of(aFailure));
    }

    private void throwAMultipleFailuresWrappedComparisonFailure() {
        AssertionFailedError aComparisonFailure = createAComparisonFailure();
        throw new MultipleFailuresError(null, List.of(aComparisonFailure));
    }

    private AssertionFailedError createAFailure() {
        return new AssertionFailedError("I have failed");
    }

    private AssertionFailedError createAComparisonFailure() {
        return new AssertionFailedError("I have failed a comparison", 42, 41);
    }
}
