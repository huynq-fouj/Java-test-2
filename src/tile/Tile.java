package tile;

import java.io.Serializable;

public class Tile extends Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final double WIDTH = 0;
	private static final double LENGTH = 0;
	private static final String MATERIAL = "No Material";
	private static final double THICKNESS = 0;
	private double tile_width;
	private double tile_length;
	private String tile_material;
	private double tile_thickness;

	public Tile() {
		this(ID, NAME, PRICE, TOTAL, WIDTH, LENGTH, MATERIAL, THICKNESS);
	}
	
	public Tile(int product_id, String product_name, double product_price, int product_total, double tile_width, double tile_length, String tile_material, double tile_thickness) {
		super(product_id, product_name, product_price, product_total);
		this.tile_width = tile_width;
		this.tile_length = tile_length;
		this.tile_material = tile_material;
		this.tile_thickness = tile_thickness;
	}

	/**
	 * Chiều rộng của tấm ván ốp lát Đơn vị cm
	 * 
	 * @param tile_width
	 */
	public double getTile_width() {
		return tile_width;
	}

	/**
	 * Chiều dài của tấm ván ốp lát Đơn vị cm
	 * 
	 * @param tile_width
	 */
	public double getTile_length() {
		return tile_length;
	}

	public String getTile_material() {
		return tile_material;
	}

	/**
	 * Đơn vị cm
	 * @return
	 */
	public double getTile_thickness() {
		return tile_thickness;
	}

	/**
	 * Chiều rộng của tấm ván ốp lát Đơn vị cm
	 * 
	 * @param tile_width
	 */
	public void setTile_width(double tile_width) {
		this.tile_width = tile_width;
	}

	/**
	 * Chiều dài của tấm ván ốp lát Đơn vị cm
	 * 
	 * @param tile_width
	 */
	public void setTile_length(double tile_length) {
		this.tile_length = tile_length;
	}

	public void setTile_material(String tile_material) {
		this.tile_material = tile_material;
	}

	/**
	 * Đơn vị cm
	 * @param tile_thickness
	 */
	public void setTile_thickness(double tile_thickness) {
		this.tile_thickness = tile_thickness;
	}
	
	public String getTile_thickness_format() {
		return String.format("%.2f cm", this.tile_thickness);
	}

	public double getArea() {
		return this.tile_length * this.tile_width;
	}
	
	public String getSize() {
		return String.format("%.0f x %.0f cm", this.tile_length, this.tile_width);
	}
	
	@Override
	public String toString() {
		return "Tile [tile_width=" + tile_width + ", tile_length=" + tile_length + ", tile_material=" + tile_material
				+ ", tile_thickness=" + tile_thickness + "]";
	}

}
