package baguchan.tofudelight.item;

import baguchan.tofucraft.api.tfenergy.IEnergyContained;
import baguchan.tofucraft.api.tfenergy.IEnergyInsertable;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class TofuKnifeItem extends KnifeItem implements IEnergyInsertable, IEnergyContained {
    public TofuKnifeItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    public int getEnergy(ItemStack inst) {
        return inst.getTag() != null && inst.getTag().contains("tf_energy") ? inst.getTag().getInt("tf_energy") : 0;
    }

    public int getEnergyMax(ItemStack inst) {
        return 10000;
    }

    public void setEnergy(ItemStack inst, int amount) {
        inst.getOrCreateTag().putInt("tf_energy", amount);
    }

    public void setEnergyMax(ItemStack inst, int amount) {
    }

    @Override
    public int fill(ItemStack inst, int energy, boolean simulate) {
        int calculated = Math.min(energy, inst.getDamageValue());
        if (!simulate) {
            if (inst.getDamageValue() > 0) {
                inst.setDamageValue(Mth.clamp(inst.getDamageValue() - calculated, 0, inst.getMaxDamage()));
                return calculated * 5;
            } else {
                int calculated2 = Math.min(energy, this.getEnergyMax(inst) - this.getEnergy(inst));
                this.setEnergy(inst, this.getEnergy(inst) + calculated2);
                return calculated2;
            }
        } else {
            return 0;
        }
    }
}
