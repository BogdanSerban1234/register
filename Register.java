package Ore.register;

import javax.swing.*;
import java.util.HashMap;

public class Register {
    /** Variabila care contine toate <code>Item</code>ele */
    static HashMap<Integer, Item> items = new HashMap<>();
    /**
     * Variabila care contine nr de bani care este pus la acel moment pentru primire
     * dupa vindere
     */
    static Double sumPut;
    /** Variabila care contine numarul de bani detinuti */
    static Double money;
    /** Variabila care contine <code>Item</code>ul care este vandut la moment */
    static Item currentItem;
    /** Variabila care contine numarul de <code>Item</code>e din magazin */
    static int itemnr;

    /** Initializeaza toate variabliele importante */
    private static void init() {
        /** Punem valori variabilelor cand este chemata funcitia */

        items.put(0, new Item(10.99, "1 Lays Chips", 30));
        items.put(1, new Item(549.99, "2 TV", 5));
        items.put(2, new Item(1500, "3 Dacia car", 1));
        items.put(3, new Item(24.57, "4 Paper", 24));
        items.put(4, new Item(50.99, "5 Meds", 30));
        sumPut = 0.0;
        money = 0.0;
        currentItem = items.get(0);
        itemnr = 5;

    }

    /**
     * Cheama
     * UI-ul pentru ca utilizatorul sa il vada
     */
    public static void main(String[] args) {
        init();
        SwingUtilities.invokeLater(() -> {
            new RegisterUI();
        });

    }

    /** Adauga price-ul la <code>sumPut</code> */
    static void addPrice(Double value) {
        sumPut += value;
    }

    /** Adauga bani care sunt primiti */
    static void pay() {
        money += sumPut;
    }

    /** Reseteaza bani introdusi */
    static void Start() {
        sumPut = 0.0;
        RegisterUI.nextItem();
    }

    /** Incearca sa completeze tranzactia */
    static String TryComplete() {
        if (sumPut <= currentItem.value) {
            return propozitii.MULTUMESC.getItem();
        } else if (sumPut > currentItem.value) {
            return propozitii.SUPARAT.getItem();
        } else {
            return "Uh, eroare";
        }
    }
}

/** Propozitii cu care clientul poate raspunde */
enum propozitii {
    MULTUMESC, SUPARAT;

    public String getItem() {

        switch (this) {
            case MULTUMESC:

                return "Va multumesc mult ";

            case SUPARAT:

                return "Ma duc de aici si nu mai vin de la preturile tale imense!! ";

            default:
                return null;

        }

    }
}

/** Clasa Item care contine toate informatiile despre un item */
class Item {
    Double value;
    String name;
    int stock;

    public Item(double value, String name, int stock) {
        this.value = value;
        this.name = name;
        this.stock = stock;
    }

    public String toString() {
        return value + " " + name + " " + stock;
    }
}
