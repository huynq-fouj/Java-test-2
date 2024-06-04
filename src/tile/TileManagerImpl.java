package tile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TileManagerImpl implements TileManager, Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Tile> items;
	private static final String FILE_NAME = "Tile.bin";

	public TileManagerImpl() {
		items = new ArrayList<>();
		loadData();
	}
	
	@Override
	public boolean addTile(Tile t) {
		sortedTile(TileSortType.ID, false);
		int id = 1;
		if(!items.isEmpty()) id = items.get(0).getProduct_id() + 1;
		t.setProduct_id(id);
		boolean result = items.add(t);
		if(result) saveChange();
		return result;
	}

	@Override
	public boolean editTile(Tile t) {
		for(Tile item: items) {
			if(item.getProduct_id() == t.getProduct_id()) {
				item.setProduct_name(t.getProduct_name());
				item.setProduct_price(t.getProduct_price());
				item.setProduct_total(t.getProduct_total());
				item.setTile_length(t.getTile_length());
				item.setTile_material(t.getTile_material());
				item.setTile_thickness(t.getTile_thickness());
				item.setTile_width(t.getTile_width());
				saveChange();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delTile(Tile t) {
		//Nếu t tồn tại trong danh sách thì sẽ xóa và trả về true ngược lại sẽ trả về false.
		boolean result = items.removeIf(item -> item.getProduct_id() == t.getProduct_id());
		if(result) saveChange();
		return result;
	}
	
	@Override
	public List<Tile> searchTile(String name) {
		/*
		 * Phương thức stream() chuyển đổi danh sách items thành một luồng (stream) các phần tử.
		 * Luồng này cho phép thực hiện các thao tác xử lý dữ liệu một cách tuần tự hoặc song song.
		 * Phương thức filter được sử dụng để lọc các phần tử của luồng dựa trên một điều kiện nhất định.
		 * Phương thức collect thu thập các phần tử của luồng sau khi đã qua bước lọc thành một danh sách (List).
		 * `Collectors.toList() là một collector được cung cấp bởi Java Stream API, dùng để chuyển đổi luồng thành một danh sách.
		 */
		return items.stream()
                .filter(tile -> {
					double price = 0.0;
					try {
						price = Double.parseDouble(name);
					} catch (Exception e) {}
					return tile.getProduct_name().contains(name)
						|| tile.getTile_material().contains(name)
						|| tile.getProduct_price() == price;
				}).collect(Collectors.toList());
	}

	@Override
	public List<Tile> sortedTile(TileSortType type, boolean isASC) {
		int asc = isASC ? 1 : -1;
		switch(type) {
			case PRICE:
				Collections.sort(items, (t1, t2) -> {
					int result = ((Tile)t1).getProduct_price() > ((Tile)t2).getProduct_price() ? 1 : -1;
					return result * asc;
				});
				break;
			case SIZE:
				Collections.sort(items, (t1, t2) -> {
					int result = ((Tile)t1).getArea() > ((Tile)t2).getArea() ? 1 : -1;
					return result * asc;
				});
				break;
			case THICKNESS:
				Collections.sort(items, (t1, t2) -> {
					int result = ((Tile)t1).getTile_thickness() > ((Tile)t2).getTile_thickness() ? 1 : -1;
					return result * asc;
				});
				break;
			case ID:
				Collections.sort(items, (t1, t2) -> {
					int result = ((Tile)t1).getProduct_id() > ((Tile)t2).getProduct_id() ? 1 : -1;
					return result * asc;
				});
				break;
			case NAME:
				Collections.sort(items, (t1, t2) -> {
					int result = ((Tile)t1).getProduct_name().compareTo(((Tile)t2).getProduct_name());
					return result * asc;
				});
				break;
			case MATERIAL:
				Collections.sort(items, (t1, t2) -> {
					int result = ((Tile)t1).getTile_material().compareTo(((Tile)t2).getTile_material());
					return result * asc;
				});
				break;
			case TOTAL:
				Collections.sort(items, (t1, t2) -> {
					int result = ((Tile)t1).getProduct_total() > ((Tile)t2).getProduct_total() ? 1 : -1;
					return result * asc;
				});
				break;
		}
		return items;
	}
	
	public void saveChange() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(items);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@SuppressWarnings("unchecked")
	public void loadData() {
        try {
        	createFileIfNotExists();
        	FileInputStream fi = new FileInputStream(FILE_NAME);
        	ObjectInputStream ois = new ObjectInputStream(fi);
            items = (List<Tile>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	private void createFileIfNotExists() {
		File f = new File(FILE_NAME);
    	if(!f.exists()) {
    		items = new ArrayList<Tile>();
    		saveChange();
    	}
	}

}
