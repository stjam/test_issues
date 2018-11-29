public class NotNullValidator implements Validator<String> {
    public boolean isValid(String object) {
        return object != null;
    }
}
