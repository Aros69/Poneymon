package fr.univ_lyon1.info.m1.poneymon_fx.network.command;

import fr.univ_lyon1.info.m1.poneymon_fx.network.room.ListRoom;

public class AskForWaitingRoom extends RoomCommand {
    @Override
    public void atReceive() {
        System.out.println(idPlayer + " envois : commande pour voir toutes les"
                + " parties");
        if (actualRoom == null) {
            System.err.println("Pas room assigné à la commande !");
        } else {
            (actualRoom.getClient(idPlayer)).sendCommand(
                    new ShowWaitingRoomCmd(ListRoom.getInstance().getRooms()));
        }
    }
}