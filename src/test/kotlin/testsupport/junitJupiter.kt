package testsupport

import mu.KotlinLogging
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext

@Disabled("test or feature not implemented yet")
annotation class NotImplementedYet

@Tag("possible-sample")
annotation class SampleCandidate

@ExtendWith(TestExecutionLogger::class)
@Tag("integration")
annotation class Integration

class TestExecutionLogger : BeforeTestExecutionCallback, AfterTestExecutionCallback {
  companion object {
    private val LOGGER = KotlinLogging.logger {}
  }

  override fun beforeTestExecution(context: ExtensionContext) {
    LOGGER.info { "Before test execution: ${context.displayName}" }
  }

  override fun afterTestExecution(context: ExtensionContext) {
    LOGGER.info { "After test execution: ${context.displayName}" }
  }
}