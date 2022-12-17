package me.jaysicles.teamswitcher.teamswitcher;

import me.clip.placeholderapi.PlaceholderAPI;
import me.jaysicles.teamswitcher.teamswitcher.commands.TeamSwitchCommand;
import me.jaysicles.teamswitcher.teamswitcher.utils.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
public final class TeamSwitcher extends JavaPlugin {

    private FileConfiguration config;
    private File configFile;
    private Messages messages;

    @Override
    public void onEnable() {
        // Load the configuration file
        configFile = new File(getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);

        // Register the team switch command
        this.getCommand("teamswitch").setExecutor(new TeamSwitchCommand(this));

        // Create the messages class
        messages = new Messages(config);

        // Checking/Registering for Placeholders
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            // this returns a boolean, true if your placeholder is successfully registered, false if it isn't
            PlaceholderAPI.registerPlaceholderHook(this, new Placeholders(this));
        }

    }

    @Override
    public void onDisable() {
        // Save the configuration file
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTeam(String player, String team) {
        config.set("players." + player + ".team", team);
    }

    public String getTeam(String player) {
        return config.getString("players." + player + ".team");
    }

    public List<String> getPerks(String team) {
        return config.getStringList("teams." + team + ".perks");
    }

    public Messages getMessages() {
        return messages;
    }


}
