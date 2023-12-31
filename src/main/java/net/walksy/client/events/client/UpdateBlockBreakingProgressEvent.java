package net.walksy.client.events.client;

import net.walksy.client.events.Event;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class UpdateBlockBreakingProgressEvent extends Event {
    public BlockPos pos;
    public Direction direction;
    public CallbackInfoReturnable<Boolean> cir;

    public UpdateBlockBreakingProgressEvent(BlockPos pos, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        this.pos = pos;
        this.direction = direction;
        this.cir = cir;
    }
}
