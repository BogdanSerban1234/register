package Ore.register;

import javax.swing.*;
import java.util.Random;

/**
 * clasa <code>PayButton</code> care creaza un buton pentru a vinde un
 * <code>Item</code>
 */
class PayButton {
    /** Variabila <code>payButton</code> ce reprezinta un buton */
    private JButton payButton;

    /** Facem un constructor pentru a genera butonul de a termina o tranzactie */
    public PayButton(RegisterUI ui, JLabel moneyAmount, JLabel Fraza) {
        /**
         * Cream butonul de tranzactie si ii adaugam un ascultator de actiuni
         * -- Ascultatorul de actiuni ruleaza niste linii de cod cand butonul este
         * apasat
         */
        payButton = new JButton("Pay");
        payButton.addActionListener(e -> {
            /**
             * cream o variabila de integer care este random pentru a determina urmatorul
             * obiect
             */
            int nextItem = new Random().nextInt(Register.itemnr);
            /**
             * Daca timpul nu a trecut de ora 6 atunci ne uitam la ce a raspuns clientul si
             * schimbam variabilele conform ce a zis
             */
            if (TimeLabel.getTime() < 18) {
                if (Register.TryComplete() == propozitii.MULTUMESC.getItem() && Register.currentItem.stock > 0) {
                    Register.pay();
                    moneyAmount.setText("Money: $" + Register.money);
                    System.out.println(propozitii.MULTUMESC.getItem());
                    Fraza.setText("Va multumesc mult ");
                    for (int a : Register.items.keySet()) {
                        if (Register.currentItem.name.equals(Register.items.get(a).name)) {
                            Register.items.get(a).stock--;
                        }
                    }
                } else if (Register.TryComplete() == propozitii.SUPARAT.getItem()) {
                    Fraza.setText(propozitii.SUPARAT.getItem());
                }
                /**
                 * Setam obiectul urmator pentru a fi variabila nextItem din hashmapul items si
                 * updatam textul obiectului
                 */
                Register.currentItem = Register.items.get(nextItem);
                ui.itemLabel
                        .setText("Current item: " + Register.currentItem.name + " $" + Register.currentItem.value
                                + " Stock left: " + Register.currentItem.stock);
                Register.Start();
            }
        });
    }

    /**
     * Returnam butonul daca a fost chemata functia
     */
    public JButton getButton() {
        return payButton;
    }
}
