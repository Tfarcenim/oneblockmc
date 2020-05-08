package tfar.oneblockmc;

import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber
public class Events {

	public static final Map<BlockPos,Integer> infinityPos = new HashMap<>();

	@SubscribeEvent
	public static void

	@SubscribeEvent
	public static void nobreak(BlockEvent.BreakEvent e){

		if (e.getPlayer().abilities.isCreativeMode)return;
		if (e.getState().getBlock() == OneBlockMC.block){
			e.setCanceled(true);
			IWorld iWorld = e.getWorld();
			BlockPos pos = e.getPos();
			OneBlockMCBlockEntity oneBlockMCBlockEntity = ((OneBlockMCBlockEntity)iWorld.getTileEntity(pos));

			int index = oneBlockMCBlockEntity.index;
			ItemStack stack = null;
			if (index < 2){
				if (index == 0) stack = new ItemStack(Blocks.CHEST);
				if (index == 1) stack = new ItemStack(Blocks.FURNACE);
			} else {
				stack = OneBlockMCBlockEntity.collection.next().copy();
			}

			oneBlockMCBlockEntity.increment();

			iWorld.addEntity(new ItemEntity((World) iWorld,pos.getX(),pos.getY(),pos.getZ(),stack));

			//((OneBlockMCBlockEntity)e.getWorld().getTileEntity(e.getPos())).index++;
		}
	}
}
