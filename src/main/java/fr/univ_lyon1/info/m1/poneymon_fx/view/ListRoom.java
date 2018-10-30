package fr.univ_lyon1.info.m1.poneymon_fx.view;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ListRoom extends Parent {
    private VBox listroom;
    private ButtonMenu btnjoin;
    private ButtonMenu btnhost;
    private ButtonMenu btnrefresh;
    private ButtonMenu btnback;
    private RadioButton essai1;
    private RadioButton essai2;
    private RadioButton essai3;
    private GridPane yolo;

    /**
     * Constructor.
     * 
     * @param x int
     * @param y int
     */
    public ListRoom(int x, int y) {
        listroom = new VBox(10);
        listroom.setTranslateX(x / 10);
        listroom.setTranslateY(y / 11);

        btnjoin = new ButtonMenu("join");
        btnhost = new ButtonMenu("host");
        btnrefresh = new ButtonMenu("refresh");
        btnback = new ButtonMenu("back");

        essai1 = new RadioButton("essai1");
        essai2 = new RadioButton("essai2");
        essai3 = new RadioButton("essai3");

        // ----------> changement d'élement
        yolo = new GridPane();
        Label labelTitle = new Label("List");
        yolo.add(labelTitle, 2, 2);

        listroom.getChildren().addAll(btnjoin, btnhost, btnrefresh, btnback, essai1, essai2, essai3, yolo);

        getChildren().addAll(listroom);

    }

    /**
     * Get the button join.
     *
     * @return field btnSolo;
     */
    public ButtonMenu getBtnJoin() {
        return btnjoin;
    }

    /**
     * Get the button play.
     *
     * @return field btnhost;
     */
    public ButtonMenu getBtnHost() {
        return btnhost;
    }

    /**
     * Get the button play.
     *
     * @return field refresh
     */
    public ButtonMenu getBtnRefresh() {
        return btnrefresh;
    }

    public ButtonMenu getBtnBack() {
        return btnback;
    }

}
