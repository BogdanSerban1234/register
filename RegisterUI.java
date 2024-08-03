package Ore.register;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class RegisterUI {
    /**
     * Frame-ul in care v-a fi pus tot programul
     */
    JFrame frame;
    /** Obiectul care da display la item-ul vandut acum */
    JLabel itemLabel;
    /** JTextField-ul in care este introdus pretul */
    JTextField priceField;
    /** Suma pusa */
    Double sumPut = 0.0;
    /** Obiectul care da display la timp */
    JLabel time;
    /** Obiectul cu care este luat timpul de acum */
    LocalTime currentTime;
    /** JLabelul care da display la ce zice customerul */
    JLabel Fraza = new JLabel();
    /** JButtonul cu care se adauga pretul */
    JButton addButton;
    /** JButtonul cu care se completeaza tranzactia */
    JButton payButton;
    /** JPanelul care reprezinta locul unde dai ReStock */
    JPanel stock;
    /** JLabelul care arata numele persoanei */
    static JLabel person;
    /** Numele posibile de persoane */
    static ArrayList<String> personNames;
    /** Cati bani are utilizatorul la moment */
    static JLabel moneyAmount;
    /** Variabila care reprezinta presoana de acum */
    int i;

    /** Constructor pentru a rula liniile de cod cand este initializata clasa */
    public RegisterUI() {
        /** Cream frame-ul */
        frame = new JFrame("Register UI");
        frame.setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        /** Facem primul panel pentru a adauga butoanele si textAreaurile */
        JPanel panel = new JPanel(new GridLayout(6, 2));
        /** Item label pentru a da informatii despre obiect */
        itemLabel = new JLabel();
        itemLabel.setFont(new Font("Consolas", Font.BOLD, 17));
        panel.add(itemLabel);
        /**
         * Price field pentru ca utilizatorul sa puna pretul corect care trebuie platit
         */
        priceField = new JTextField(10);
        priceField.setToolTipText(
                "Enter the money you want to charge, be careful do not overcharge! After that press the add price and then the pay button");
        priceField.setFont(new Font("Consolas", Font.BOLD, 17));
        panel.add(priceField);
        /** buton pentru a inserta pretul introdus */
        addButton = new AddButton(this).getButton();
        panel.add(addButton);
        /** JLabel moneyAmount care iti zice cati bani ai */
        moneyAmount = new JLabel("Money: $" + Register.money);
        payButton = new PayButton(this, moneyAmount, Fraza).getButton();
        panel.add(payButton);

        panel.add(moneyAmount);
        panel.add(Fraza);
        person = new JLabel();
        personNames = new ArrayList<>();

        personNames.add("Gigel");
        personNames.add("Vasile");
        personNames.add("Ion");
        personNames.add("Maria");
        personNames.add("Andrei");
        personNames.add("Elena");
        personNames.add("Stefan");
        personNames.add("Ana");
        personNames.add("George");
        personNames.add("Irina");
        personNames.add("Mihai");
        personNames.add("Laura");
        personNames.add("Radu");
        personNames.add("Claudia");
        personNames.add("Cristian");
        personNames.add("Monica");
        personNames.add("Paul");
        personNames.add("Gabriela");
        personNames.add("Adrian");
        personNames.add("Nicoleta");
        personNames.add("Alexandru");
        personNames.add("Luminita");
        personNames.add("Lucian");
        personNames.add("Diana");
        personNames.add("Florin");
        personNames.add("Carmen");
        personNames.add("Daniel");
        personNames.add("Oana");
        personNames.add("Marius");
        personNames.add("Ioana");
        personNames.add("Emil");
        personNames.add("Raluca");
        personNames.add("Costin");
        personNames.add("Simona");
        personNames.add("Roxana");
        personNames.add("Sorin");
        personNames.add("Delia");
        personNames.add("Victor");
        personNames.add("Elena");
        personNames.add("Ionut");
        personNames.add("Radu");
        personNames.add("Anca");
        personNames.add("Gheorghe");
        personNames.add("Nicoleta");
        personNames.add("Mihai");
        personNames.add("Cristina");
        i = new Random().nextInt(personNames.size() - 1);
        panel.add(person);
        person.setText("Name: " + personNames.get(i));
        frame.add(panel);
        /**
         * Panel2 care are un gradient pentru a arata mai bine si un JLabel time de time
         * din clasa TimeLabel pentru a arata care este timpul
         */
        GradientPanel panel2 = new GradientPanel();
        panel2.setBackground(Color.CYAN);

        time = new TimeLabel(this).getLabel();
        panel2.add(time);
        /** Stock panel pentru a cumpara obiecte cand nu le mai ai */
        stock = new StockButton(this).getButton();
        panel2.add(stock);

        frame.add(panel2);
        frame.setVisible(true);

        updateItemLabel();
    }

    /** updateItemLabel pentru a updata usor itemLabel din alte clase */
    public void updateItemLabel() {
        itemLabel.setText("Current item: " + Register.currentItem.name + " $" + Register.currentItem.value
                + " Stock left: " + Register.currentItem.stock);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegisterUI::new);
    }
    

    public static void nextItem() {
        if (new Random().nextInt(100) > 75) {
            personNames.add("Gigel");
            personNames.add("Vasile");
            personNames.add("Ion");
            personNames.add("Maria");
            personNames.add("Andrei");
            personNames.add("Elena");
            personNames.add("Stefan");
            personNames.add("Ana");
            personNames.add("George");
            personNames.add("Irina");
            personNames.add("Mihai");
            personNames.add("Laura");
            personNames.add("Radu");
            personNames.add("Claudia");
            personNames.add("Cristian");
            personNames.add("Monica");
            personNames.add("Paul");
            personNames.add("Gabriela");
            personNames.add("Adrian");
            personNames.add("Nicoleta");
            personNames.add("Alexandru");
            personNames.add("Luminita");
            personNames.add("Lucian");
            personNames.add("Diana");
            personNames.add("Florin");
            personNames.add("Carmen");
            personNames.add("Daniel");
            personNames.add("Oana");
            personNames.add("Marius");
            personNames.add("Ioana");
            personNames.add("Emil");
            personNames.add("Raluca");
            personNames.add("Costin");
            personNames.add("Simona");
            personNames.add("Roxana");
            personNames.add("Sorin");
            personNames.add("Delia");
            personNames.add("Victor");
            personNames.add("Elena");
            personNames.add("Ionut");
            personNames.add("Radu");
            personNames.add("Anca");
            personNames.add("Gheorghe");
            personNames.add("Nicoleta");
            personNames.add("Mihai");
            personNames.add("Cristina");
            int i = new Random().nextInt(personNames.size() - 1);
            person.setText("Name: " + personNames.get(i));
        }
    }
}
