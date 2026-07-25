package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.Rgba

data class OnlineChatColors(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Default") val default: Rgba? = null,
    @SageIniName("CurrentRoom") val currentRoom: Rgba? = null,
    @SageIniName("ChatRoom") val chatRoom: Rgba? = null,
    @SageIniName("Game") val game: Rgba? = null,
    @SageIniName("GameFull") val gameFull: Rgba? = null,
    @SageIniName("GameCRCMismatch") val gameCRCMismatch: Rgba? = null,
    @SageIniName("PlayerNormal") val playerNormal: Rgba? = null,
    @SageIniName("PlayerOwner") val playerOwner: Rgba? = null,
    @SageIniName("PlayerBuddy") val playerBuddy: Rgba? = null,
    @SageIniName("OfflinePlayerBuddy") val offlinePlayerBuddy: Rgba? = null,
    @SageIniName("PlayerSelf") val playerSelf: Rgba? = null,
    @SageIniName("PlayerIgnored") val playerIgnored: Rgba? = null,
    @SageIniName("OfflinePlayerIgnored") val offlinePlayerIgnored: Rgba? = null,
    @SageIniName("ChatNormal") val chatNormal: Rgba? = null,
    @SageIniName("ChatEmote") val chatEmote: Rgba? = null,
    @SageIniName("ChatOwner") val chatOwner: Rgba? = null,
    @SageIniName("ChatOwnerEmote") val chatOwnerEmote: Rgba? = null,
    @SageIniName("ChatPriv") val chatPriv: Rgba? = null,
    @SageIniName("ChatPrivEmote") val chatPrivEmote: Rgba? = null,
    @SageIniName("ChatPrivOwner") val chatPrivOwner: Rgba? = null,
    @SageIniName("ChatPrivOwnerEmote") val chatPrivOwnerEmote: Rgba? = null,
    @SageIniName("ChatBuddy") val chatBuddy: Rgba? = null,
    @SageIniName("ChatSelf") val chatSelf: Rgba? = null,
    @SageIniName("AcceptTrue") val acceptTrue: Rgba? = null,
    @SageIniName("AcceptFalse") val acceptFalse: Rgba? = null,
    @SageIniName("MapSelected") val mapSelected: Rgba? = null,
    @SageIniName("MapUnselected") val mapUnselected: Rgba? = null,
    @SageIniName("MOTD") val mOTD: Rgba? = null,
    @SageIniName("MOTDHeading") val mOTDHeading: Rgba? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<OnlineChatColors>(
        name = "OnlineChatColors",
        tableKey = "onlinechatcolors",
        properties = {
            property("Default", Rgba.type) { it.default }
            property("CurrentRoom", Rgba.type) { it.currentRoom }
            property("ChatRoom", Rgba.type) { it.chatRoom }
            property("Game", Rgba.type) { it.game }
            property("GameFull", Rgba.type) { it.gameFull }
            property("GameCRCMismatch", Rgba.type) { it.gameCRCMismatch }
            property("PlayerNormal", Rgba.type) { it.playerNormal }
            property("PlayerOwner", Rgba.type) { it.playerOwner }
            property("PlayerBuddy", Rgba.type) { it.playerBuddy }
            property("OfflinePlayerBuddy", Rgba.type) { it.offlinePlayerBuddy }
            property("PlayerSelf", Rgba.type) { it.playerSelf }
            property("PlayerIgnored", Rgba.type) { it.playerIgnored }
            property("OfflinePlayerIgnored", Rgba.type) { it.offlinePlayerIgnored }
            property("ChatNormal", Rgba.type) { it.chatNormal }
            property("ChatEmote", Rgba.type) { it.chatEmote }
            property("ChatOwner", Rgba.type) { it.chatOwner }
            property("ChatOwnerEmote", Rgba.type) { it.chatOwnerEmote }
            property("ChatPriv", Rgba.type) { it.chatPriv }
            property("ChatPrivEmote", Rgba.type) { it.chatPrivEmote }
            property("ChatPrivOwner", Rgba.type) { it.chatPrivOwner }
            property("ChatPrivOwnerEmote", Rgba.type) { it.chatPrivOwnerEmote }
            property("ChatBuddy", Rgba.type) { it.chatBuddy }
            property("ChatSelf", Rgba.type) { it.chatSelf }
            property("AcceptTrue", Rgba.type) { it.acceptTrue }
            property("AcceptFalse", Rgba.type) { it.acceptFalse }
            property("MapSelected", Rgba.type) { it.mapSelected }
            property("MapUnselected", Rgba.type) { it.mapUnselected }
            property("MOTD", Rgba.type) { it.mOTD }
            property("MOTDHeading", Rgba.type) { it.mOTDHeading }
        },
    )
}
