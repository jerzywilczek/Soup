package xxxjerzyxxx.soup.common.items;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xxxjerzyxxx.soup.Soup;
import xxxjerzyxxx.soup.common.blocks.BlockRegisterer;

public class ItemRegisterer {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Soup.MODID);

    public static final RegistryObject<Item> IRON_IN_BOWL = ITEMS.register("iron_in_bowl", () -> new Item(
            new Item.Properties()
                    .tab(Soup.tab)
                    .craftRemainder(Items.BOWL)
    ));

    public static final RegistryObject<Item> IRON_SOUP_WARM = ITEMS.register("iron_soup_warm", () -> new StackableSoupItem(
            new Item.Properties()
                    .tab(Soup.tab)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(0.6f).alwaysEat().build()),
            IRON_IN_BOWL.get()
    ));

    public static final RegistryObject<Item> IRON_SOUP = ITEMS.register("iron_soup", () -> new StackableSoupItem(
            new Item.Properties()
                    .tab(Soup.tab)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).alwaysEat().build()),
            ImmutableList.of(
                    Pair.of(Items.IRON_ORE, 1),
                    Pair.of(Items.BOWL, 1)
            )
    ));

//    BlockItems
    public static final RegistryObject<Item> MUSHROOM_STEW_BLOCK_ITEM = ITEMS.register(BlockRegisterer.MUSHROOM_STEW_BLOCK_NAME, () -> new BlockItem(BlockRegisterer.MUSHROOM_STEW_BLOCK.get(), new Item.Properties().tab(Soup.tab)));
}
