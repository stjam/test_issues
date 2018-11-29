import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows
import java.util.*

/**
 *
 * Added suppression associated with condition of using Date from java.util.Date
 */
@Suppress("DEPRECATION")
@DisplayName("DateInterval Test")
class DateIntervalImplTest {

    private val firstInterval = DateIntervalImpl(
            Date(2015, 10, 7, 23, 0, 0),
            Date(2018, 10, 7, 23, 0, 0))

    private val secondInterval = DateIntervalImpl(
            Date(2016, 10, 7, 23, 0, 0),
            Date(2019, 10, 7, 23, 0, 0))

    private val thirdInterval = DateIntervalImpl(
            Date(2018, 10, 7, 23, 0, 0),
            Date(2036, 10, 7, 23, 0, 0))

    private val fourthInterval = DateIntervalImpl(
            Date(2015, 10, 7, 23, 0, 0),
            Date(2018, 10, 7, 23, 0, 0))

    private val fifthInterval = DateIntervalImpl(
            Date(2018, 10, 7, 23, 0, 0),
            Date(2018, 10, 9, 23, 0, 0))

    private val sixInterval = DateIntervalImpl(
            Date(2099, 10, 7, 23, 0, 0),
            Date(2099, 10, 9, 23, 0, 0))

    private val startDate = Date(2099, 10, 7, 23, 0, 0)
    private val endDate = Date(2100, 10, 7, 23, 0, 0)

    @TestFactory
    fun testIsIntersectedMethod() = listOf(
            dynamicTest("when intervals is intersected isIntersected() should return true") {
                assertThat(firstInterval.isIntersected(secondInterval)).isTrue()
            },
            dynamicTest("when intervals is fully overlapped isIntersected() should return true") {
                assertThat(firstInterval.isIntersected(firstInterval)).isTrue()
            },
            dynamicTest("when one end of interval is equal to another isIntersected() should return true") {
                assertThat(firstInterval.isIntersected(thirdInterval)).isTrue()
            },
            dynamicTest("when one beginnings of interval is equal to another isIntersected() should return true") {
                assertThat(fourthInterval.isIntersected(fifthInterval)).isTrue()
            },
            dynamicTest("when intervals is notintersected isIntersected() should return false") {
                assertThat(fourthInterval.isIntersected(sixInterval)).isFalse()
            }
    )

    @Test
    fun `constructor test`() {
        val dateInterval = DateIntervalImpl(startDate, endDate)
        assertThat(dateInterval.start).isEqualTo(startDate)
        assertThat(dateInterval.end).isEqualTo(endDate)
    }

    @Test
    fun `if start goes after end creation date interval should throw exception`() {
        assertThrows<IllegalArgumentException> { DateIntervalImpl(endDate, startDate) }
    }

    @Test
    fun `if start or end is null creation date interval should throw exception`() {
        assertThrows<IllegalArgumentException> { DateIntervalImpl(null, endDate) }
        assertThrows<IllegalArgumentException> { DateIntervalImpl(startDate, null) }
        assertThrows<IllegalArgumentException> { DateIntervalImpl(null, null) }
    }
}