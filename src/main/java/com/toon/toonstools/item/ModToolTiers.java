package com.toon.toonstools.item;

import com.toon.toonstools.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier ROMANI_STONE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ROMANI_TOOL,
            4200,13f,5f,30,() -> Ingredient.of(ModItems.ROMANI_STONE));
}
