package fr.univ_lyon1.info.m1.poneymon_fx.network.room;

import fr.univ_lyon1.info.m1.poneymon_fx.network.client.Client;
import fr.univ_lyon1.info.m1.poneymon_fx.network.util.Password;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Room implements Serializable {
    protected int nbPlayers = 0;
    protected int maxNbPlayers;
    protected String name = "Default";
    protected Password password;
    protected boolean hasPassword = false;

    protected transient ArrayList<Client> clients;

    public Room() {
        clients = new ArrayList<>(4);
        maxNbPlayers = 4;
    }

    public Room(int nbPlayers) {
        maxNbPlayers = nbPlayers;
        clients = new ArrayList<>(maxNbPlayers);
    }

    public Room(char[] password) {
        this(password, 4);
    }

    /**
     * Initialise la salle.
     *
     * @param password  le mot de passe de la salle
     * @param nbPlayers le nombre possible de joueurs
     */
    public Room(char[] password, int nbPlayers) {
        this(nbPlayers);
        this.password = new Password(password);
        hasPassword = true;
        clients = new ArrayList<>(nbPlayers);
    }

    public Room(char[] password, int nbPlayers, String name) {
        this(password, nbPlayers);
        this.name = name;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public int getNbPlayers() {
        return nbPlayers;
    }

    /**
     * Add a client to the room.
     *
     * @param client the client that joins the room
     * @return true if the client could join
     */
    public boolean join(Client client) {
        if (nbPlayers < maxNbPlayers) {
            clients.add(client);
            nbPlayers++;
            return true;
        }
        return false;
    }

    public Password getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    /**
     * Get a client from the room.
     *
     * @param idClient the id of the client
     * @return the client
     */
    public Client getClient(int idClient) {
        int i = 0;
        while (clients.get(i).getPlayerId() != idClient) {
            ++i;
        }
        return clients.get(i);
    }

    /**
     * Retourne l'indice de la case du client dont l'id est en parametre.
     * @param idClient l'indice du client recherche
     * @return l'indice de la case de ce client dans la liste de la salle
     */
    public int getIndexClient(int idClient) {
        int i = 0;
        while (i < clients.size() && clients.get(i).getPlayerId() != idClient) {
            ++i;
        }
        if (i < clients.size()) {
            return i;
        } else {
            return -1;
        }
    }

    /**
     * Removes a client from the room.
     *
     * @param idClient the id of the client
     * @return the removed client
     */
    public synchronized Client remove(int idClient) {
        int i = getIndexClient(idClient);
        if (i != -1) {
            Client res = clients.get(i);
            clients.remove(i);
            nbPlayers--;
            return res;
        } else {
            return null;
        }

    }

    /**
     * Removes a client from the room.
     *
     * @param client the client that leaves the room
     * @return the removed client
     */
    public synchronized Client remove(Client client) {
        clients.remove(client);
        return client;
    }
}
