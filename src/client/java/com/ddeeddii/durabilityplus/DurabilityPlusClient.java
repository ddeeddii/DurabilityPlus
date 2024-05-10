package com.ddeeddii.durabilityplus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.item.TooltipType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DurabilityPlusClient implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("durabilityplus");

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((ItemStack stack, Item.TooltipContext context, TooltipType type, List<Text> lines) -> {
            if(stack.getMaxDamage() == 0) {
                return;
            }

            lines.add(Text.empty());
            lines.add(TooltipHandler.GetTooltip(stack));
        });

        LOGGER.info("[DurabilityPlus] Mod loaded!");
    }
}
