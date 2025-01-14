package superlord.bugs.common.item;

import java.util.function.Supplier;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import superlord.bugs.init.BOItems;

@SuppressWarnings("deprecation")
public enum BOItemTiers implements Tier {
	
	MANDIBLE(2, 187, 5.0F, 2.0F, 8, () -> {
		return Ingredient.of(BOItems.MANDIBLE.get());
	}),
	TERMITE(3, 1742, 8.5F, 3.5F, 13, () -> {
		return Ingredient.of(BOItems.ROYAL_TERMOSTONE.get());
	}),
	CHITIN(2, 1023, 6.5F, 3.0F, 10, () -> {
		return Ingredient.of(BOItems.CHITIN.get());
	});
	
	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final LazyLoadedValue<Ingredient> repairMaterial;
	
	private BOItemTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairMaterial) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
	}

	@Override
	public int getUses() {
		return this.uses;
	}

	@Override
	public float getSpeed() {
		return this.speed;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.damage;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}

}
