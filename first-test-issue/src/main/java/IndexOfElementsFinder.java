import java.util.Arrays;
import java.util.Optional;

/**
 * Утильный класс для поиска индексов в массиве
 */
public final class IndexOfElementsFinder {
    /**
     * @param array  массив целых чисел
     * @param target сумма
     * @return возвращает объект результатов поиска
     */
    public static Optional<SearchResult> findIndexesOfElements(int[] array, int target) {
        if (array.length == 0) {
            return Optional.empty();
        }
        Arrays.sort(array);
        int firstIndex = 0;
        int secondIndex = array.length - 1;
        while (firstIndex != secondIndex) {
            if ((array[firstIndex] + array[secondIndex]) == target)
                return Optional.of(new SearchResult(firstIndex, secondIndex));
            if ((array[firstIndex] + array[secondIndex]) < target) {
                firstIndex++;
            } else if ((array[firstIndex] + array[secondIndex]) > target) {
                secondIndex--;
            }
        }
        return Optional.empty();
    }

}
