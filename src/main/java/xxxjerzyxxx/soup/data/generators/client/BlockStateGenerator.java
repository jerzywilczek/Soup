package xxxjerzyxxx.soup.data.generators.client;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xxxjerzyxxx.soup.Soup;
import xxxjerzyxxx.soup.common.blocks.BlockRegisterer;

import java.util.Objects;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Soup.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cubeAllBlock(BlockRegisterer.MUSHROOM_STEW_BLOCK.get());
    }

    private void cubeAllBlock(Block block){
        simpleBlock(block);
        itemModels().cubeAll(Objects.requireNonNull(block.getRegistryName()).getPath(), modLoc("block/" + block.getRegistryName().getPath()));
    }
}
