package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ArmorSetFlags(override val token: String) : SageIniEnum {
    VETERAN("VETERAN"),
    ELITE("ELITE"),
    HERO("HERO"),
    PLAYER_UPGRADE("PLAYER_UPGRADE"),
    WEAK_VERSUS_BASEDEFENSES("WEAK_VERSUS_BASEDEFENSES"),
    ALTERNATE_FORMATION("ALTERNATE_FORMATION"),
    MOUNTED("MOUNTED"),
    PLAYER_UPGRADE_2("PLAYER_UPGRADE_2"),
    PLAYER_UPGRADE_3("PLAYER_UPGRADE_3"),
    UNBESIEGEABLE("UNBESIEGEABLE"),
    AS_TOWER("AS_TOWER"),
    CREATE_A_HERO_01("CREATE_A_HERO_01"),
    CREATE_A_HERO_02("CREATE_A_HERO_02"),
    CREATE_A_HERO_03("CREATE_A_HERO_03"),
    CREATE_A_HERO_04("CREATE_A_HERO_04"),
    CREATE_A_HERO_05("CREATE_A_HERO_05"),
    CREATE_A_HERO_06("CREATE_A_HERO_06"),
    CREATE_A_HERO_07("CREATE_A_HERO_07"),
    CREATE_A_HERO_08("CREATE_A_HERO_08"),
    CREATE_A_HERO_09("CREATE_A_HERO_09"),
    CREATE_A_HERO_10("CREATE_A_HERO_10");

    companion object {

        val type: EnumValue<ArmorSetFlags> = EnumValue("ArmorSetFlags", entries)
    }
}
