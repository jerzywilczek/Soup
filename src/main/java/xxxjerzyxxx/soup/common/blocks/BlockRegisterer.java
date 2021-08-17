package xxxjerzyxxx.soup.common.blocks;


import net.minecraft.world.level.block.Block;


import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xxxjerzyxxx.soup.Soup;

public class BlockRegisterer {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Soup.MODID);

    public static final String MUSHROOM_STEW_BLOCK_NAME = "mushroom_stew_block";
    public static final RegistryObject<Block> MUSHROOM_STEW_BLOCK = BLOCKS.register(MUSHROOM_STEW_BLOCK_NAME, () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE)
            .strength(1.0f, 1.0f)
            .sound(SoundType.SLIME_BLOCK))
    );
}
