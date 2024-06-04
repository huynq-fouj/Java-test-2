package tile;

import java.awt.EventQueue;

public class Main {
		
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			TileManagerView frame = new TileManagerView();
			frame.setVisible(true);
		});
	}
	
}
