package net.astralsight.influx.datagen;

import net.astralsight.influx.Influx;
import net.astralsight.influx.block.ModBlocks;
import net.astralsight.influx.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Influx.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.INFLUX_DETECTOR_VALUABLES)
                .add(ModBlocks.INFLUX_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.INFLUX_ORE.get(),
                        ModBlocks.INFLUX_BLOCK.get(),
                        ModBlocks.CRYSTALLIZED_INFLUX_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.INFLUX_ORE.get(),
                        ModBlocks.INFLUX_BLOCK.get(),
                        ModBlocks.CRYSTALLIZED_INFLUX_BLOCK.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

    }
}
