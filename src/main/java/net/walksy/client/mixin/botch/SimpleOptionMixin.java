package net.walksy.client.mixin.botch;

import java.util.Objects;
import java.util.function.Consumer;

import net.walksy.client.interfaces.mixin.SimpleOptionAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.option.SimpleOption;

@Mixin(SimpleOption.class)
public class SimpleOptionMixin<T> implements SimpleOptionAccessor<T> {

    @Shadow private Consumer<T> changeCallback;
    @Shadow private T value;

    @Override
    public void setUnsafeValue(T value) {
        if (!Objects.equals(this.value, value)) {
            changeCallback.accept(this.value);
        }
        
        this.value = value;
    }
    
}
