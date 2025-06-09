package me.gitcat3.hexxygravity.casting.patterns

import at.petrak.hexcasting.api.casting.asActionResult
import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getEntity
import at.petrak.hexcasting.api.casting.iota.Iota
import gravity_changer.api.GravityChangerAPI

class GetGravity : ConstMediaAction {
    override val argc = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
        val gravDir = GravityChangerAPI.getGravityDirection(args.getEntity(0))
        return gravDir.unitVector.asActionResult
    }

}