import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.changelog")
    id("org.jetbrains.intellij.platform")
}

dependencies {
    testImplementation(libs.assertj)
    testImplementation(libs.junit)

    intellijPlatform {
        intellijIdea("2026.1.3")
        testFramework(TestFrameworkType.Platform)
    }
}

tasks.test {
    // opt-in corpus for SageEngineIniCorpusTest, declared as input so that changing it reruns the tests
    val iniCorpus = providers.environmentVariable("BFME2_INI_CORPUS").orElse("")
    inputs.property("iniCorpus", iniCorpus)
    environment("BFME2_INI_CORPUS", iniCorpus.get())
}
