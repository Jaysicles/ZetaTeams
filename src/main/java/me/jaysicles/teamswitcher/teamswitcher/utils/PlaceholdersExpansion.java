package me.jaysicles.teamswitcher.teamswitcher.utils;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.jetbrains.annotations.NotNull;

public class PlaceholdersExpansion extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "zetateams";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Jaysicles";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }
}
