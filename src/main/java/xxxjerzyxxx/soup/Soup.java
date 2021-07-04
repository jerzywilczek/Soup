package xxxjerzyxxx.soup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxxjerzyxxx.soup.common.blocks.BlockRegisterer;
import xxxjerzyxxx.soup.common.items.ItemRegisterer;

import javax.annotation.Nonnull;


@Mod(Soup.MODID)
public class Soup {
    public static final String MODID = "soup";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup group = new ItemGroup(MODID) {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegisterer.IRON_SOUP_WARM.get());
        }
    };

    public Soup(){
        LOGGER.debug("Registering blocks");
        BlockRegisterer.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        LOGGER.debug("Registering items");
        ItemRegisterer.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }
}
