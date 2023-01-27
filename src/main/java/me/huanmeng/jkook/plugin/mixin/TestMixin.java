package me.huanmeng.jkook.plugin.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import snw.jkook.command.CommandSender;
import snw.jkook.command.ConsoleCommandSender;
import snw.kookbc.impl.command.CommandManagerImpl;

/**
 * 2023/1/23<br>
 * JKookPluginTest<br>
 *
 * @author huanmeng_qwq
 */
@Mixin(value = CommandManagerImpl.class, remap = false)
public class TestMixin {
    @Inject(method = "executeCommand", at = {@At("HEAD")}, remap = false)
    public void testInject(CommandSender sender, String command, CallbackInfoReturnable<Boolean> cir) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("[Mixin] You entered the command: " + command);
        }
    }
}
