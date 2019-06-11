package com.joshchappelle.creeperx.cookie;

import com.joshchappelle.creeperx.common.Constants;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

class CookieCreeperRenderer extends MobEntityRenderer<CookieCreeperEntity, CreeperEntityModel<CookieCreeperEntity>> {

    public CookieCreeperRenderer(EntityRenderDispatcher entityRenderDispatcher_1)
    {
        super(entityRenderDispatcher_1, new CreeperEntityModel<>(), 1);
    }

    @Override
    protected Identifier getTexture(CookieCreeperEntity cookieCreeperEntity)
    {
        return new Identifier(Constants.MOD_ID + ":textures/entity/cookie_creeper/creeper.png");
    }
}