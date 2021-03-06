package com.crankysupertoon.equivalentbees.init;

import com.crankysupertoon.equivalentbees.EquivalentBees;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;

public class ModBlocks {

    public static void init() {

    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

    }

    private static <T extends Block> T registerBlock(T block, @Nullable ItemBlock itemBlock, String name) {
        block.setUnlocalizedName(name);
        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        EquivalentBees.proxy.registerBlock(block);

        if(itemBlock != null) {
            itemBlock.setRegistryName(name);
            ForgeRegistries.ITEMS.register(itemBlock);
            EquivalentBees.proxy.registerItem(itemBlock);
        }
        return block;
    }

    private static <T extends Block> T registerBlock(T block, String name) {
        return registerBlock(block, null, name);
    }

    private static void registerOreDictWildcard(String oreDictName, Block block) {
        OreDictionary.registerOre(oreDictName, new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
    }
}
