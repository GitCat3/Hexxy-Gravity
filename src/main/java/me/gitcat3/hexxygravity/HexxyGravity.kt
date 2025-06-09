package me.gitcat3.hexxygravity

import net.fabricmc.api.ModInitializer
import me.gitcat3.hexxygravity.registry.Patterns.register
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class HexxyGravity : ModInitializer {
    override fun onInitialize() {
        register()
    }

    companion object {
        const val MOD_ID: String = "hexxygravity"
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }
}