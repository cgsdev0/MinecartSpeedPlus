package fi.dy.esav.Minecart_speedplus;


import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

public class Minecart_speedplusVehicleListener implements Listener {

	private final static Vector flyingmod = new Vector(0.99, 0.99, 0.99);
	private final static Vector noflyingmod = new Vector(0.95, 0.95, 0.95);

	@EventHandler(priority = EventPriority.NORMAL)
	public void onVehicleMove(VehicleMoveEvent event) {

		if (!(event.getVehicle() instanceof Minecart)) return;

    Minecart cart = (Minecart) event.getVehicle();
    Block below = cart.getLocation().getBlock().getRelative(BlockFace.DOWN);

    switch(below.getType()) {
      case EXPOSED_COPPER:
      case WAXED_EXPOSED_COPPER:
      case OXIDIZED_COPPER:
      case WAXED_OXIDIZED_COPPER:
      case WEATHERED_COPPER:
      case WAXED_WEATHERED_COPPER:
      case COPPER_BLOCK:
      case WAXED_COPPER_BLOCK:
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
