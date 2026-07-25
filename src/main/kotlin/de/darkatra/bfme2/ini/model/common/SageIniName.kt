package de.darkatra.bfme2.ini.model.common

/**
 * Records the exact upstream SAGE INI token for a model class or property whose Kotlin name was
 * made idiomatic (lowerCamelCase properties, non-underscored class names). Reference resolution and
 * tooling can recover the original token via reflection.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class SageIniName(val value: String)
