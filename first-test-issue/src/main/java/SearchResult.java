import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class SearchResult {

    private final Integer firstIndex;

    private final Integer secondIndex;

}
