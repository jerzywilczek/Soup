package xxxjerzyxxx.soup.common.items;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StackableSoupItem extends Item {
    private final List<Pair<ItemLike, Integer>> remainders;

    public StackableSoupItem(Properties properties, List<Pair<ItemLike, Integer>> remainders){
        super(properties);
        this.remainders = ImmutableList.copyOf(remainders);
    }

    public StackableSoupItem(Properties properties, ItemLike remainder) {
        this(properties, remainder, 1);
    }

    public StackableSoupItem(Properties properties, ItemLike remainder, int remainderAmount){
        this(properties, ImmutableList.of(Pair.of(remainder, remainderAmount)));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level world, LivingEntity livingEntity) {
        ItemStack stack = super.finishUsingItem(itemStack, world, livingEntity);
        if (livingEntity instanceof Player player) {
            if (player.isCreative()) {
                stack.setCount(stack.getCount() - 1);
            }

        for(Pair<ItemLike, Integer> pair : remainders){
            ItemEntity itemEntity = new ItemEntity(world, player.position().x, player.position().y, player.position().z,
                    new ItemStack(pair.getFirst(), pair.getSecond()));
            itemEntity.setNoPickUpDelay();
            world.addFreshEntity(itemEntity);
        }


        }
        return stack;
    }
}
