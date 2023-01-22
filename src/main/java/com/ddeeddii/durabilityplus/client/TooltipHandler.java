package com.ddeeddii.durabilityplus.client;

import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class TooltipHandler {
    private static Formatting GetFormattingForTooltip(int maxDurability, int currentDurability){
        if(maxDurability * 0.66f <= currentDurability){
            return Formatting.GREEN;
        } else if(maxDurability * 0.33f <= currentDurability){
            return Formatting.YELLOW;
        }

        return Formatting.RED;
    }

    public static Text GetTooltip(ItemStack stack){
        int maxDurability = stack.getMaxDamage();
        int currentDurability = maxDurability - stack.getDamage();

        MutableText currentDurabilityText = Text.literal(String.valueOf(currentDurability))
                .formatted(GetFormattingForTooltip(maxDurability, currentDurability));
        MutableText slashText = Text.literal(" / ")
                .formatted(Formatting.GRAY);
        MutableText maxDurabilityText = Text.literal(String.valueOf(maxDurability))
                .formatted(Formatting.GRAY);

        return currentDurabilityText.append(slashText).append(maxDurabilityText);
    }
}
