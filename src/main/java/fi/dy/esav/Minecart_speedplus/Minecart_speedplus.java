package fi.dy.esav.Minecart_speedplus;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Minecart_speedplus extends JavaPlugin {

	public void onEnable() {
		Bukkit.getLogger().info(getDescription().getName() + " version " + getDescription().getVersion() + " started.");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Minecart_speedplusVehicleListener(), this);
	}

	public void onDisable() {
		Bukkit.getLogger().info(getDescription().getName() + " version " + getDescription().getVersion() + " stopped.");
	}

}
