import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SearchResultTest {

    private val searchResult = makeTestee()

    @Test
    fun `constuctor test`() {
        val searchResult = SearchResult(0, 1);
        assertThat(searchResult.firstIndex).isEqualTo(0)
        assertThat(searchResult.secondIndex).isEqualTo(1)
    }

    @Test
    fun `equals() correctness`() {
        assertThat(searchResult).isEqualTo(searchResult)
        assertThat(searchResult).isNotEqualTo(SearchResult(2, 1))
        assertThat(searchResult).isNotEqualTo(SearchResult(1, 0))
    }

    @Test
    fun `hashCode() correctness`() {
        assertThat(searchResult.hashCode()).isEqualTo(SearchResult(0, 1).hashCode())
        assertThat(searchResult.hashCode()).isEqualTo(searchResult.hashCode())
        assertThat(searchResult.hashCode()).isNotEqualTo(SearchResult(2, 1).hashCode())
    }

    @Test
    fun `toString() correctness`() {
        assertThat(searchResult.toString()).isEqualTo("SearchResult(firstIndex=0, secondIndex=1)")
        assertThat(searchResult.toString()).isNotEqualTo(SearchResult(1, 1).toString())
    }

    private fun makeTestee(): SearchResult {
        return SearchResult(0, 1);
    }
}