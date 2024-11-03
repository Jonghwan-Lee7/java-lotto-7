package lotto.utils.validator;

import java.util.List;

public interface ComparisonValidator extends Validator<String> {
    void validateWithComparison(String validationTarget, List<Integer> comparisons);
}