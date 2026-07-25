package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.AssetValue

@JvmInline
value class ModelFile(val path: String = "") {

    companion object {

        val type: SageIniValueType<ModelFile> = AssetValue(setOf(".w3d"))
    }
}
