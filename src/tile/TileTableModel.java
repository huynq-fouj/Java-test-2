package tile;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TileTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String[] columnNames = {"ID", "Tên sản phẩm", "Giá sản phẩm", "Số lượng", "Kích thước", "Độ dày", "Chất liệu"};
    private final Class[] columnClass = new Class[] {Object.class, Object.class, String.class, String.class, String.class, String.class, String.class};
    private List<Tile> items;

    public TileTableModel(List<Tile> items) {
    	this.items = items;
    }
    
	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

	@Override
	public Object getValueAt(int row, int col) {
		Tile item = items.get(row);
		switch(col) {
			case 0: return item.getProduct_id();
			case 1: return item.getProduct_name();
			case 2: return item.getProduct_price();
			case 3: return item.getProduct_total();
			case 4: return item.getSize();
			case 5: return item.getTile_thickness_format();
			case 6: return item.getTile_material();
			default: return null;
		}
	}

//	@Override
//    public void setValueAt(Object value, int row, int col) {
//		Tile item = items.get(row);
//		switch(col) {
//			case 0: 
//				break;
//			case 1: 
//				break;
//			case 2: 
//				break;
//			case 3: 
//				break;
//			case 4: 
//				break;
//			case 5: 
//				break;
//			case 6: 
//				break;
//			default:
//				break;
//		}
//	}
	
}
