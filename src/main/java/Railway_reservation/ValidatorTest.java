package Railway_reservation;

 import org.junit.Test;

 import static org.junit.Assert.assertFalse;
 import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test

    public boolean testEmailFormat(String email) {
        String pattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(pattern);
    }
    @Test
    public void testIsValidCardNumber() {

        ValidatorTest validatorTest = new ValidatorTest();

        String validCardNumber = "1234567890123456";
        String invalidCardNumber1 = "123456789012345";
        String invalidCardNumber2 = "123456789012345a";

        assertTrue(validatorTest.isValidCardNumber(validCardNumber));
        assertFalse(validatorTest.isValidCardNumber(invalidCardNumber1));
        assertFalse(validatorTest.isValidCardNumber(invalidCardNumber2));
    }

    public boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() != 16) {
            return false;
        }
        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void testIsValidNameOfCard() {
        ValidatorTest validatorTest = new ValidatorTest();

        String validNameOfCard = "Eman Mhmd";
        String invalidNameOfCard1 = "EmanMhmd1";
        String invalidNameOfCard2 = "Eman@Mhmd";

        assertTrue(validatorTest.isValidNameOfCard(validNameOfCard));
        assertFalse(validatorTest.isValidNameOfCard(invalidNameOfCard1));
        assertFalse(validatorTest.isValidNameOfCard(invalidNameOfCard2));
    }

    public boolean isValidNameOfCard(String nameOfCard) {
        if (!nameOfCard.matches("[a-zA-Z ]+")) {
            return false;
        }
        return true;
    }

    @Test
    public void testIsValidExpiryDate() {
        ValidatorTest validatorTest = new ValidatorTest();

        String validExpiryDate = "12/24";
        String invalidExpiryDate1 = "13/24";
        String invalidExpiryDate2 = "12/2024";
        String invalidExpiryDate3 = "12/24a";

        assertTrue(validatorTest.isValidExpiryDate(validExpiryDate));
        assertFalse(validatorTest.isValidExpiryDate(invalidExpiryDate1));
        assertFalse(validatorTest.isValidExpiryDate(invalidExpiryDate2));
       assertFalse(validatorTest.isValidExpiryDate(invalidExpiryDate3));
    }

    public boolean isValidExpiryDate(String expiryDate) {
        if (!expiryDate.matches("(0[1-9]|1[0-2])/[0-9]{2}")) {
            return false;
        }
        return true;
    }

    @Test
    public void testIsValidCVCCode() {
        ValidatorTest validatorTest = new ValidatorTest();

        String validCVCCode = "123";
        String invalidCVCCode1 = "12";
        String invalidCVCCode2 = "1234";
        String invalidCVCCode3 = "123a";

        assertTrue(validatorTest.isValidCVCCode(validCVCCode));
        assertFalse(validatorTest.isValidCVCCode(invalidCVCCode1));
        assertFalse(validatorTest.isValidCVCCode(invalidCVCCode2));
        assertFalse(validatorTest.isValidCVCCode(invalidCVCCode3));
    }

    public boolean isValidCVCCode(String cvcCode) {
        if (!cvcCode.matches("[0-9]{3}")) {
            return false;
        }
        return true;
    }
}

