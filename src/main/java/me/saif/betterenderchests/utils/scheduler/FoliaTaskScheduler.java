package me.saif.betterenderchests.utils.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.TimeUnit;

public class FoliaTaskScheduler extends TaskScheduler {

    public FoliaTaskScheduler(Plugin plugin) {
        super(plugin);
    }

    @Override
    public void runTask(Runnable runnable) {
        Bukkit.getGlobalRegionScheduler().run(plugin, (task) -> runnable.run());
    }

    @Override
    public void runTaskAsynchronously(Runnable runnable) {
        Bukkit.getAsyncScheduler().runNow(plugin, (task) -> runnable.run());
    }

    @Override
    public void runTaskLater(Runnable runnable, long delayTicks) {
        if (delayTicks <= 0) {
            runTask(runnable);
            return;
        }
        Bukkit.getGlobalRegionScheduler().runDelayed(plugin, (task) -> runnable.run(), delayTicks);
    }

    @Override
    public void runTaskLaterAsynchronously(Runnable runnable, long delayTicks) {
        if (delayTicks <= 0) {
            runTaskAsynchronously(runnable);
            return;
        }
        Bukkit.getAsyncScheduler().runDelayed(plugin, (task) -> runnable.run(), delayTicks * 50, TimeUnit.MILLISECONDS);
    }

    @Override
    public void runTaskTimer(Runnable runnable, long delayTicks, long periodTicks) {
        Bukkit.getGlobalRegionScheduler().runAtFixedRate(plugin, (task) -> runnable.run(), Math.max(1L, delayTicks), periodTicks);
    }

    @Override
    public void runTaskTimerAsynchronously(Runnable runnable, long delayTicks, long periodTicks) {
        Bukkit.getAsyncScheduler().runAtFixedRate(plugin, (task) -> runnable.run(), delayTicks * 50, periodTicks * 50, TimeUnit.MILLISECONDS);
    }

    @Override
    public void runTaskEntity(Entity entity, Runnable runnable, Runnable retired, long delayTicks) {
        if (delayTicks <= 0) {
            entity.getScheduler().run(plugin, (task) -> runnable.run(), retired);
        } else {
            entity.getScheduler().runDelayed(plugin, (task) -> runnable.run(), retired, delayTicks);
        }
    }
}
