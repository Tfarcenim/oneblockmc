package tfar.oneblockmc;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Events {
	@SubscribeEvent
	public static void nobreak(BlockEvent.BreakEvent e){
		if (e.getState().getBlock() == OneBlockMC.block){
			e.setCanceled(true);

			ItemStack stack = OneBlockMCBlockEntity.the_big_list.get(((OneBlockMCBlockEntity)e.getWorld().getTileEntity(e.getPos())).index).copy();

			IWorld iWorld = e.getWorld();
			BlockPos pos = e.getPos();
			iWorld.addEntity(new ItemEntity((World) iWorld,pos.getX(),pos.getY(),pos.getZ(),stack));

			((OneBlockMCBlockEntity)e.getWorld().getTileEntity(e.getPos())).index++;
		}
	}
}
