package com.example.microservices;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.example.microservices");

        noClasses()
            .that()
                .resideInAnyPackage("com.example.microservices.service..")
            .or()
                .resideInAnyPackage("com.example.microservices.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.example.microservices.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
