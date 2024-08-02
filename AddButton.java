package Ore.register;

import javax.swing.*;

/**
 * Clasa AddButton pentru a face butonul care adauga pretul introdus in
 * variabila din Register
 */
public class AddButton {
    /** Variabila de buton */
    private JButton addButton;

    /** Cream constructorul pentru a face un buton cand este initializata clasa */
    public AddButton(RegisterUI ui) {
        /** Cream butonul */
        addButton = new JButton("Add Price");
        /**
         * Cream un action listener cu scopul de a adauga pretul la variabila din
         * Register cand este apasat butonul
         */
        addButton.addActionListener(e -> {
            try {
                Double value = Double.parseDouble(ui.priceField.getText());
                Register.addPrice(value);

            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }

    public JButton getButton() {
        return addButton;
    }
}
