package com.joshchappelle.creeperx.cookie;

import com.joshchappelle.creeperx.common.ModRegistry;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;

public class Cookie {

    public static void init(){
        EntityType<CookieCreeperEntity> cookieCreeperEntityType = EntityType.Builder.create(CookieCreeperEntity.FACTORY, EntityCategory.MONSTER)
                .setSize(1, 2)
                .build("creeper");
        Registry.register(Registry.ENTITY_TYPE, ModRegistry.newId("cookie-creeper"), cookieCreeperEntityType);

        ModRegistry.register("cookie_creeper_spawn_egg", new SpawnEggItem(cookieCreeperEntityType, 15177552, 4925463, new Item.Settings().group(ItemGroup.MISC)));
        EntityRendererRegistry.INSTANCE.register(CookieCreeperEntity.class, (entityRenderDispatcher, context) -> new CookieCreeperRenderer(entityRenderDispatcher));
    }
}
