package net.walksy.client.events.render;

import net.walksy.client.events.Event;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public class RenderTooltipEvent extends Event {
    public MatrixStack mStack;
    public ItemStack stack; 
    public int x, y;
    public CallbackInfo ci;

    public RenderTooltipEvent(MatrixStack mStack, ItemStack stack, int x, int y, CallbackInfo ci) {
        this.mStack = mStack;
        this.stack = stack;
        this.x = x;
        this.y = y;
        this.ci = ci;
    }
}
