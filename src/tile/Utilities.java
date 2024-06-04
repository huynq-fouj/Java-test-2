package tile;

import java.util.List;

public class Utilities {

	public static String formatText(String str, int maxLength) {
		String out = str;
		if(str.length() > maxLength) out = str.substring(0, maxLength - 3) + "...";
		return out;
	}

	public static void printTileList(List<Tile> items) {
		if(items.isEmpty()) {
			System.out.println("Danh sách rỗng!");
			return;
		}
		StringBuilder out = new StringBuilder();
		String line = "+------+-----------------------------------+------------+----------+---------------+--------+------------------------------+\n";
		out.append("Danh sách sản phẩm: \n");
		out.append(line);
		out.append(String.format("|%-6s|%-35s|%-12s|%-10s|%-15s|%-8s|%-30s|\n", "ID", "Tên sản phẩm", "Giá sản phẩm", "Số lượng", "Kích thước", "Độ dày", "Chất liệu"));
		out.append(line);
		items.forEach(item -> {
			out.append(String.format(
					"|%-6d|%-35s|%-12.2f|%-10d|%-15s|%-8s|%-30s|\n",
					item.getProduct_id(),
					formatText(item.getProduct_name(), 35),
					item.getProduct_price(),
					item.getProduct_total(),
					item.getSize(),
					item.getTile_thickness_format(),
					item.getTile_material()
				));
			out.append(line);
		});
		System.out.println(out);
	}
	
}
