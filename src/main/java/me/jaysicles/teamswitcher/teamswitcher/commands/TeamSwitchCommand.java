package me.jaysicles.teamswitcher.teamswitcher.commands;

import me.jaysicles.teamswitcher.teamswitcher.TeamSwitcher;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class TeamSwitchCommand implements CommandExecutor {

    private final TeamSwitcher plugin;

    public TeamSwitchCommand(TeamSwitcher plugin) {
        this.plugin = plugin;
    }

    // This method is called when the /teamswitch command is used
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            // The command was not sent by a player, so we can't process it
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            // The player did not specify a team to join, so we send them a usage message
            player.sendMessage("Usage: /teamswitch <team>");
            return true;
        }

        String team = args[0];
        if (team.equalsIgnoreCase("red")) {
            // The player wants to join the red team
            player.setPlayerListName("[Red] " + player.getName());
            // player.sendMessage("You have joined the red team!");
            plugin.getMessages().equals("messages.join_team_success");
            // Give the player the perks for the red team here
            plugin.getPerks("red").forEach(perk -> player.addPotionEffect(PotionEffectType.getByName(perk).createEffect(Integer.MAX_VALUE, 1)));
        } else if (team.equalsIgnoreCase("blue")) {
            // The player wants to join the blue team
            player.setPlayerListName("[Blue] " + player.getName());
            // player.sendMessage("You have joined the blue team!");
            plugin.getMessages().equals("messages.join_team_success");
            // Give the player the perks for the blue team here
            plugin.getPerks("blue").forEach(perk -> player.addPotionEffect(PotionEffectType.getByName(perk).createEffect(Integer.MAX_VALUE, 1)));
        } else {
            // The player specified an invalid team, so we send them an error message
            player.sendMessage("Invalid team specified. Use 'red' or 'blue'.");
        }

        return true;
    }

}
