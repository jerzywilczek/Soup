package xxxjerzyxxx.soup.common.items;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public class StackableSoupItem extends Item {
    private final List<Pair<IItemProvider, Integer>> remainders;

    public StackableSoupItem(Properties properties, List<Pair<IItemProvider, Integer>> remainders){
        super(properties);
        this.remainders = ImmutableList.copyOf(remainders);
    }

    public StackableSoupItem(Properties properties, IItemProvider remainder) {
        this(properties, remainder, 1);
    }

    public StackableSoupItem(Properties properties, IItemProvider remainder, int remainderAmount){
        this(properties, ImmutableList.of(Pair.of(remainder, remainderAmount)));
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(@Nonnull ItemStack itemStack, @Nonnull World world, @Nonnull LivingEntity livingEntity) {
        ItemStack stack = super.finishUsingItem(itemStack, world, livingEntity);
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;
            if (player.abilities.instabuild) {
                stack.setCount(stack.getCount() - 1);
            }

        for(Pair<IItemProvider, Integer> pair : remainders){
            ItemEntity itemEntity = new ItemEntity(world, player.position().x, player.position().y, player.position().z,
                    new ItemStack(pair.getFirst(), pair.getSecond()));
            itemEntity.setNoPickUpDelay();
            world.addFreshEntity(itemEntity);
        }


        }
        return stack;
    }
}
