package net.astralsight.influx.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties LEAF = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.2f)
            .fast()
            .build();


    public static final FoodProperties INFLUX_LEAF = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(2.0f)
            .alwaysEat()
            .fast()
            .build();

    public static final FoodProperties INFLUX_APPLE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.8f)
            .alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 4800, 19), 1.0f).build();

}
