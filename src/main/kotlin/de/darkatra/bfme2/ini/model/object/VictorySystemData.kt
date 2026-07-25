package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue

data class VictorySystemData(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("CellSize") val cellSize: Double = 0.0,
    @SageIniName("ScalePerLogicFrame") val scalePerLogicFrame: Double = 0.0,
    @SageIniName("SubtractPerLogicFrame") val subtractPerLogicFrame: Double = 0.0,
    @SageIniName("CellBonusRadius") val cellBonusRadius: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<VictorySystemData>(
        name = "VictorySystemData",
        tableKey = "victorysystemdatas",
        properties = {
            property("CellSize", FloatValue) { it.cellSize }
            property("ScalePerLogicFrame", FloatValue) { it.scalePerLogicFrame }
            property("SubtractPerLogicFrame", FloatValue) { it.subtractPerLogicFrame }
            property("CellBonusRadius", FloatValue) { it.cellBonusRadius }
        },
    )
}
