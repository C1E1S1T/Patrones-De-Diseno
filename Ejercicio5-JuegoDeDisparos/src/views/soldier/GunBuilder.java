package views.soldier;

import models.Ammo;
import models.Gun;

enum GunBuilder
{
	Nullgun
	{
		@ Override
		public Gun build(int cartridges, int bullets)
		{
			Ammo ammo = new Ammo(cartridges, bullets);
			return new models.Nullgun(ammo);
		}
	},
	Shotgun
	{

		@ Override
		public Gun build(int cartridges, int bullets)
		{
			Ammo ammo = new Ammo(cartridges, bullets);
			return new models.Shotgun(ammo);
		}
	};


	public abstract Gun build(int cartridges, int bullets);

	public static GunBuilder getBuilder(int key)
	{
		GunBuilder[] builders = GunBuilder.values();
		boolean isInTheAllowedRange = key <= builders.length && key >= 0;
		if(isInTheAllowedRange)
		{
			return builders[key];
		}
		return GunBuilder.Nullgun;
	}

}
