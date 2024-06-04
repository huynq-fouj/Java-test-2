package tile;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TileManagerView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputId;
	private JTextField inputName;
	private JTextField inputPrice;
	private JTextField inputQuantity;
	private JTextField inputLength;
	private JTextField inputWidth;
	private JTextField inputThickness;
	private JTextField inputSearch;
	private JTable table;
	private JComboBox<String> comboBox;
	private TileManager tileManager;

	/**
	 * Create the frame.
	 */
	public TileManagerView() {
		
		tileManager = new TileManagerImpl();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1270, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(255, 255, 255));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_3, 0, 0, Short.MAX_VALUE))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		
		inputSearch = new JTextField();
		inputSearch.setToolTipText("Nhập tên sản phẩm");
		inputSearch.setColumns(10);
		//Thêm sự kiện bàn phím: khi một phím bất kỳ được release
		inputSearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				loadModelV2();
		    }
		});
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setFont(new Font("Arial", Font.BOLD, 13));
		btnTmKim.setFocusable(false);
		btnTmKim.setBackground(new Color(0, 128, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(inputSearch, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnTmKim, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTmKim, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputSearch, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		table = new JTable();
		//Gọi phương thức loadModel để set dữ liệu cho table
		loadModel();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(0, 128, 255));
		header.setForeground(new Color(255, 255, 255));
		header.setPreferredSize(new Dimension(0, 30));
		header.setFont(new Font("Arial", Font.BOLD, 13));
		header.addMouseListener(new SortHeader(this));
		table.setRowHeight(32);
		table.getSelectionModel().addListSelectionListener(e -> handleSelectRow());
		scrollPane.setViewportView(table);
		panel_3.setLayout(gl_panel_3);
		
		JButton btnNewButton = new JButton("Thêm mới");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.addActionListener(e -> handleCreate());
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setFocusable(false);
		btnCpNht.setForeground(new Color(255, 255, 255));
		btnCpNht.setBackground(new Color(30, 183, 41));
		btnCpNht.setFont(new Font("Arial", Font.BOLD, 13));
		btnCpNht.addActionListener(e -> handleUpdate());
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setFocusable(false);
		btnXa.setForeground(new Color(255, 255, 255));
		btnXa.setBackground(new Color(234, 0, 0));
		btnXa.setFont(new Font("Arial", Font.BOLD, 13));
		btnXa.addActionListener(e -> handleDelete());
		
		JButton btnCpNht_1_1 = new JButton("Đặt lại");
		btnCpNht_1_1.setFocusable(false);
		btnCpNht_1_1.setForeground(new Color(255, 255, 255));
		btnCpNht_1_1.setBackground(new Color(128, 128, 128));
		btnCpNht_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		btnCpNht_1_1.addActionListener(e -> handleReset());
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCpNht, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnXa, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCpNht_1_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCpNht_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCpNht, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXa, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		inputId = new JTextField();
		inputId.setEnabled(false);
		inputId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		inputName = new JTextField();
		inputName.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giá sản phẩm");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		inputPrice = new JTextField();
		inputPrice.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số lượng sản phẩm");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		inputQuantity = new JTextField();
		inputQuantity.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Chiều dài gạch");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Chiều rộng gạch");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		inputLength = new JTextField();
		inputLength.setToolTipText("Đơn vị cm");
		inputLength.setColumns(10);
		
		inputWidth = new JTextField();
		inputWidth.setToolTipText("Đơn vị cm");
		inputWidth.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Độ dày");
		lblNewLabel_1_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1_1_1_2_2_1 = new JLabel("Chất liệu");
		lblNewLabel_1_1_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		inputThickness = new JTextField();
		inputThickness.setToolTipText("Đơn vị cm");
		inputThickness.setColumns(10);
		
		comboBox = new JComboBox<>(TileMaterial.MATERIALS);
		//comboBox = new JComboBox<>();
		comboBox.setBackground(new Color(255, 255, 255));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(inputId, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputPrice, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputLength, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_2_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputThickness, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(inputWidth, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputQuantity, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(inputName, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_2_2_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputId, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(inputPrice, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputQuantity, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(inputLength, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputWidth, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_2_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_2_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBox)
						.addComponent(inputThickness, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Tile Manager");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		contentPane.setLayout(gl_contentPane);
	}
	
	public void loadModel() {
		table.setModel(new TileTableModel(tileManager.getList()));
	}
	
	public void loadModelV2() {
		String key = inputSearch.getText();
		List<Tile> result = tileManager.searchTile(key);
		table.setModel(new TileTableModel(result));
	}
	
	public TileManager getTileManager() {
		return tileManager;
	}
	
	public JTable getTable() {
		return table;
	}
	
	private void handleSelectRow() {
		int row = table.getSelectedRow();
		if(row != -1) {
			int id = (int) table.getValueAt(row, 0);
			Tile item = tileManager.getList().stream().filter(i -> i.getProduct_id() == id).findFirst().get();
			inputId.setText(item.getProduct_id() + "");
			inputName.setText(item.getProduct_name());
			inputPrice.setText(item.getProduct_price() + "");
			inputQuantity.setText(item.getProduct_total() + "");
			inputLength.setText(item.getTile_length() + "");
			inputWidth.setText(item.getTile_width() + "");
			inputThickness.setText(item.getTile_thickness() + "");
			comboBox.setSelectedItem(item.getTile_material());
		}
	}
	
	private boolean checkValid() {
		String strName = inputName.getText();
		String strPrice = inputPrice.getText();
		String strQuantity = inputQuantity.getText();
		String strLength = inputLength.getText();
		String strWidth = inputWidth.getText();
		String strThickness = inputThickness.getText();
		//Check name
		if(strName == null || strName.trim().equals("")) {
			JOptionPane.showConfirmDialog(this, "Trường tên sản phẩm không được để trống!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		}
		//Check price
		if(strPrice == null || strPrice.trim().equals("")) {
			JOptionPane.showConfirmDialog(this, "Trường giá sản phẩm không được để trống!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String err = "Trường giá sản phẩm phải là số thực ≥ 0!";
			try {
				double price = Double.parseDouble(strPrice);
				if(price < 0) {
					JOptionPane.showConfirmDialog(this, err, "Lỗi",
							JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(this, err, "Lỗi",
						JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		//Check quantity
		if(strQuantity == null || strQuantity.trim().equals("")) {
			JOptionPane.showConfirmDialog(this, "Trường số lượng sản phẩm không được để trống!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String err = "Trường số lượng sản phẩm phải là số nguyên ≥ 0!";
			try {
				int quantity = Integer.parseInt(strQuantity);
				if(quantity < 0) {
					JOptionPane.showConfirmDialog(this, err, "Lỗi",
							JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(this, err, "Lỗi",
						JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		//Check length
		if(strLength == null || strLength.trim().equals("")) {
			JOptionPane.showConfirmDialog(this, "Trường độ dài gạch ốp lát không được để trống!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String err = "Trường độ dài gạch ốp lát phải là số thực > 0!";
			try {
				double a = Double.parseDouble(strLength);
				if(a <= 0) {
					JOptionPane.showConfirmDialog(this, err, "Lỗi",
							JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(this, err, "Lỗi",
						JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		//Check width
		if(strWidth == null || strWidth.trim().equals("")) {
			JOptionPane.showConfirmDialog(this, "Trường độ rộng gạch ốp lát không được để trống!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String err = "Trường độ rộng gạch ốp lát phải là số thực > 0!";
			try {
				double a = Double.parseDouble(strWidth);
				if(a <= 0) {
					JOptionPane.showConfirmDialog(this, err, "Lỗi",
							JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(this, err, "Lỗi",
						JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		//Check thickness
		if(strThickness == null || strThickness.trim().equals("")) {
			JOptionPane.showConfirmDialog(this, "Trường độ dày gạch ốp lát không được để trống!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String err = "Trường độ dày gạch ốp lát phải là số thực > 0!";
			try {
				double a = Double.parseDouble(strThickness);
				if(a <= 0) {
					JOptionPane.showConfirmDialog(this, err, "Lỗi",
							JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(this, err, "Lỗi",
						JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	private void handleCreate() {
		if(checkValid()) {
			Tile item = new Tile();
			item.setProduct_name(inputName.getText().trim());
			item.setProduct_price(Double.parseDouble(inputPrice.getText()));
			item.setProduct_total(Integer.parseInt(inputQuantity.getText()));
			item.setTile_length(Double.parseDouble(inputLength.getText()));
			item.setTile_width(Double.parseDouble(inputWidth.getText()));
			item.setTile_thickness(Double.parseDouble(inputThickness.getText()));
			item.setTile_material((String) comboBox.getSelectedItem());
			if(tileManager.addTile(item)) {
				JOptionPane.showConfirmDialog(this, "Thêm mới sản phẩm thành công!", "Thành công",
						JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
				loadModel();
				handleReset();
			} else JOptionPane.showConfirmDialog(this, "Thêm mới sản phẩm không thành công!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void handleUpdate() {
		if(inputId.getText() == null || inputId.getText().trim().equals("")) return;
		if(checkValid()) {
			int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn cập nhật thông tin sản phẩm!", "Chấp nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(check == JOptionPane.YES_OPTION) {
				Tile item = new Tile();
				item.setProduct_id(Integer.parseInt(inputId.getText()));
				item.setProduct_name(inputName.getText().trim());
				item.setProduct_price(Double.parseDouble(inputPrice.getText()));
				item.setProduct_total(Integer.parseInt(inputQuantity.getText()));
				item.setTile_length(Double.parseDouble(inputLength.getText()));
				item.setTile_width(Double.parseDouble(inputWidth.getText()));
				item.setTile_thickness(Double.parseDouble(inputThickness.getText()));
				item.setTile_material((String) comboBox.getSelectedItem());
				if(tileManager.editTile(item)) {
					JOptionPane.showConfirmDialog(this, "Cập nhật thông tin sản phẩm thành công!", "Thành công",
							JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
					loadModel();
					handleReset();
				} else JOptionPane.showConfirmDialog(this, "Cập nhật thông tin sản phẩm không thành công!", "Lỗi",
						JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void handleDelete() {
		int row = table.getSelectedRow();
		if(row != -1) {
			int id = (int) table.getValueAt(row, 0);
			Tile item = tileManager.getList().stream().filter(i -> i.getProduct_id() == id).findFirst().get();
			if(item != null) {
				int check = JOptionPane.showConfirmDialog(this,
						"Bạn có chắc chắn muốn xóa sản phẩm: " + item.getProduct_name(),
						"Delete Tile",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if(check == JOptionPane.YES_OPTION) {
					if(tileManager.delTile(item)) {
						JOptionPane.showConfirmDialog(this, "Xóa sản phẩm thành công!", "Thành công",
								JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
						loadModel();
						handleReset();
					} else JOptionPane.showConfirmDialog(this, "Xóa sản phẩm không thành công!", "Lỗi",
							JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void handleReset() {
		inputId.setText("");
		inputName.setText("");
		inputPrice.setText("");
		inputQuantity.setText("");
		inputLength.setText("");
		inputWidth.setText("");
		inputThickness.setText("");
		comboBox.setSelectedIndex(0);
	}
	
}
