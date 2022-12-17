package me.jaysicles.teamswitcher.teamswitcher.utils;

import me.clip.placeholderapi.PlaceholderHook;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.jaysicles.teamswitcher.teamswitcher.TeamSwitcher;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Placeholders extends PlaceholderHook {

    private final TeamSwitcher plugin;
    Player player;

    public Placeholders(TeamSwitcher plugin) {
        this.plugin = plugin;
    }

    // TEAM NAME PLACEHOLDER
    public String onPlaceholderRequest(Player p, String identifier) {
        // %zetateams_team%
        if (identifier.equals("team")) {
            return plugin.getTeam(plugin.getConfig().getString("players." + player + ".team"));
        }
        return null;
    }
}
