package fr.univ_lyon1.info.m1.poneymon_fx.network.hardCodedClassForTest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class ProcessusClient implements Runnable {

    private Socket connexion = null;
    private PrintWriter writer = null;
    private BufferedInputStream reader = null;
    private String[] listCommands = {"FULL", "DATE", "HOUR", "NONE"};

    public ProcessusClient(String host, int port) {
        try {
            connexion = new Socket(host, port);
            writer = new PrintWriter(connexion.getOutputStream(), true);
            reader = new BufferedInputStream(connexion.getInputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Envois des commandes random pour tester le bon fonctionnement du serveur
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                // On envois toute les secondes un message
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                //On envoie la commande au serveur

                String commande = sendRandomCommand();
                writer.write(commande);
                writer.flush(); // Transmet réellement la commande

                System.out.println(
                        "Commande " + commande + " envoyée au serveur");

                String response = read();
                System.out.println("Réponse reçue " + response);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        writer.write("CLOSE");
        writer.flush();
        writer.close();
    }


    private String sendRandomCommand() {
        Random rand = new Random();
        return listCommands[rand.nextInt(listCommands.length)];
    }

    private String read() throws IOException {
        String response = "";
        int stream;
        byte[] b = new byte[4096];
        stream = reader.read(b);
        response = new String(b, 0, stream);
        return response;
    }
}
