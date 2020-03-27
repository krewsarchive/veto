package com.eu.habbo.veto.commands;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.items.interactions.InteractionDice;
import com.eu.habbo.habbohotel.rooms.RoomChatMessageBubbles;
import com.eu.habbo.habbohotel.rooms.RoomTile;
import com.eu.habbo.habbohotel.users.HabboItem;
import gnu.trove.iterator.hash.TObjectHashIterator;

public class RollDiceCommand extends Command
{
    TObjectHashIterator<HabboItem> localTObjectHashIterator;

    public RollDiceCommand(String permission, String[] keys)
    {
        super(permission, keys);
    }

    public boolean handle(GameClient gameClient, String[] strings)
            throws Exception
    {
        int count = 0;
        int max = 0;
        if (strings.length >= 2) {
            try {
                max = Integer.valueOf(strings[1]);
            }
            catch (Exception localException) {}
        }
        for (RoomTile tile : gameClient.getHabbo().getHabboInfo().getCurrentRoom().getLayout().getTilesAround(gameClient.getHabbo().getRoomUnit().getCurrentLocation())) {
            for (localTObjectHashIterator = gameClient.getHabbo().getHabboInfo().getCurrentRoom().getItemsAt(tile).iterator(); localTObjectHashIterator.hasNext();) {
                HabboItem item = (HabboItem)localTObjectHashIterator.next();
                if (((item instanceof InteractionDice)) && ((max == 0) || (count < max))) {
                    item.onClick(gameClient, gameClient.getHabbo().getHabboInfo().getCurrentRoom(), new Object[0]);
                    count++;
                }
            }
        }
        TObjectHashIterator localTObjectHashIterator;
        gameClient.getHabbo().shout(Emulator.getTexts().getValue("veto.cmd_rolldice.rolled").replace("%count%", count + ""), RoomChatMessageBubbles.ALERT);

        return true;
    }
}
