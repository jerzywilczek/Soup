package xxxjerzyxxx.soup.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class StackableSoupItem extends Item {
    IItemProvider remainder;

    public StackableSoupItem(Properties properties, IItemProvider remainder) {
        super(properties);
        this.remainder = remainder;
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


            ItemEntity itemEntity = new ItemEntity(world, player.position().x, player.position().y, player.position().z, new ItemStack(remainder));
            itemEntity.setNoPickUpDelay();
            world.addFreshEntity(itemEntity);

        }
        return stack;
    }
}
