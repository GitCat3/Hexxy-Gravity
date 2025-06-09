package me.gitcat3.hexxygravity.registry

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.hex.HexActions
import me.gitcat3.hexxygravity.HexxyGravity
import me.gitcat3.hexxygravity.casting.patterns.GetGravity
import me.gitcat3.hexxygravity.casting.patterns.spells.ChangeGravity
import net.minecraft.registry.Registry

object Patterns {
    @JvmStatic
    fun register() {
        Registry.register(
            HexActions.REGISTRY,
            HexxyGravity.MOD_ID + ":" + "change_gravity",
            ActionRegistryEntry(HexPattern.fromAngles("qdawawadqdawawa", HexDir.NORTH_EAST), ChangeGravity())
        )
        Registry.register(
            HexActions.REGISTRY,
            HexxyGravity.MOD_ID + ":" + "get_gravity",
            ActionRegistryEntry(HexPattern.fromAngles("qaeaqeeqaeaqwded", HexDir.NORTH_WEST), GetGravity())
        )
    }
}
