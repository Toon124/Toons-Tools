package com.toon.toonstools.item;

import com.toon.toonstools.ToonsTools;
import com.toon.toonstools.item.custom.RomaniAxeItem;
import com.toon.toonstools.item.custom.RomaniPickaxeItem;
import com.toon.toonstools.item.custom.RomaniShovelItem;
import com.toon.toonstools.item.custom.RomaniSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ToonsTools.MODID);

    public static final DeferredItem<Item> ROMANI_STONE = ITEMS.register("romanistone",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROMANI_SWORD = ITEMS.register("romani_sword",
            () -> new RomaniSwordItem(ModToolTiers.ROMANI_STONE, new Item.Properties().durability(4000)));

    public static final DeferredItem<Item> ROMANI_AXE = ITEMS.register("romani_axe",
            () -> new RomaniAxeItem(ModToolTiers.ROMANI_STONE, new Item.Properties().durability(4000)));

    public static final DeferredItem<Item> ROMANI_PICKAXE = ITEMS.register("romani_pickaxe",
            () -> new RomaniPickaxeItem(ModToolTiers.ROMANI_STONE, new Item.Properties().durability(4000)));

    public static final DeferredItem<Item> ROMANI_SHOVEL = ITEMS.register("romani_shovel",
            () -> new RomaniShovelItem(ModToolTiers.ROMANI_STONE, new Item.Properties().durability(4000)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
