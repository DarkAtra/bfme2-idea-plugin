package de.darkatra.bfme2.ini.model.common

data class SageBlockHeader(
    val name: String = "",
    val parentName: String? = null,
    val moduleTag: String? = null,
    val label: String? = null,
) {

    companion object : SageIniBlockDescriptor<SageBlockHeader>(
        name = "SageBlockHeader",
    )
}
