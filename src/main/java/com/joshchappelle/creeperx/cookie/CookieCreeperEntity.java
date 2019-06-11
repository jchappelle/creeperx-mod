package com.joshchappelle.creeperx.cookie;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

class CookieCreeperEntity extends CreeperEntity {

    private static int cookieDropRate = 5; //0.5% every tick
    private long cookieCooldown = 1000 * 5; //5 seconds
    private long lastCookieDropped = 0L;
    private boolean milked = false;

    private static class CookieCreeperEntityFactory implements EntityType.EntityFactory<CookieCreeperEntity>
    {
        @Override
        public CookieCreeperEntity create(EntityType<CookieCreeperEntity> type, World world) {
            return new CookieCreeperEntity(type, world);
        }
    }
    public static EntityType.EntityFactory<CookieCreeperEntity> FACTORY = new CookieCreeperEntityFactory();

    public CookieCreeperEntity(EntityType<? extends CookieCreeperEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Override
    public void tick() {
        if(milked){
            setFuseSpeed(-1);
        }
        super.tick();

        if (canDropCookie()) {
            dropItem(Items.COOKIE);
            lastCookieDropped = System.currentTimeMillis();
        }
    }

    protected boolean interactMob(PlayerEntity playerEntity_1, Hand hand_1) {
        if(!milked){
            ItemStack itemStack_1 = playerEntity_1.getStackInHand(hand_1);
            if (itemStack_1.getItem() == Items.MILK_BUCKET) {
                this.world.playSound(playerEntity_1, this.x, this.y, this.z, SoundEvents.ENTITY_WANDERING_TRADER_DRINK_MILK, this.getSoundCategory(), 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
                itemStack_1.decrement(1);
                this.milked = true;
            }
        }

        return super.interactMob(playerEntity_1, hand_1);
    }

    private boolean canDropCookie(){
        return (System.currentTimeMillis() - lastCookieDropped) > cookieCooldown &&
                random.nextInt(1000) < cookieDropRate;
    }
}
