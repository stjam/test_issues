import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*


class IndexOfElementsFinderTest {

    private val x: IntArray = intArrayOf(1, 2, 3, 4)
    private val searchResult = makeTestee()

    @Test
    fun `When indexes exist in array`() {
        val searchResult1 = IndexOfElementsFinder.findIndexesOfElements(x, 3)
        assertThat(searchResult1.get().firstIndex).isEqualTo(searchResult.get().firstIndex)
        assertThat(searchResult1.get().secondIndex).isEqualTo(searchResult.get().secondIndex)
    }

    @Test
    fun `When indexes not exist in array`() {
        val searchResult1 = IndexOfElementsFinder.findIndexesOfElements(x, 1000)
        assertThat(searchResult1).isNotEqualTo(searchResult)
    }

    @Test
    fun `When indexes not exist in array should return empty result`() {
        val searchResult1 = IndexOfElementsFinder.findIndexesOfElements(x, 1000)
        assertThat(searchResult1).isNotPresent
    }

    @Test
    fun `When input array size is 0 should return empty result`() {
        val x = intArrayOf()
        val searchResult1 = IndexOfElementsFinder.findIndexesOfElements(x, 1000)
        assertThat(searchResult1).isNotPresent
    }

    @Test
    fun `When input array size is 1 should return empty result`() {
        val x: IntArray = intArrayOf(1)
        val searchResult1 = IndexOfElementsFinder.findIndexesOfElements(x, 1000)
        assertThat(searchResult1).isNotPresent
    }

    private fun makeTestee(): Optional<SearchResult> {
        return Optional.of(SearchResult(0, 1))
    }
}