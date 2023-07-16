package me.huanmeng.jkook.plugin.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import snw.kookbc.impl.CoreImpl;
import snw.kookbc.impl.KBCClient;

/**
 * 2023/7/16<br>
 * KookBCMixinPluginExample<br>
 *
 * @author huanmeng_qwq
 */
@Mixin(value = KBCClient.class, remap = false)
public class KBClientMixin {
    @Shadow
    @Final
    private CoreImpl core;

    /**
     * @author huanmeng_qwq
     * @reason 删除默认/help命令
     */
    @Overwrite
    protected void registerHelpCommand() {
        core.getLogger().info("成功击毙/help命令。");
    }
}
