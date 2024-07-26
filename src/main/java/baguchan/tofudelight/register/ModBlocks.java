package baguchan.tofudelight.register;

import baguchan.tofudelight.TofuDelight;
import baguchan.tofudelight.block.SoyChocolateCakeBlock;
import baguchan.tofudelight.block.TTTBurgerBlock;
import baguchan.tofudelight.block.TofuCookingPotBlock;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, TofuDelight.MODID);

    public static final DeferredHolder<Block, Block> TOFU_METAL_COOKING_POT = register("tofu_metal_cooking_pot", () -> new TofuCookingPotBlock(Block.Properties.of().mapColor(MapColor.METAL).strength(0.5F, 6.0F).sound(SoundType.LANTERN)));
    // Feasts
    public static final DeferredHolder<Block, Block> GRATIN_PUMPKIN_BLOCK = register("soy_gratin_pumpkin_block",
            () -> new FeastBlock(Block.Properties.ofFullCopy(Blocks.PUMPKIN), ModItems.GRATIN_PUMPKIN, false));
    public static final DeferredHolder<Block, Block> TTT_BURGER = register("ttt_burger",
            () -> new TTTBurgerBlock(Block.Properties.ofFullCopy(Blocks.CAKE), ModItems.TTT_BURGER_SLICE, false));
    public static final DeferredHolder<Block, Block> SOY_CHOCOLATE_CAKE_BLOCK = register("soy_chocolate_cake_block",
            () -> new SoyChocolateCakeBlock(Block.Properties.ofFullCopy(Blocks.CAKE), ModItems.SOY_CHOCOLATE_CAKE, false));

    private static <T extends Block> DeferredHolder<Block, T> baseRegister(String name, Supplier<? extends T> block, Function<DeferredHolder<Block, T>, Supplier<? extends Item>> item) {
        DeferredHolder<Block, T> register = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, item.apply(register));
        return register;
    }

    private static <T extends Block> DeferredHolder<Block, T> noItemRegister(String name, Supplier<? extends T> block) {
        DeferredHolder<Block, T> register = BLOCKS.register(name, block);
        return register;
    }

    private static <B extends Block> DeferredHolder<Block, B> register(String name, Supplier<? extends Block> block) {
        return (DeferredHolder<Block, B>) baseRegister(name, block, (object) -> ModBlocks.registerBlockItem(object));
    }

    private static <T extends Block> Supplier<BlockItem> registerBlockItem(final DeferredHolder<Block, T> block) {
        return () -> {
            if (Objects.requireNonNull(block.get()) instanceof FeastBlock) {
                return new BlockItem(Objects.requireNonNull(block.get()), new Item.Properties().stacksTo(1));
            }
            return new BlockItem(Objects.requireNonNull(block.get()), new Item.Properties());
        };
    }
}
