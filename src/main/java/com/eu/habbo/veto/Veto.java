package com.eu.habbo.veto;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.users.Habbo;
import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.HabboPlugin;
import com.eu.habbo.plugin.events.emulator.EmulatorLoadedEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.eu.habbo.Emulator.ANSI_BLUE;
import static com.eu.habbo.Emulator.ANSI_WHITE;
import static com.eu.habbo.veto.eventloader.loadAll.loadAll;

/* Veto
   Your Gambling Commands right here!

   #Go Go Team Krews. Love for Harmony, Beny, Alejandro, ArpyAge, Layne, Bill, Ridge and Cronk.
 */
public class Veto extends HabboPlugin implements EventListener {
    public static Veto INSTANCE = null;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Emulator.getPluginManager().registerEvents(this, this);
        if (Emulator.isReady) {
            this.checkDatabase();
        }
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean hasPermission(Habbo habbo, String s) {
        return false;
    }

    private boolean registerPermission(String name, String options, String defaultValue, boolean defaultReturn)
    {
        try (Connection connection = Emulator.getDatabase().getDataSource().getConnection())
        {
            try (PreparedStatement statement = connection.prepareStatement("ALTER TABLE  `permissions` ADD  `" + name +"` ENUM(  " + options + " ) NOT NULL DEFAULT  '" + defaultValue + "'"))
            {
                statement.execute();
                return true;
            }
        }
        catch (SQLException e)
        {}

        return defaultReturn;
    }

    @EventHandler
    public static void onEmulatorLoaded(EmulatorLoadedEvent event) throws Exception {
        INSTANCE.checkDatabase();
        loadAll();
        System.out.println("[" + ANSI_BLUE + "OFFICIAL PLUGIN" + ANSI_WHITE + "] " + "Veto (1.0.1) has officially loaded!");
    }

    public void checkDatabase() {
        boolean reloadPermissions = false;
        reloadPermissions = registerPermission("cmd_rolldice", "'0', '1', '2'", "1", reloadPermissions);
        reloadPermissions = this.registerPermission("cmd_closedice", "'0', '1', '2'", "1", reloadPermissions);
        reloadPermissions = this.registerPermission("acc_closedice_room", "'0', '1', '2'", "2", reloadPermissions);
        reloadPermissions = this.registerPermission("cmd_pay", "'0', '1', '2'", "2", reloadPermissions);
        if (reloadPermissions)
        {
            Emulator.getGameEnvironment().getPermissionsManager().reload();
        }

    }

    public static void main(String[] args)
    {
        System.out.println("Don't run this separately");
    }
}