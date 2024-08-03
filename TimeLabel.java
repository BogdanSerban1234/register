package Ore.register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Random;
import java.util.ArrayList;

class TimeLabel {
    /**
     * Variabila care reprezinta timpul la un moment din joc
     */
    private static JLabel timeLabel;
    /** Obiect de <code>Timer</code> care este folosit la setarea la timeLabel */
    private Timer timer;
    /** Variabila Boolean care reprezinta daca este pauza sau nu */
    static Boolean isBreak = false;
    /** Variabila Boolean care reprezinta daca a fost adaugat un item sau nu */
    static Boolean addedItem = false;
    /** Variabila care reprezinta ora de acum */
    static long hours;
    /** Obiectul care reprezinta numele de <code>Item</code> */
    ArrayList<String> itemNames = new ArrayList<>();

    /** Constructor pentru a crea JLabelul timeLabel */
    public TimeLabel(RegisterUI ui) {
        timeLabel = new JLabel();
        /** Adaugam nume de iteme care pot fi adaugate dupa pauza */

        /**
         * Cream un timer si adaugam un actionListener care updateaza textul la
         * timelabel si adauga un nou item dupa fiecare pauza
         */
        timer = new Timer(50, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime currentTime = LocalTime.now();
                long moduloTime = currentTime.toNanoOfDay() / 70000000 % 1440;

                /**
                 * Despartim moduloTime in ore si minute
                 */
                hours = moduloTime / 60;
                long minutes = moduloTime % 60;

                /** Ajustam timpul ca sa para ca un ceas */
                if (minutes >= 60) {
                    hours += minutes / 60;
                    minutes = minutes % 60;
                }

                /** Ne asiguram ca timpul merge intr-ul loop de 24 de ore */
                hours = hours % 24;

                /** Formatam timpul pentru a fi HHMM */
                String formattedTime = String.format("%02d:%02d", hours, minutes);

                /** Updatam labelul ca utilizatorul sa vada timpul */
                timeLabel.setText("Time: " + formattedTime);
                /**
                 * Facem ca daca este dupa ora 18, sa nu se poata
                 * folosi butoanele de sell si sa inceapa BreakTime-ul
                 */
                if (hours > 18) {
                    timeLabel.setText(timeLabel.getText() + " BREAK TIME!!");
                    ui.addButton.setEnabled(false);
                    ui.payButton.setEnabled(false);
                    isBreak = true;
                } else {
                    isBreak = false;
                    addedItem = false;
                    ui.addButton.setEnabled(true);
                    ui.payButton.setEnabled(true);
                }
                /** adaugam un nou item pentru urmatoarea zii */
                //if (isBreak && !addedItem) {
                    //addedItem = true;
                    //int i = new Random().nextInt(itemNames.size() - 1);

                    //double price = Double.parseDouble(String.format("%.2f", new Random().nextDouble() * 100));

                    //Register.items.put(Register.itemnr,
                            //new Item(price, (1 + Register.itemnr) + " " + itemNames.get(i), new Random().nextInt(30)));
                    //itemNames.remove(i);
                    //Register.itemnr++;
                //}
            }
        });
        timer.start();
    }

    /** Functie care returneaza timeLabe-ul la alte clase */
    public static JLabel getLabel() {
        return timeLabel;
    }

    public static int getTime() {
        return (int) hours;
    }
}
