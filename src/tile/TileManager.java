package tile;

import java.util.List;

public interface TileManager {
	
	public void printInfo();
	
	public boolean addTile(Tile t);

	public boolean editTile(Tile t);

	public boolean delTile(Tile t);

	public List<Tile> searchTile(String name);

	public List<Tile> sortedTile(TileSortType type, boolean isASC);

	public List<Tile> searchTileByPrice(double price);

	public List<Tile> searchTileByMaterial(String material);
	
	public List<Tile> getList();
}
