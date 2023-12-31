package net.walksy.client.events.render;

import net.walksy.client.events.Event;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.util.math.MatrixStack;

public class OnRenderEvent extends Event {
    public float tickDelta;
    public long limitTime;
    public MatrixStack mStack;
    public CallbackInfo ci;

    public OnRenderEvent(float tickDelta, long limitTime, MatrixStack matrix, CallbackInfo ci) {
        this.tickDelta = tickDelta;
        this.limitTime = limitTime;
        this.mStack = matrix;
        this.ci = ci;
    }
}
