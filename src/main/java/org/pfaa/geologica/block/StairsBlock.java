package org.pfaa.geologica.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.util.IIcon;

import org.pfaa.block.CompositeBlock;
import org.pfaa.block.CompositeBlockAccessors;
import org.pfaa.geologica.Geologica;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StairsBlock extends BlockStairs implements ProxyBlock, CompositeBlockAccessors {

	private final CompositeBlock modelBlock;
	private final int modelBlockMeta;
	private boolean defaultRendererEnabled;
	
	public StairsBlock(CompositeBlock block, int meta) {
		super(block, meta);
		this.modelBlock = block;
		this.modelBlockMeta = meta;
		this.setLightOpacity(0); // workaround for lighting issue
		this.useNeighborBrightness = true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return modelBlock.getIcon(side, modelBlockMeta);
	}

	public Block getModelBlock() {
		return modelBlock;
	}

	public int getModelBlockMeta() {
		return modelBlockMeta;
	}

	@Override
	public String getBlockNameSuffix(int meta) {
		return null;
	}

	@Override
	public int getMetaCount() {
		return 0;
	}

	@Override
	public boolean enableOverlay() {
		return modelBlock.enableOverlay();
	}

	@Override
	public void disableOverlay() {
		modelBlock.disableOverlay();
	}

	@Override
	public boolean canRenderInPass(int pass) {
		return modelBlock.canRenderInPass(pass);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return modelBlock.getRenderBlockPass();
	}

}
