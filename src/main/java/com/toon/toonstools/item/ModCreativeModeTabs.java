package com.toon.toonstools.item;

import com.toon.toonstools.ToonsTools;
import com.toon.toonstools.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ToonsTools.MODID);

    public static final Supplier<CreativeModeTab> ROMANI_ITEMS_TAB = CREATIVE_MODE_TAB.register( "romani_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROMANI_STONE.get()))
                    .title(Component.translatable("creativetab.toonstools.romani_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ROMANI_STONE);
                        output.accept(ModBlocks.ROMANI_ORE);


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
