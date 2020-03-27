package com.eu.habbo.veto.eventloader;

public class loadAll {
    public static void loadAll() throws Exception {
        LoadPlayerCommands.loadPlayerCommands();
        LoadTexts.loadTexts();
        LoadConfig.loadConfig();

    }
}
