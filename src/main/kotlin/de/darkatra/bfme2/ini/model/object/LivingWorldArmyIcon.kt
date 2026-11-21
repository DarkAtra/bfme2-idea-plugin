package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageAudio
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.livingworld.LivingWorldIconObject
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class LivingWorldArmyIcon(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("OnSelectedSound") val onSelectedSound: SageReference<AudioEvent>? = null,
    @SageIniName("OnMovePlannedSound") val onMovePlannedSound: SageReference<AudioEvent>? = null,
    @SageIniName("OnMoveStartedSound") val onMoveStartedSound: SageReference<AudioEvent>? = null,
    @SageIniName("WelcomeReinforcementsSound") val welcomeReinforcementsSound: SageReference<SageAudio>? = null,
    @SageIniName("KickOutReinforcementsSound") val kickOutReinforcementsSound: SageReference<SageAudio>? = null,
    @SageIniName("DisbandUnitSound") val disbandUnitSound: SageReference<AudioEvent>? = null,
    @SageIniName("RetreatTeleportToHomeRegionEvaEvent") val retreatTeleportToHomeRegionEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("RetreatTeleportToNonHomeRegionEvaEvent") val retreatTeleportToNonHomeRegionEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("OnMoveSound") val onMoveSound: Opaque? = null,
    @SageIniName("Object") val `object`: List<LivingWorldIconObject> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldArmyIcon>(
        name = "LivingWorldArmyIcon",
        tableKey = "livingworldarmyicons",
        properties = {
            property("OnSelectedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.onSelectedSound }
            property("OnMovePlannedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.onMovePlannedSound }
            property("OnMoveStartedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.onMoveStartedSound }
            property("WelcomeReinforcementsSound", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.welcomeReinforcementsSound }
            property("KickOutReinforcementsSound", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.kickOutReinforcementsSound }
            property("DisbandUnitSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.disbandUnitSound }
            property("RetreatTeleportToHomeRegionEvaEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.retreatTeleportToHomeRegionEvaEvent }
            property("RetreatTeleportToNonHomeRegionEvaEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.retreatTeleportToNonHomeRegionEvaEvent }
            property("OnMoveSound", Opaque.type) { it.onMoveSound }
            property("Object", ListValue(BlockValue<LivingWorldIconObject> { listOf(LivingWorldIconObject) })) { it.`object` }
        },
    )
}
