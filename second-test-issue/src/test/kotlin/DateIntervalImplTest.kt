import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import java.util.*

/**
 * This test covers only isIntersected() method
 * Added suppression associated with condition of using Date from java.util.Date
 */
@Suppress("DEPRECATION")
@DisplayName("is Intersected method test")
class DateIntervalImplTest {

    private val firstInterval = DateIntervalImpl(
            Date(2015, 10, 7, 23, 0, 0),
            Date(2018, 10, 7, 23, 0, 0));

    private val secondInterval = DateIntervalImpl(
            Date(2016, 10, 7, 23, 0, 0),
            Date(2019, 10, 7, 23, 0, 0));

    private val thirdInterval = DateIntervalImpl(
            Date(2018, 10, 7, 23, 0, 0),
            Date(2036, 10, 7, 23, 0, 0));

    private val fourthInterval = DateIntervalImpl(
            Date(2015, 10, 7, 23, 0, 0),
            Date(2018, 10, 7, 23, 0, 0));

    private val fifthInterval = DateIntervalImpl(
            Date(2018, 10, 7, 23, 0, 0),
            Date(2018, 10, 9, 23, 0, 0));

    private val sixInterval = DateIntervalImpl(
            Date(2099, 10, 7, 23, 0, 0),
            Date(2099, 10, 9, 23, 0, 0));

    @TestFactory
    fun testIsIntersectedMethod() = listOf(
            dynamicTest("when intervals is intersected isIntersected() should return true") {
                Assertions.assertThat(firstInterval.isIntersected(secondInterval)).isTrue()
            },
            dynamicTest("when intervals is fully overlapped isIntersected() should return true") {
                Assertions.assertThat(firstInterval.isIntersected(firstInterval)).isTrue()
            },
            dynamicTest("when one end of interval is equal to another isIntersected() should return true") {
                Assertions.assertThat(firstInterval.isIntersected(thirdInterval)).isTrue()
            },
            dynamicTest("when one beginnings of interval is equal to another isIntersected() should return true") {
                Assertions.assertThat(fourthInterval.isIntersected(fifthInterval)).isTrue()
            },
            dynamicTest("when intervals is notintersected isIntersected() should return false") {
                Assertions.assertThat(fourthInterval.isIntersected(sixInterval)).isFalse()
            }
    )
}