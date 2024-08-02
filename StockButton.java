package Ore.register;

import javax.swing.*;

import java.awt.GridLayout;
import java.util.Map;

class StockButton {
    /** Panoul ce contine fiecare buton si JLabel sau JTextField/JTextArea */
    JPanel panel3 = new JPanel(new GridLayout(3, 2));

    /** Constructor pentru a crea butonul cand este initializata clasa asta */
    public StockButton(RegisterUI ui) {
        /**
         * Cream butonul stockButton, un panel, 2 butoane de accept si decline si 2
         * textfielduri pentru a introduce care obiecte le vrei
         */

        panel3 = new JPanel(new GridLayout(3, 2));
        JButton accept = new JButton("Accept");
        JButton decline = new JButton("Decline");
        JButton show = new JButton("Show Stocks");
        JTextField number = new JTextField("number of items");
        JTextField name = new JTextField("number representing item");
        JTextArea stocks = new JTextArea(1, 20);
        panel3.add(number);
        panel3.add(name);
        /**
         * Action listener pentru a face ca stockul sa se duca in sus iar sa fie luati
         * bani pentru acele obiecte cand se apasa butonul
         */
        accept.addActionListener(e -> {
            try {

                for (int a : Register.items.keySet()) {
                    System.out.println(a);
                    if (a == Integer.parseInt(name.getText()) - 1) {
                        System.out.println(Integer.parseInt(name.getText()));
                        Item item = Register.items.get(a);
                        item.stock += Integer.parseInt(number.getText());
                        Register.items.put(a, item);
                        Register.money -= (Integer.parseInt(number.getText()) * (item.value * 0.75));
                        RegisterUI.moneyAmount.setText("Money: $" + Register.money);
                        ui.updateItemLabel();

                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        /** Ignoram totul daca s-a apasat decline */
        decline.addActionListener(e -> {
            try {

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        /**
         * aratam fiecare Item prin iterare
         */
        show.addActionListener(e -> {

            stocks.setText("");

            StringBuilder stockText = new StringBuilder();

            for (Map.Entry<Integer, Item> entry : Register.items.entrySet()) {
                Integer index = entry.getKey();
                Item item = entry.getValue();
                stockText.append("Index: ").append(index)
                        .append(" Name: ").append(item.name)
                        .append(" Stock: ").append(item.stock)
                        .append("\n");
            }

            stocks.setText(stockText.toString());
            // p.hide();
            // p = pf.getPopup(stockButton, panel3, stockButton.getLocationOnScreen().x,
            // stockButton.getLocationOnScreen().y + stockButton.getHeight() +
            // stocks.getHeight());
            // p.show();
        });

        panel3.add(accept);
        panel3.add(decline);
        panel3.add(show);
        panel3.add(stocks);
        /**
         * Adaugam un action listener la stockButton pentru a arata celelalte butoane si
         * textFielduri cand este apasat butonul
         */
    }

    /** Returneaza panoul (Care era buton inainte) */
    public JPanel getButton() {
        return panel3;
    }

}
