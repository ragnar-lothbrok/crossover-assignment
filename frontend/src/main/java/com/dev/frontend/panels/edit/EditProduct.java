package com.dev.frontend.panels.edit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dev.frontend.constants.Constants;
import com.dev.frontend.dto.ProductDto;
import com.dev.frontend.services.Services;

public class EditProduct extends EditContentPanel {
	private static final long serialVersionUID = -8971249970444644844L;
	private JTextField txtCode = new JTextField();
	private JTextField txtDescription = new JTextField();
	private JTextField txtQuantity = new JTextField();
	private JTextField txtPrice = new JTextField();

	public EditProduct() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Code"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(txtCode, gbc);
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		txtCode.setColumns(10);
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Description"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtDescription, gbc);
		txtDescription.setColumns(28);
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Price"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtPrice, gbc);
		txtPrice.setColumns(10);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(new JLabel("Quantity"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 15);
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtQuantity, gbc);
		txtQuantity.setColumns(10);
	}

	/*
	 * This method use the object returned by Services.readRecordByCode and
	 * should map it to screen widgets
	 */
	public boolean bindToGUI(Object o) {
		if (o != null) {
			ProductDto customerDto = (ProductDto) o;
			txtCode.setText(customerDto.getCode());
			txtDescription.setText(customerDto.getDescription());
			txtPrice.setText(Constants.df.format(customerDto.getPrice()));
			txtQuantity.setText(customerDto.getQuantity() + "");
			return true;
		}
		return false;
	}

	/*
	 * This method collect values from screen widgets and convert them to object
	 * of your type This object will be used as a parameter of method
	 * Services.save
	 */
	public Object guiToObject() {
		if((txtPrice.getText() != null && txtPrice.getText().length() > 0) && (txtQuantity.getText() != null && txtQuantity.getText().length() > 0)){
			return new ProductDto(txtCode.getText(), txtDescription.getText(), Double.parseDouble(txtPrice.getText()), Long.parseLong(txtQuantity.getText()));
		}
		return null;
	}

	public int getObjectType() {
		return Services.TYPE_PRODUCT;
	}

	@Override
	public String getCurrentCode() {
		return txtCode.getText();
	}

	public void clear() {
		txtCode.setText("");
		txtDescription.setText("");
		txtPrice.setText("");
		txtQuantity.setText("");
	}

	public void onInit() {

	}
}