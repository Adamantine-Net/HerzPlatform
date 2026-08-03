package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
public class ExplosionEvent extends Event {
    public final World world;
    public final Entity entity;
    public final double x;
    public final double y;
    public final double z;
    public final float strength;
    public ExplosionEvent(World world, Entity entity, double x, double y, double z, float strength) {
        this.world = world;
        this.entity = entity;
        this.x = x;
        this.y = y;
        this.z = z;
        this.strength = strength;
    }
}
