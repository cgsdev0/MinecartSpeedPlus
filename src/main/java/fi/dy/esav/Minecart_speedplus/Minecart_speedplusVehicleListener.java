package fi.dy.esav.Minecart_speedplus;

import java.util.logging.Logger;

import org.bukkit.Tag;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

public class Minecart_speedplusVehicleListener implements Listener {

	public static boolean isSign(Material m) {
    return Tag.SIGNS.isTagged(m);
	}

	int[] xmodifier = { -1, 0, 1 };
	int[] ymodifier = { -2, -1, 0, 1, 2 };
	int[] zmodifier = { -1, 0, 1 };

	int cartx, carty, cartz;
	int blockx, blocky, blockz;

	Block block;
	int blockid;

	double line1;

	public static Minecart_speedplus plugin;
	Logger log = Logger.getLogger("Minecraft");

	boolean error;

	Vector flyingmod = new Vector(0.99, 0.99, 0.99);
	Vector noflyingmod = new Vector(0.95, 0.95, 0.95);

	public Minecart_speedplusVehicleListener(Minecart_speedplus instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onVehicleMove(VehicleMoveEvent event) {

		if (!(event.getVehicle() instanceof Minecart)) return;

    Minecart cart = (Minecart) event.getVehicle();
    Block below = cart.getLocation().getBlock().getRelative(BlockFace.DOWN);

    switch(below.getType()) {
      case COPPER_BLOCK:
        cart.setMaxSpeed(0.4D);
        cart.setFlyingVelocityMod(noflyingmod);
        break;
      case LAPIS_BLOCK:
        cart.setMaxSpeed(2.0D);
        cart.setFlyingVelocityMod(noflyingmod);
        break;
      case GOLD_BLOCK:
        cart.setMaxSpeed(4.0D);
        cart.setFlyingVelocityMod(noflyingmod);
        break;
      case NETHERITE_BLOCK:
        cart.setMaxSpeed(6.0D);
        cart.setFlyingVelocityMod(flyingmod);
        break;
      default:
        break;
    }
  }
}
