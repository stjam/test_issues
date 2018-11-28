public class NotNullValidator implements Validation<String> {

    public boolean validate(String object) {
        return object != null;
    }
}
