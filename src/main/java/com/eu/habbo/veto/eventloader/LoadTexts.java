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

            Emulator.getTexts().register("veto.cmd_pay.keys", "pay;transfer");
            Emulator.getTexts().register("veto.cmd_pay.incorrect.usage", "Missing arguments for pay command!");
            Emulator.getTexts().register("commands.description.cmd_pay", ":pay <username> <amount> <currency>");
            Emulator.getTexts().register("generic.habbo.notfound", "Habbo not found");
            Emulator.getTexts().register("veto.cmd_pay.self", "You cannot pay yourself, silly!");
            Emulator.getTexts().register("veto.cmd_pay.invalid_amount", "Invalid amount! Please use a positive value.");
            Emulator.getTexts().register("veto.cmd_pay.not_enough", "Cannot pay %username%. You don't have %amount% %type%!");
            Emulator.getTexts().register("veto.cmd_pay.invalid_type", "The currency %type% does not exist!");
            Emulator.getTexts().register("veto.cmd_pay.received", "%username% has paid you %amount% %type%!");
            Emulator.getTexts().register("veto.cmd_pay.transferred", "You paid %username% %amount% %type%!");



        } catch (Exception ex) {
            Emulator.getLogging().logErrorLine(ex);
        }
    }
}
