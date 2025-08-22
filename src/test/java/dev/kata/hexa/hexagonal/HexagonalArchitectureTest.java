package dev.kata.hexa.hexagonal;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import dev.kata.hexa.HexaApplication;
import org.jmolecules.archunit.JMoleculesArchitectureRules;

@AnalyzeClasses(
        packagesOf = HexaApplication.class,
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class HexagonalArchitectureTest {

    static JavaClasses classes;

    @ArchTest
    static final ArchRule hexagonal_jmolecule_rules = JMoleculesArchitectureRules.ensureHexagonal();

}
