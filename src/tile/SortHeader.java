package tile;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SortHeader extends MouseAdapter {

	private static boolean sorted = true;
	private TileManagerView frame;
	
	public SortHeader(TileManagerView frame) {
		this.frame = frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		List<Tile> items = new ArrayList<>();
		Point point = e.getPoint();
		int col = frame.getTable().columnAtPoint(point);
		switch(col) {
			case 0:
				items = frame.getTileManager().sortedTile(TileSortType.ID, sorted);
				break;
			case 1:
				items = frame.getTileManager().sortedTile(TileSortType.NAME, sorted);
				break;
			case 2:
				items = frame.getTileManager().sortedTile(TileSortType.PRICE, sorted);
				break;
			case 3:
				items = frame.getTileManager().sortedTile(TileSortType.TOTAL, sorted);
				break;
			case 4:
				items = frame.getTileManager().sortedTile(TileSortType.SIZE, sorted);
				break;
			case 5:
				items = frame.getTileManager().sortedTile(TileSortType.THICKNESS, sorted);
				break;
			case 6:
				items = frame.getTileManager().sortedTile(TileSortType.MATERIAL, sorted);
				break;
			default:
				items = frame.getTileManager().sortedTile(TileSortType.ID, sorted);
				break;
		}
		frame.loadModel(items);
		sorted = !sorted;
	}
	
}
