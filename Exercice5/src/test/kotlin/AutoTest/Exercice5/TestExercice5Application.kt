package AutoTest.Exercice5

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestExercice5Application

fun main(args: Array<String>) {
	fromApplication<Exercice5Application>().with(TestExercice5Application::class).run(*args)
}
