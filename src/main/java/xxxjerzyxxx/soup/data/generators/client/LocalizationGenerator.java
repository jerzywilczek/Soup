package xxxjerzyxxx.soup.data.generators.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import xxxjerzyxxx.soup.Soup;
import xxxjerzyxxx.soup.common.blocks.BlockRegisterer;
import xxxjerzyxxx.soup.common.items.ItemRegisterer;

public class LocalizationGenerator extends LanguageProvider {
    public LocalizationGenerator(DataGenerator gen) {
        super(gen, Soup.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
//        creative tab
        add("itemGroup.soup", "Soup Mod");

//        blocks
        addBlock(BlockRegisterer.MUSHROOM_STEW_BLOCK, "Mushroom stew block");

//        items
        addItem(ItemRegisterer.IRON_IN_BOWL, "Iron in a bowl");
        addItem(ItemRegisterer.IRON_SOUP, "Raw iron soup");
        addItem(ItemRegisterer.IRON_SOUP_WARM, "Cooked iron soup");
    }
}
