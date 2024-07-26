package baguchan.tofudelight.item;

import baguchan.tofucraft.api.tfenergy.IEnergyInsertable;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class TofuKnifeItem extends KnifeItem implements IEnergyInsertable {
    public TofuKnifeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }
    public int fill(ItemStack inst, int energy, boolean simulate) {
        int calculated = Math.min(energy, inst.getDamageValue());
        if (!simulate && inst.getDamageValue() > 0) {
            inst.setDamageValue(Mth.clamp(inst.getDamageValue() - calculated, 0, inst.getMaxDamage()));
            return calculated * 5;
        } else {
            return 0;
        }
    }
}
