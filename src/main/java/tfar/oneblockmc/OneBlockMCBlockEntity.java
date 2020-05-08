package tfar.oneblockmc;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class OneBlockMCBlockEntity extends TileEntity {
	public OneBlockMCBlockEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public int index = 0;

	public static final List<ItemStack> the_big_list = new ArrayList<>();

	static {
		the_big_list.add(new ItemStack(Blocks.GRASS_BLOCK));
		the_big_list.add(new ItemStack(Blocks.OAK_LOG));

		ItemStack chest1 = new ItemStack(Blocks.CHEST);

		/*the_big_list.add(new ItemStack(Blocks.CHESToneBlockMCBlockEntity -> {
			LockableLootTileEntity.setLootTable(oneBlockMCBlockEntity.world,
							oneBlockMCBlockEntity.world.rand,oneBlockMCBlockEntity.pos,new ResourceLocation(OneBlockMC.MODID,"chestphase1"));
		}));*/
		the_big_list.add(new ItemStack(Blocks.GRASS_BLOCK));
		the_big_list.add(new ItemStack(Blocks.OAK_LOG));
		the_big_list.add(new ItemStack(Blocks.CLAY));
		the_big_list.add(new ItemStack(Blocks.OAK_LOG));
		the_big_list.add(new ItemStack(Blocks.GRASS_BLOCK));
		the_big_list.add(new ItemStack(Blocks.CLAY));
		the_big_list.add(new ItemStack(Blocks.GRASS_BLOCK));
		the_big_list.add(new ItemStack(Blocks.CLAY));

		the_big_list.add(new ItemStack(Util.spawn()));


	}

	@Nonnull
	@Override
	public CompoundNBT write(CompoundNBT tag) {
		tag.putInt("i",index);
		return super.write(tag);
	}

	@Override
	public void read(CompoundNBT tag) {
		index = tag.getInt("i");
		super.read(tag);
	}

	@Override
	public void markDirty() {
		super.markDirty();
		world.notifyBlockUpdate(pos,getBlockState(),getBlockState(),3);
	}

}
