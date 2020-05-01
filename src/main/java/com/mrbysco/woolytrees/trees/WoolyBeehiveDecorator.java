package com.mrbysco.woolytrees.trees;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class WoolyBeehiveDecorator extends BeehiveTreeDecorator {
    public WoolyBeehiveDecorator(float probabilityIn) {
        super(probabilityIn);
    }

    @Override
    public void func_225576_a_(IWorld p_225576_1_, Random p_225576_2_, List<BlockPos> p_225576_3_, List<BlockPos> p_225576_4_, Set<BlockPos> p_225576_5_, MutableBoundingBox p_225576_6_) {
        super.func_225576_a_(p_225576_1_, p_225576_2_, p_225576_3_, p_225576_4_, p_225576_5_, p_225576_6_);
    }
}
