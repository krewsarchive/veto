package com.eu.habbo.veto.eventloader;

import com.eu.habbo.Emulator;
import com.eu.habbo.veto.commands.*;
import com.eu.habbo.habbohotel.commands.CommandHandler;

public class LoadPlayerCommands {
    public static void loadPlayerCommands() {
        try {
            CommandHandler.addCommand(new RollDiceCommand("cmd_rolldice", Emulator.getTexts().getValue("veto.cmd_rolldice.keys").split(";")));
            CommandHandler.addCommand(new CloseDiceCommand("cmd_closedice", Emulator.getTexts().getValue("veto.cmd_closedice.keys").split(";")));
        } catch (Exception ex) {
            Emulator.getLogging().logErrorLine(ex);
        }
    }
}
