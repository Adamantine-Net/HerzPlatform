package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.world.EnumDifficulty;
public class DifficultyChangeEvent extends Event {
    public final EnumDifficulty difficulty;
    public DifficultyChangeEvent(EnumDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}
