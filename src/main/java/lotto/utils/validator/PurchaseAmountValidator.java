package lotto.utils.validator;

import static lotto.exception.ErrorMessages.BEYOND_LIMIT;
import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.PURCHASE_LIMIT;

public class PurchaseAmountValidator implements Validator<String> {

    private final Validator<String> positiveIntValidator;

    public PurchaseAmountValidator(Validator<String> positiveIntValidator) {
        this.positiveIntValidator = positiveIntValidator;
    }

    @Override
    public void validate(String rawPurchaseAmount) {
        positiveIntValidator.validate(rawPurchaseAmount);

        int purchasePrice = Integer.parseInt(rawPurchaseAmount);
        validateDividedByLottoPrice(purchasePrice);
        validateNotBeyondPurchaseLimit(purchasePrice);
    }

    private void validateDividedByLottoPrice (int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE.getValue() != 0){
            throw new IllegalArgumentException();
        }
    }

    private void validateNotBeyondPurchaseLimit (int purchaseAmount) {
        if (purchaseAmount > PURCHASE_LIMIT.getValue()){
            throw new IllegalArgumentException(String.format(BEYOND_LIMIT.getMessage(), PURCHASE_LIMIT));
        }
    }
}
