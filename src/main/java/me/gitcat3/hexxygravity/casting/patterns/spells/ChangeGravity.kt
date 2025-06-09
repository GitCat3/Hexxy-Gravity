package me.gitcat3.hexxygravity.casting.patterns.spells

import at.petrak.hexcasting.api.casting.RenderedSpell
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getEntity
import at.petrak.hexcasting.api.casting.getVec3
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapInvalidIota
import at.petrak.hexcasting.api.misc.MediaConstants
import gravity_changer.api.GravityChangerAPI
import net.minecraft.entity.Entity
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Vec3d

class ChangeGravity : SpellAction {
    override val argc = 2
    override fun execute(args: List<Iota>, env: CastingEnvironment) : SpellAction.Result{
        val target = args.getEntity(0)
        env.assertEntityInRange(target)

        val direction = when (args.getVec3(1)) {
            Vec3d(0.0, -1.0, 0.0) -> Direction.DOWN
            Vec3d(0.0, 1.0, 0.0) -> Direction.UP
            Vec3d(-1.0, 0.0, 0.0) -> Direction.WEST
            Vec3d(1.0, 0.0, 0.0) -> Direction.EAST
            Vec3d(0.0, 0.0, 1.0) -> Direction.SOUTH
            Vec3d(0.0, 0.0, -1.0) -> Direction.NORTH
            else -> throw MishapInvalidIota.Companion.of(args[1], 0, "axis_vector")
        }

        return SpellAction.Result(Spell(target, direction), MediaConstants.CRYSTAL_UNIT, listOf())
    }

    private data class Spell(val target: Entity, val direction: Direction): RenderedSpell {
        override fun cast(env: CastingEnvironment) {
            GravityChangerAPI.setBaseGravityDirection(target, direction)
        }
    }
}