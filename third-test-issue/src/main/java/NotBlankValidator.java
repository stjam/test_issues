public class NotBlankValidator implements Validation<String> {

    public boolean validate(String object) {
        return object != null && object.trim().length() > 0;
    }
}
