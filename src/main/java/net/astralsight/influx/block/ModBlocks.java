package net.astralsight.influx.block;

import net.astralsight.influx.Influx;
import net.astralsight.influx.block.custom.test_block;
import net.astralsight.influx.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Influx.MOD_ID);

    public static final RegistryObject<Block> INFLUX_BLOCK = registerBlock("influx_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));

    public static final RegistryObject<Block> CRYSTALLIZED_INFLUX_BLOCK = registerBlock("crystallized_influx_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new test_block(BlockBehaviour.Properties.copy(Blocks.DIRT).noLootTable()));

    public static final RegistryObject<Block> INFLUX_ORE = registerBlock("influx_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).
                    strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,10)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
