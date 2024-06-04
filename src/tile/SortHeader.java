package tile;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SortHeader extends MouseAdapter {

	private static boolean sorted = true;
	//private static TileSortType sortType;
	private TileManagerView frame;
	
	public SortHeader(TileManagerView frame) {
		this.frame = frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Point point = e.getPoint();
		int col = frame.getTable().columnAtPoint(point);
		switch(col) {
			case 0:
				frame.getTileManager().sortedTile(TileSortType.ID, sorted);
				frame.loadModel();
				sorted = !sorted;
				break;
			case 1:
				frame.getTileManager().sortedTile(TileSortType.NAME, sorted);
				frame.loadModel();
				sorted = !sorted;
				break;
			case 2:
				frame.getTileManager().sortedTile(TileSortType.PRICE, sorted);
				frame.loadModel();
				sorted = !sorted;
				break;
			case 3:
				frame.getTileManager().sortedTile(TileSortType.TOTAL, sorted);
				frame.loadModel();
				sorted = !sorted;
				break;
			case 4:
				frame.getTileManager().sortedTile(TileSortType.SIZE, sorted);
				frame.loadModel();
				sorted = !sorted;
				break;
			case 5:
				frame.getTileManager().sortedTile(TileSortType.THICKNESS, sorted);
				frame.loadModel();
				sorted = !sorted;
				break;
			case 6:
				frame.getTileManager().sortedTile(TileSortType.MATERIAL, sorted);
				frame.loadModel();
				sorted = !sorted;
				break;
		}
	}
	
}
