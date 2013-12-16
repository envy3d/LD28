/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.envy3d.ld28.map.Map;
import com.envy3d.ld28.unit.Castle;
import com.envy3d.ld28.unit.Player;
import com.envy3d.ld28.unit.Unit;

public class PlayData {
	public static boolean playerAlive = true;
	public static boolean castleAlive = true;
	
	public static int currentHour = 0;
	public static int currentDay = 0;
	
	public static Array<Unit> units;
	public static Map map;
	public static OrthographicCamera gameCamera;
	public static Player player;
	public static Castle castle;
	
	public static void reset() {
		playerAlive = true;
		castleAlive = true;
		
		currentHour = 0;
		currentDay = 0;
		
		units = null;
		map = null;
		gameCamera = null;
		player = null;
		castle = null;
	}
}
