package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class DynamicPortalBehaviour(
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
    @SageIniName("NumberOfBones") val numberOfBones: Int = 0,
    @SageIniName("GenerateNow") val generateNow: Boolean = false,
    @SageIniName("AboveWall") val aboveWall: Int = 0,
    @SageIniName("TopAttackPos") val topAttackPos: Coords? = null,
    @SageIniName("TopAttackRadius") val topAttackRadius: Double = 0.0,
    @SageIniName("AllowEnemies") val allowEnemies: Boolean = false,
    @SageIniName("ActivationDelaySeconds") val activationDelaySeconds: Double = 0.0,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("BonePrefix") val bonePrefix: Untyped? = null,
    @SageIniName("WayPoint") val wayPoint: List<Map<String, String>> = emptyList(),
    @SageIniName("Link") val link: List<Map<String, String>> = emptyList(),
    @SageIniName("WallBoundsMesh") val wallBoundsMesh: Untyped? = null,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<DynamicPortalBehaviour>(
        name = "DynamicPortalBehaviour",
        parent = UpgradeBehavior,
        properties = {
            property("NumberOfBones", IntValue) { it.numberOfBones }
            property("GenerateNow", BooleanValue) { it.generateNow }
            property("AboveWall", IntValue) { it.aboveWall }
            property("TopAttackPos", Coords.type) { it.topAttackPos }
            property("TopAttackRadius", FloatValue) { it.topAttackRadius }
            property("AllowEnemies", BooleanValue) { it.allowEnemies }
            property("ActivationDelaySeconds", FloatValue) { it.activationDelaySeconds }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("BonePrefix", Untyped.type) { it.bonePrefix }
            property("WayPoint", ListValue(MapValue(StringValue, StringValue))) { it.wayPoint }
            property("Link", ListValue(MapValue(StringValue, StringValue))) { it.link }
            property("WallBoundsMesh", Untyped.type) { it.wallBoundsMesh }
        },
    )
}
