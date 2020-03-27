package com.eu.habbo.veto.eventloader;

import com.eu.habbo.Emulator;

public class LoadTexts {
    public static void loadTexts() {
        try {
            Emulator.getTexts().register("commands.description.cmd_rolldice", ":rolldice [amount]");
            Emulator.getTexts().register("veto.cmd_rolldice.keys", "rolldice;rollthebones;rolldices;rolld");
            Emulator.getTexts().register("veto.cmd_rolldice.rolled", "* Rolls %count% dices *");

            Emulator.getTexts().register("commands.description.cmd_closedice", ":closedice [all]");
            Emulator.getTexts().register("veto.cmd_closedice.keys", "closedice;cd;sluitdices");
            Emulator.getTexts().register("veto.cmd_closedice.keywordall", "all");
            Emulator.getTexts().register("veto.cmd_closedice.closed", "* Closes %count% dices *");





        } catch (Exception ex) {
            Emulator.getLogging().logErrorLine(ex);
        }
    }
}
