package xxxjerzyxxx.soup.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xxxjerzyxxx.soup.Soup;

public class BlockRegisterer {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Soup.MODID);

    public static final String MUSHROOM_STEW_BLOCK_NAME = "mushroom_stew_block";
    public static final RegistryObject<Block> MUSHROOM_STEW_BLOCK = BLOCKS.register(MUSHROOM_STEW_BLOCK_NAME, () -> new Block(
            AbstractBlock.Properties.of(Material.STONE)
            .strength(1.0f, 1.0f)
            .sound(SoundType.SLIME_BLOCK))
    );
}
