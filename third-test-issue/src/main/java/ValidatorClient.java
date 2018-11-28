public class ValidatorClient {
    private String string;

    public boolean notBlankValidation() {
        return new NotBlankValidator().validate(this.string);
    }

    public boolean notNullValidation() {
        return new NotBlankValidator().validate(this.string);
    }
}
