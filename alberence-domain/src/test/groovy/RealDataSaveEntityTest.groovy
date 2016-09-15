import com.java.alberence.configuration.AlberenceDomainJpaConfig
import com.java.alberence.configuration.ConfigurationPropertiesApplicationContextInitializer
import com.java.alberence.configuration.profiles.AlberenceProfiles
import com.java.alberence.domain.practice.java8.Apple
import com.java.alberence.domain.practice.java8.AppleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import java.time.LocalDateTime

@Transactional
@Rollback(value = false)
@ActiveProfiles(profiles = AlberenceProfiles.SPRING_TEST)
@ContextConfiguration(initializers = ConfigurationPropertiesApplicationContextInitializer, classes = [AlberenceDomainJpaConfig])
class RealDataSaveEntityTest extends Specification {

	@Autowired
	def AppleRepository appleRepository

	def "AppleDomainTest"() {
		given:
		def apple = Apple.create("aoi", "green", 100, "korea", 2_000)
		println(LocalDateTime.now())
		when:
		def save = appleRepository.save(apple)
		println(appleRepository.getOne(save.getId()).toString())
		println(appleRepository.getOne(save.getId()).getCreatedAt())
		then:
		noExceptionThrown()
	}
}
