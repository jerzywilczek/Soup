package xxxjerzyxxx.soup.data.generators.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.fmllegacy.RegistryObject;
import xxxjerzyxxx.soup.common.blocks.BlockRegisterer;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LootTableGenerator extends LootTableProvider {
    public LootTableGenerator(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(Pair.of(Blocks::new, LootContextParamSets.BLOCK));
    }

    private static class Blocks extends BlockLoot {
        @Override
        protected void addTables() {
            this.dropSelf(BlockRegisterer.MUSHROOM_STEW_BLOCK.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BlockRegisterer.BLOCKS.getEntries()
                    .stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationTracker) {
        map.forEach((name, table) -> LootTables.validate(validationTracker, name, table));
    }
}
