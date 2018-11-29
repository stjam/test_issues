import org.assertj.core.api.Assertions
import org.junit.Test

class ValidatorClientTest {
    private val emptyString = "   "
    private val stringWithContent = "abacaba"
    private val validatorClient = StringValidatorClient()


    @Test
    fun `validate string not null`() {
        validatorClient.setValidator(NotNullValidator())
        Assertions.assertThat(validatorClient.performValidation(stringWithContent)).isTrue()
    }

    @Test
    fun `not validate null string`() {
        validatorClient.setValidator(NotNullValidator())
        Assertions.assertThat(validatorClient.performValidation(null)).isFalse()
    }

    @Test
    fun `validate string is blank`() {
        validatorClient.setValidator(NotBlankValidator())
        Assertions.assertThat(validatorClient.performValidation(emptyString)).isFalse()
    }

    @Test
    fun `validate string not blank`() {
        validatorClient.setValidator(NotBlankValidator())
        Assertions.assertThat(validatorClient.performValidation(stringWithContent)).isTrue()
    }

    @Test
    fun `change implementation on runtime should change behavior`() {
        validatorClient.setValidator(NotNullValidator())
        Assertions.assertThat(validatorClient.performValidation(stringWithContent)).isTrue()

        validatorClient.setValidator(NotBlankValidator())
        Assertions.assertThat(validatorClient.performValidation(emptyString)).isFalse()
    }
}