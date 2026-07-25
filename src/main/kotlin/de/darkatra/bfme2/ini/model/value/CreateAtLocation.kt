package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class CreateAtLocation(override val token: String) : SageIniEnum {
    CREATE_AT_EDGE_NEAR_SOURCE("CREATE_AT_EDGE_NEAR_SOURCE"),
    CREATE_AT_EDGE_NEAR_TARGET("CREATE_AT_EDGE_NEAR_TARGET"),
    CREATE_AT_EDGE_NEAR_TARGET_AND_MOVE_TO_LOCATION("CREATE_AT_EDGE_NEAR_TARGET_AND_MOVE_TO_LOCATION"),
    CREATE_AT_LOCATION("CREATE_AT_LOCATION"),
    USE_OWNER_OBJECT("USE_OWNER_OBJECT"),
    CREATE_ABOVE_LOCATION("CREATE_ABOVE_LOCATION"),
    CREATE_AT_EDGE_FARTHEST_FROM_TARGET("CREATE_AT_EDGE_FARTHEST_FROM_TARGET"),
    CREATE_CLOSEST_TO_SPAWN_POINT("CREATE_CLOSEST_TO_SPAWN_POINT"),
    USE_SECONDARY_OBJECT_LOCATION("USE_SECONDARY_OBJECT_LOCATION");

    companion object {

        val type: EnumValue<CreateAtLocation> = EnumValue("CreateAtLocation", entries)
    }
}
