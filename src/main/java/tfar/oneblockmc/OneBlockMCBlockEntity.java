package tfar.oneblockmc;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nonnull;

public class OneBlockMCBlockEntity extends TileEntity {
	public OneBlockMCBlockEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public int index = 0;

	public static final RandomCollection<ItemStack> collection = new RandomCollection<>();

	static {

		collection.add(412,new ItemStack(Blocks.OAK_WOOD));
		collection.add(294,new ItemStack(Blocks.OAK_LEAVES));


		ItemStack stack = new ItemStack(Blocks.CHEST);

		CompoundNBT tag = stack.getOrCreateChildTag("BlockEntityTag");

		tag.putString("LootTable",OneBlockMC.MODID+":chests/bow");

		collection.add(59,stack);

		ItemStack stack1 = new ItemStack(Blocks.CHEST);

		CompoundNBT tag1 = stack1.getOrCreateChildTag("BlockEntityTag");

		tag1.putString("LootTable",OneBlockMC.MODID+":chests/fishing_rod");

		collection.add(59,stack1);

		ItemStack stack2 = new ItemStack(Blocks.CHEST);

		CompoundNBT tag2 = stack2.getOrCreateChildTag("BlockEntityTag");

		tag2.putString("LootTable",OneBlockMC.MODID+":chests/enchanting_table");

		collection.add(71,new ItemStack(Blocks.IRON_ORE));

		collection.add(35,new ItemStack(Blocks.GOLD_ORE));


		collection.add(12,new ItemStack(Blocks.DIAMOND_ORE));

		collection.add(59,stack2);


		//CompoundNBT nbt = chest1.getOrCreateChildTag("BlockEntityTag");
		//nbt.


		//collection.add(new ItemStack(Blocks.GRASS_BLOCK));
		//collection.add(new ItemStack(Blocks.OAK_LOG));

		//ItemStack chest1 = new ItemStack(Blocks.CHEST);

		/*collection.add(new ItemStack(Blocks.CHESToneBlockMCBlockEntity -> {
			LockableLootTileEntity.setLootTable(oneBlockMCBlockEntity.world,
							oneBlockMCBlockEntity.world.rand,oneBlockMCBlockEntity.pos,new ResourceLocation(OneBlockMC.MODID,"chestphase1"));
		}));*/
		//collection.add(new ItemStack(Blocks.GRASS_BLOCK));
		//collection.add(new ItemStack(Blocks.OAK_LOG));
		//collection.add(new ItemStack(Blocks.CLAY));
		//collection.add(new ItemStack(Blocks.OAK_LOG));
		//collection.add(new ItemStack(Blocks.GRASS_BLOCK));
		//collection.add(new ItemStack(Blocks.CLAY));
		//collection.add(new ItemStack(Blocks.GRASS_BLOCK));
		//collection.add(new ItemStack(Blocks.CLAY));

		//collection.add(new ItemStack(Util.spawn()));


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

	public void increment(){
		index++;
		markDirty();
	}
}
