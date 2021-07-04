package xxxjerzyxxx.soup.data.generators.server;

import net.minecraft.client.util.RecipeBookCategories;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.Ingredient;
import xxxjerzyxxx.soup.common.blocks.BlockRegisterer;
import xxxjerzyxxx.soup.common.items.ItemRegisterer;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildShapelessRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder
                .shapeless(BlockRegisterer.MUSHROOM_STEW_BLOCK.get())
                .requires(Items.MUSHROOM_STEW, 9)
                .group(RecipeBookCategories.CRAFTING_BUILDING_BLOCKS.name())
                .unlockedBy("has_mushroom_stew", has(Items.MUSHROOM_STEW))
                .save(consumer);


        ShapelessRecipeBuilder
                .shapeless(ItemRegisterer.IRON_SOUP.get())
                .requires(Items.BEETROOT_SOUP)
                .requires(Items.IRON_ORE)
                .unlockedBy("has_beetroot_soup", has(Items.BEETROOT_SOUP))
                .save(consumer);

        CookingRecipeBuilder
                .smelting(Ingredient.of(ItemRegisterer.IRON_SOUP.get()), ItemRegisterer.IRON_SOUP_WARM.get(), 1.0F, 100)
                .unlockedBy("has_iron_soup", has(ItemRegisterer.IRON_SOUP.get()))
                .save(consumer);

        ShapelessRecipeBuilder
                .shapeless(Items.IRON_NUGGET, 18)
                .requires(ItemRegisterer.IRON_IN_BOWL.get())
                .unlockedBy("has_iron_in_bowl", has(ItemRegisterer.IRON_IN_BOWL.get()))
                .save(consumer);


    }
}
