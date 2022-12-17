package me.jaysicles.teamswitcher.teamswitcher;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class Messages {

    private final FileConfiguration config;
    private final Map<String, String> messages;

    public Messages(FileConfiguration config) {
        this.config = config;
        this.messages = new HashMap<>();
        loadMessages();
    }

    private void loadMessages() {
        // Load the messages from the configuration file
        for (String key : config.getConfigurationSection("messages").getKeys(false)) {
            messages.put(key, config.getString("messages." + key));
        }
    }

    public String getMessage(String key) {
        return messages.get(key);
    }

}