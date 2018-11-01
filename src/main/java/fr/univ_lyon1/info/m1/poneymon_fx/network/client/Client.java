package fr.univ_lyon1.info.m1.poneymon_fx.network.client;

import fr.univ_lyon1.info.m1.poneymon_fx.model.MovingEntityModel;
import fr.univ_lyon1.info.m1.poneymon_fx.network.communication_system.CommunicationSystem;

import java.net.Socket;

/**
 * Class permettant de représenter un joueur humain aux yeux du serveur.
 */
public class Client {
    private boolean isChief = false;
    private MovingEntityModel playerCharacter;
    private CommunicationSystem communicationSystem;
    private Socket socket;

    public Client(Socket s) {
        socket = s;
    }

    public void setPlayerCharacter(MovingEntityModel playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public boolean getChief() {
        return isChief;
    }

    public void setChief(boolean chief) {
        isChief = chief;
    }
}
