package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandFactory
{
    private final static Logger logger = LogManager.getLogger(CommandFactory.class);

    public static Command build(String commandLine)
    {
        if (commandLine == null) return null;
        logger.debug("Processing ... {}", commandLine);

        String[] parts = commandLine.split(" ");
        String command = parts[0];

        switch (command.toUpperCase())
        {
            case "GET":
                return new Get(parts[1]);
            case "SET":
                return new Set(parts[1], parts[2]);
            case "SIZE":
                return new Size();
            case "DELETE":
                return new Delete(parts[1]);
            case "EXIT":
                return new Exit();
            default:
                return null;
        }
    }
}
