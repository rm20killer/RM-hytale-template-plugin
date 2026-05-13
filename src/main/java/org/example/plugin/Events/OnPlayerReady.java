package org.example.plugin.Events;


import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import org.example.plugin.Registration.EventInfo;


@EventInfo(PlayerReadyEvent.class)
public class OnPlayerReady {
    public static void handle(PlayerReadyEvent event) {
        event.getPlayer().sendMessage(Message.raw("WELCOME to the world").bold(true));
    }
}
