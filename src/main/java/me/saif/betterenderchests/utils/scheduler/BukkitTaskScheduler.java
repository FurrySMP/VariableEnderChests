package me.saif.betterenderchests.utils.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

public class BukkitTaskScheduler extends TaskScheduler {

    public BukkitTaskScheduler(Plugin plugin) {
        super(plugin);
    }

    @Override
    public void runTask(Runnable runnable) {
        Bukkit.getScheduler().runTask(plugin, runnable);
    }

    @Override
    public void runTaskAsynchronously(Runnable runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable);
    }

    @Override
    public void runTaskLater(Runnable runnable, long delayTicks) {
        Bukkit.getScheduler().runTaskLater(plugin, runnable, delayTicks);
    }

    @Override
    public void runTaskLaterAsynchronously(Runnable runnable, long delayTicks) {
        Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, runnable, delayTicks);
    }

    @Override
    public void runTaskTimer(Runnable runnable, long delayTicks, long periodTicks) {
        Bukkit.getScheduler().runTaskTimer(plugin, runnable, delayTicks, periodTicks);
    }

    @Override
    public void runTaskTimerAsynchronously(Runnable runnable, long delayTicks, long periodTicks) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delayTicks, periodTicks);
    }

    @Override
    public void runTaskEntity(Entity entity, Runnable runnable, Runnable retired, long delayTicks) {
        if (delayTicks <= 0) {
            Bukkit.getScheduler().runTask(plugin, runnable);
        } else {
            Bukkit.getScheduler().runTaskLater(plugin, runnable, delayTicks);
        }
    }
}
