package fr.univ_lyon1.info.m1.poneymon_fx.view.menu;

import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Class displaying a waiting room for multiplayer games.
 */
public class WaitingRoomView extends Parent {
    private VBox playerBox;
    private CheckBox[] checkBoxes;
    private ButtonMenu btnStart;
    private ButtonMenu btnBack;
    private int nbPlayerInRoom;
    //private boolean isHost;

    /**
     * Constructor WaitingRoomView.
     *
     * @param x         coord
     * @param y         coord
     * @param nbPlayers int
     */
    public WaitingRoomView(int x, int y, int nbPlayers) {
        nbPlayerInRoom = 0;
        playerBox = new VBox(10);
        playerBox.setTranslateX(x / 8);
        playerBox.setTranslateY(y / 6);

        checkBoxes = new CheckBox[nbPlayers];

        for (int i = 1; i <= nbPlayers; ++i) {
            checkBoxes[i - 1] = new CheckBox("Player " + i);
            checkBoxes[i - 1].setDisable(true);
            checkBoxes[i - 1].setStyle("-fx-opacity: 1");
            checkBoxes[i - 1].setFont(Font.font(15));
            playerBox.getChildren().add(checkBoxes[i - 1]);
        }

        btnStart = new ButtonMenu("Play!");
        btnBack = new ButtonMenu("Leave room");
        playerBox.getChildren().addAll(btnStart, btnBack);
        getChildren().addAll(playerBox);
    }

    /**
     * Getters of the button start.
     *
     * @return field btnStart
     */
    public ButtonMenu getBtnStart() {
        return btnStart;
    }

    /**
     * Getters of the button back.
     *
     * @return field btnBack
     */
    public ButtonMenu getBtnBack() {
        return btnBack;
    }

    /**
     * Définis le nombre de joeurs dans la salle.
     * @param nbPlayerInRoom le nombre de joueur dans la salle
     */
    public void setNbPlayerInRoom(int nbPlayerInRoom) {
        this.nbPlayerInRoom = nbPlayerInRoom;

        for (int i = 0; i < checkBoxes.length; i++) {
            if (i < nbPlayerInRoom) {
                checkBoxes[i].setSelected(true);
            } else {
                checkBoxes[i].setSelected(false);
            }
        }
    }
}
