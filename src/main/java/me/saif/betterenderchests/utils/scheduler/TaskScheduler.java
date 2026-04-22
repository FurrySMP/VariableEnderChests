package me.saif.betterenderchests.utils.scheduler;

import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

import java.util.function.Consumer;

public abstract class TaskScheduler {

    protected final Plugin plugin;

    public TaskScheduler(Plugin plugin) {
        this.plugin = plugin;
    }

    public abstract void runTask(Runnable runnable);

    public abstract void runTaskAsynchronously(Runnable runnable);

    public abstract void runTaskLater(Runnable runnable, long delayTicks);

    public abstract void runTaskLaterAsynchronously(Runnable runnable, long delayTicks);

    public abstract void runTaskTimer(Runnable runnable, long delayTicks, long periodTicks);

    public abstract void runTaskTimerAsynchronously(Runnable runnable, long delayTicks, long periodTicks);

    public abstract void runTaskEntity(Entity entity, Runnable runnable, Runnable retired, long delayTicks);
    
    public void runTaskEntity(Entity entity, Runnable runnable) {
        runTaskEntity(entity, runnable, null, 0L);
    }

}
