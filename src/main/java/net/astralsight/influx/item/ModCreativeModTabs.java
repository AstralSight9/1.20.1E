package net.astralsight.influx.item;

import net.astralsight.influx.Influx;
import net.astralsight.influx.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Influx.MOD_ID);

            public static final RegistryObject<CreativeModeTab> INFLUX = CREATIVE_MODE_TABS.register("influx",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.INFLUX_SHARD.get()))
                            .title(Component.translatable("creativetab.influx"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.INFLUX_SHARD.get());
                                output.accept(ModItems.INFLUX_NUGGET.get());
                                output.accept(ModItems.CRYSTALLIZED_INFLUX.get());
                                output.accept(ModItems.INFLUX_APPLE.get());
                                output.accept(ModItems.INFLUX_LEAF.get());
                                output.accept(ModItems.LEAF.get());

                                output.accept(ModBlocks.INFLUX_BLOCK.get());
                                output.accept(ModBlocks.CRYSTALLIZED_INFLUX_BLOCK.get());
                                output.accept(ModBlocks.INFLUX_ORE.get());

                                output.accept(Items.HEART_OF_THE_SEA);

                            })
                            .build());


            public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
            }
}
