public class StringValidatorClient implements ValidatorClient<String>  {

    private Validator<String> validator;

    public boolean performValidation(final String string) {
        return validator.isValid(string);
    }

    public void setValidator(final Validator<String> validator) {
        this.validator = validator;
    }
}
