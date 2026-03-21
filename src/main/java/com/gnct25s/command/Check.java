package com.gnct25s.command;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

public class Check {
  public static int executeMemoryCheck(CommandContext<CommandSourceStack> context) {
    Runtime runtime = Runtime.getRuntime();
    long usedMB = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
    long maxMB = runtime.maxMemory() / 1024 / 1024;
    double percent = (double)(runtime.totalMemory() - runtime.freeMemory()) / runtime.maxMemory() * 100;
    
    context.getSource().sendSystemMessage(
      Component.literal(
        String.format("Memory Usage: %d MB / %d MB (%.1f%%)", usedMB, maxMB, percent)
      )
    );
    return 1;
  }
}