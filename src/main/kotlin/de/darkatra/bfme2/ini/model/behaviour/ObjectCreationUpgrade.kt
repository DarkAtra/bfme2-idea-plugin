package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageReference

data class ObjectCreationUpgrade(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TriggeredBy") override val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") override val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") override val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") override val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("StartsActive") override val startsActive: Boolean = false,
    @SageIniName("Description") override val description: String = "",
    @SageIniName("ActiveDuringConstruction") override val activeDuringConstruction: Boolean = false,
    @SageIniName("CustomAnimAndDuration") override val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("Permanent") override val permanent: Boolean = false,
    @SageIniName("UpgradeObject") val upgradeObject: SageReference<ObjectCreationList>? = null,
    @SageIniName("Delay") val delay: Int = 0,
    @SageIniName("RemoveUpgrade") val removeUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("GrantUpgrade") val grantUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("ThingToSpawn") val thingToSpawn: SageReference<Object>? = null,
    @SageIniName("Offset") val offset: Coords? = null,
    @SageIniName("Angle") val angle: Int = 0,
    @SageIniName("DestroyWhenSold") val destroyWhenSold: Boolean = false,
    @SageIniName("FadeInTime") val fadeInTime: Int = 0,
    @SageIniName("UseBuildingProduction") val useBuildingProduction: Boolean = false,
    @SageIniName("DeathAnimAndDuration") val deathAnimAndDuration: Map<String, String> = emptyMap(),
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<ObjectCreationUpgrade>(
        name = "ObjectCreationUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("UpgradeObject", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.upgradeObject }
            property("Delay", IntValue) { it.delay }
            property("RemoveUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.removeUpgrade }
            property("GrantUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.grantUpgrade }
            property("ThingToSpawn", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.thingToSpawn }
            property("Offset", Coords.type) { it.offset }
            property("Angle", IntValue) { it.angle }
            property("DestroyWhenSold", BooleanValue) { it.destroyWhenSold }
            property("FadeInTime", IntValue) { it.fadeInTime }
            property("UseBuildingProduction", BooleanValue) { it.useBuildingProduction }
            property("DeathAnimAndDuration", MapValue(StringValue, StringValue)) { it.deathAnimAndDuration }
        },
    )
}
