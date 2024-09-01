package me.huanmeng.jkook.plugin.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import snw.kookbc.impl.CoreImpl;
import snw.kookbc.impl.KBCClient;
import snw.kookbc.impl.command.litecommands.internal.HelpCommand;

import java.util.List;
import java.util.Objects;

/**
 * 2023/7/16<br>
 * KookBCMixinPluginExample<br>
 *
 * @author huanmeng_qwq
 */
@Mixin(value = KBCClient.class)
public class KBClientMixin {
    @Shadow
    @Final
    private CoreImpl core;

    @Inject(method = "registerCommands", at = @At("HEAD"))
    public void registerCommands(List<Class<?>> commands, CallbackInfo ci) {
        commands.removeIf(clazz -> Objects.equals(clazz, HelpCommand.class));
    }
}
