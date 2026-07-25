package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.RawValue

@JvmInline
value class Untyped(val raw: String = "") {

    companion object {

        val type: SageIniValueType<Untyped> = RawValue("Untyped")
    }
}
