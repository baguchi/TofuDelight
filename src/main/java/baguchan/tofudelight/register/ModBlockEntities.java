package baguchan.tofudelight.register;

import baguchan.tofudelight.TofuDelight;
import baguchan.tofudelight.blockentity.TofuMetalCookingPotBlockEntity;
import com.mojang.datafixers.types.Type;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TofuDelight.MODID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TofuMetalCookingPotBlockEntity>> TOFU_METAL_COOKING_POT = BLOCK_ENTITIES.register("tofu_metal_cooking_pot", () -> register(TofuDelight.MODID + ":tofu_metal_cooking_pot", BlockEntityType.Builder.of(TofuMetalCookingPotBlockEntity::new, ModBlocks.TOFU_METAL_COOKING_POT.get())));

    private static <T extends BlockEntity> BlockEntityType<T> register(String p_200966_0_, BlockEntityType.Builder<T> p_200966_1_) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, p_200966_0_);
        return p_200966_1_.build(type);
    }
}