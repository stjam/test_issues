public class NotBlankValidator implements Validator<String> {
    public boolean isValid(String object) {
        return object != null && object.trim().length() > 0;
    }
}
