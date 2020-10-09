package oit.is.z0282.kaizi.janken.model;

public class Janken {
    String playerHand;
    String cpuHand;

    public Janken(String playerHand) {
        this.playerHand = playerHand;
        this.cpuHand = "Gu";
    }

    public String getCpuHand() {
        return this.cpuHand;
    }

    public String getResult() {
        if (playerHand.equals(cpuHand)) {
            return "Draw";
        }
        if ((playerHand.equals("Gu") && cpuHand.equals("Pa")) || (playerHand.equals("Choki") && cpuHand.equals("Gu"))
                || (playerHand.equals("Pa") && cpuHand.equals("Choki"))) {
            return "You Lose!";
        }
        if ((playerHand.equals("Gu") && cpuHand.equals("Choki")) || (playerHand.equals("Choki") && cpuHand.equals("Pa"))
                || (playerHand.equals("Pa") && cpuHand.equals("Gu"))) {
            return "You Win!";
        }
        return "error";
    }
}