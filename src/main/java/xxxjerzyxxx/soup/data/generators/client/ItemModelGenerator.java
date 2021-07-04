package xxxjerzyxxx.soup.data.generators.client;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xxxjerzyxxx.soup.Soup;
import xxxjerzyxxx.soup.common.items.ItemRegisterer;

import java.util.Objects;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Soup.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ItemRegisterer.IRON_IN_BOWL.get());
        basicItem(ItemRegisterer.IRON_SOUP_WARM.get());
        basicItem(ItemRegisterer.IRON_SOUP.get());
    }

    private void basicItem(Item item){
        String path = Objects.requireNonNull(item.getRegistryName()).getPath();
        singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("item/" + path));
    }
}
