package vazkii.quark.tweaks.feature;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vazkii.quark.base.module.Feature;

public class ImprovedMountHUD extends Feature {

	@SubscribeEvent
	public void onRenderHUD(RenderGameOverlayEvent.Pre event) {
		if(event.getType() == ElementType.ALL) {
			Minecraft mc = Minecraft.getMinecraft();
			Entity riding = mc.thePlayer.getRidingEntity();
			
			if(riding != null) {
				GuiIngameForge.renderFood = true;
				if(riding instanceof EntityHorse)
					GuiIngameForge.renderJumpBar = GameSettings.isKeyDown(mc.gameSettings.keyBindJump);
			}
		}
	}
	
	@Override
	public boolean hasSubscriptions() {
		return isClient();
	}
	
}