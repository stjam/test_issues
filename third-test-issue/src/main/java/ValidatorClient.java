public interface ValidatorClient<T> {
    boolean performValidation(T input);
}
