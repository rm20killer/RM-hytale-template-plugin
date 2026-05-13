package org.example.plugin;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import org.example.plugin.Registration.AssetRegisterManager;
import org.example.plugin.Registration.RegisterManager;
import org.example.plugin.Registration.SystemRegisteration;

import javax.annotation.Nonnull;

/**
 * This class serves as the entrypoint for your plugin. Use the setup method to register into game registries or add
 * event listeners.
 */
public class ExamplePlugin extends JavaPlugin {
    private static ExamplePlugin instance;
    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public ExamplePlugin(@Nonnull JavaPluginInit init) {
        super(init);
        instance = this;
    }

    public static ExamplePlugin getInstance() {
        return instance;
    }

    @Override
    protected void setup() {
        LOGGER.atInfo().log("Setting up plugin " + this.getName()+":"+getManifest().getVersion().toString());
        //Command registering
        RegisterManager.registerCommands(this);
        //Event registering
        RegisterManager.registerEvents(this);
        //Asset registering
        AssetRegisterManager.registerAll(this);
        //System registering
        SystemRegisteration.registerSystem(this);
    }
}