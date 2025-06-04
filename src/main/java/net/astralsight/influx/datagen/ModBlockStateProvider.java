package net.astralsight.influx.datagen;

import net.astralsight.influx.Influx;
import net.astralsight.influx.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Influx.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CRYSTALLIZED_INFLUX_BLOCK);
        blockWithItem(ModBlocks.INFLUX_BLOCK);

        blockWithItem(ModBlocks.INFLUX_ORE);

        blockWithItem(ModBlocks.TEST_BLOCK);
    }
        private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
            simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
