package com.gnct25s.command;

import me.lucko.fabric.api.permissions.v0.Permissions;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;


public class CommandHandler {
  public static void register() {
    CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
      dispatcher.register(Commands.literal("check")
          .then(Commands.literal("memory")
            .requires(Permissions.require("dencra-utils.check.memory", 1))
            .executes(Check::executeMemoryCheck)
          )
        );
    });
  }
}
