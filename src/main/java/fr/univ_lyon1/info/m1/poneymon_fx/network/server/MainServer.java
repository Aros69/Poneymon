package fr.univ_lyon1.info.m1.poneymon_fx.network.server;

public class MainServer {

    /**
     * Lance le serveur.
     *
     * @param args args
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.open();
    }
}
