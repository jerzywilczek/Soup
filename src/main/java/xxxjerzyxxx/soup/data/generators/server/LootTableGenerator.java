package xxxjerzyxxx.soup.data.generators.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import xxxjerzyxxx.soup.common.blocks.BlockRegisterer;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTableGenerator extends LootTableProvider {
    public LootTableGenerator(DataGenerator gen) {
        super(gen);
    }

    @Override
    @Nonnull
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(Pair.of(Blocks::new, LootParameterSets.BLOCK));
    }

    private static class Blocks extends BlockLootTables{
        @Override
        protected void addTables() {
            this.dropSelf(BlockRegisterer.MUSHROOM_STEW_BLOCK.get());
        }

        @Override
        @Nonnull
        protected Iterable<Block> getKnownBlocks() {
            return BlockRegisterer.BLOCKS.getEntries()
                    .stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }

    @Override
    protected void validate(@Nonnull Map<ResourceLocation, LootTable> map, @Nonnull ValidationTracker validationtracker) {
        map.forEach((name, table) -> LootTableManager.validate(validationtracker, name, table));
    }
}
