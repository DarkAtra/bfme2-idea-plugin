package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SubsystemLoader

data class LoadSubsystem(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Loader") val loader: SubsystemLoader? = null,
    @SageIniName("InitFile") val initFile: Opaque? = null,
    @SageIniName("InitFileDebug") val initFileDebug: Opaque? = null,
    @SageIniName("InitPath") val initPath: Opaque? = null,
    @SageIniName("ExcludePath") val excludePath: Opaque? = null,
    @SageIniName("IncludePathCinematics") val includePathCinematics: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LoadSubsystem>(
        name = "LoadSubsystem",
        tableKey = "loadsubsystems",
        properties = {
            property("Loader", SubsystemLoader.type) { it.loader }
            property("InitFile", Opaque.type) { it.initFile }
            property("InitFileDebug", Opaque.type) { it.initFileDebug }
            property("InitPath", Opaque.type) { it.initPath }
            property("ExcludePath", Opaque.type) { it.excludePath }
            property("IncludePathCinematics", Opaque.type) { it.includePathCinematics }
        },
    )
}
