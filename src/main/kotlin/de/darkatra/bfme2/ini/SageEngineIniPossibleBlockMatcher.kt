package de.darkatra.bfme2.ini

fun interface SageEngineIniPossibleBlockMatcher {

    fun matches(words: List<String>): Boolean
}
