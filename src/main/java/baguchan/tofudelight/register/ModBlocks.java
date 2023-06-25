package baguchan.tofudelight.register;

import baguchan.tofucraft.registry.TofuCreativeModeTab;
import baguchan.tofudelight.TofuDelight;
import baguchan.tofudelight.block.TofuCookingPotBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TofuDelight.MODID);

    public static final RegistryObject<Block> TOFU_METAL_COOKING_POT = register("tofu_metal_cooking_pot", () -> new TofuCookingPotBlock());

    private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> register = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, item.apply(register));
        return register;
    }

    private static <T extends Block> RegistryObject<T> noItemRegister(String name, Supplier<? extends T> block) {
        RegistryObject<T> register = BLOCKS.register(name, block);
        return register;
    }

    private static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends Block> block) {
        return (RegistryObject<B>) baseRegister(name, block, (object) -> ModBlocks.registerBlockItem(object, TofuCreativeModeTab.TOFUCRAFT));
    }

    private static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends Block> block, CreativeModeTab tab) {
        return (RegistryObject<B>) baseRegister(name, block, (object) -> ModBlocks.registerBlockItem(object, tab));
    }

    private static <T extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<T> block, CreativeModeTab tab) {
        return () -> {
            return new BlockItem(Objects.requireNonNull(block.get()), new Item.Properties().tab(tab));
        };
    }
}
