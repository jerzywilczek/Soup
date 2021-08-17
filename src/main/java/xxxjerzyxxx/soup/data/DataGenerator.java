package xxxjerzyxxx.soup.data;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import xxxjerzyxxx.soup.Soup;
import xxxjerzyxxx.soup.data.generators.client.BlockStateGenerator;
import xxxjerzyxxx.soup.data.generators.client.ItemModelGenerator;
import xxxjerzyxxx.soup.data.generators.client.LocalizationGenerator;
import xxxjerzyxxx.soup.data.generators.server.LootTableGenerator;
import xxxjerzyxxx.soup.data.generators.server.RecipeGenerator;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Soup.MODID)
public class DataGenerator {
    @SubscribeEvent
    public static void generate(GatherDataEvent event){
        net.minecraft.data.DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if(event.includeClient()){
            generator.addProvider(new BlockStateGenerator(generator, existingFileHelper));
            generator.addProvider(new ItemModelGenerator(generator, existingFileHelper));
            generator.addProvider(new LocalizationGenerator(generator));
        }

        if(event.includeServer()){
            generator.addProvider(new LootTableGenerator(generator));
            generator.addProvider(new RecipeGenerator(generator));
        }
    }
}
