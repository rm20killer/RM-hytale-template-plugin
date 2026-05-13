package org.example.plugin.Commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.example.plugin.Registration.CommandInfo;


import javax.annotation.Nonnull;

@CommandInfo(
        name = "TestCommand",
        description = "Runs a test command"
)
public class TestCommand extends AbstractPlayerCommand {

    public TestCommand(@Nonnull String name, @Nonnull String description) {
        super(name, description);

    }

    @Override
    protected void execute(@Nonnull CommandContext commandContext, @Nonnull Store<EntityStore> store, @Nonnull Ref<EntityStore> ref, @Nonnull PlayerRef playerRef, @Nonnull World world) {
        if (!(commandContext.sender() instanceof Player player)) {
            commandContext.sendMessage(Message.translation("Needs to be ran as a player"));
            return;
        }
        player.sendMessage(Message.raw("HELLO WORLD"));
    }
}
