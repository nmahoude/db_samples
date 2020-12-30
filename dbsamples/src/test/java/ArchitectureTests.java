import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "org.nmx")
public class ArchitectureTests {

	
	@ArchTest
  static final ArchRule onion_architecture_is_respected = onionArchitecture()
  				.applicationServices("..application..")
          .domainModels("..domain.models..")
          .domainServices("..domain.boundary..", "..domain.services")
          .adapter("externalServices", "..infrastructure..")
          ;
	
	
}
