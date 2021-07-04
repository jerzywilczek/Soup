package xxxjerzyxxx.soup.common.items;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xxxjerzyxxx.soup.Soup;
import xxxjerzyxxx.soup.common.blocks.BlockRegisterer;

public class ItemRegisterer {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Soup.MODID);

    public static final RegistryObject<Item> IRON_IN_BOWL = ITEMS.register("iron_in_bowl", () -> new Item(
            new Item.Properties()
                    .tab(Soup.group)
                    .craftRemainder(Items.BOWL)
    ));

    public static final RegistryObject<Item> IRON_SOUP_WARM = ITEMS.register("iron_soup_warm", () -> new StackableSoupItem(
            new Item.Properties()
                    .tab(Soup.group)
                    .food(new Food.Builder().nutrition(7).saturationMod(0.6f).alwaysEat().build()),
            IRON_IN_BOWL.get()
    ));

    public static final RegistryObject<Item> IRON_SOUP = ITEMS.register("iron_soup", () -> new StackableSoupItem(
            new Item.Properties()
                    .tab(Soup.group)
                    .food(new Food.Builder().nutrition(4).saturationMod(0.3f).build()),
            Items.IRON_ORE
    ));

//    BlockItems
    public static final RegistryObject<Item> MUSHROOM_STEW_BLOCK_ITEM = ITEMS.register(BlockRegisterer.MUSHROOM_STEW_BLOCK_NAME, () -> new BlockItem(BlockRegisterer.MUSHROOM_STEW_BLOCK.get(), new Item.Properties().tab(Soup.group)));
}
