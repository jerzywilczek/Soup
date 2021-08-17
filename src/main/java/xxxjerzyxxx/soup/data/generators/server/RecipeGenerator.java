package xxxjerzyxxx.soup.data.generators.server;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import xxxjerzyxxx.soup.common.blocks.BlockRegisterer;
import xxxjerzyxxx.soup.common.items.ItemRegisterer;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder
                .shapeless(BlockRegisterer.MUSHROOM_STEW_BLOCK.get())
                .requires(Items.MUSHROOM_STEW, 9)
                .group(RecipeBookCategories.CRAFTING_BUILDING_BLOCKS.name())
                .unlockedBy("has_mushroom_stew", has(Items.MUSHROOM_STEW))
                .save(consumer);

        ShapelessRecipeBuilder
                .shapeless(ItemRegisterer.IRON_SOUP.get())
                .requires(Items.BEETROOT_SOUP)
                .requires(Items.RAW_IRON)
                .unlockedBy("has_beetroot_soup", has(Items.BEETROOT_SOUP))
                .save(consumer);

        SimpleCookingRecipeBuilder
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
