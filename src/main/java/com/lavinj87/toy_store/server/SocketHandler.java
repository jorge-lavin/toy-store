package com.lavinj87.toy_store.server;

import com.lavinj87.toy_store.ToyStore;
import com.lavinj87.toy_store.commands.Command;
import com.lavinj87.toy_store.commands.CommandFactory;
import com.lavinj87.toy_store.commands.Exit;
import com.lavinj87.toy_store.commands.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandler implements Runnable
{
    private final static Logger logger = LogManager.getLogger(SocketHandler.class);
    private final Socket socket;
    private final ToyStore store;

    public SocketHandler(ToyStore store, Socket socket)
    {
        this.store = store;
        this.socket = socket;
    }

    @Override
    public void run()
    {
        logger.debug("Connected: {}", socket);

        try
        {
            Scanner scanner = new Scanner(this.socket.getInputStream());
            PrintWriter writer = new PrintWriter(this.socket.getOutputStream(), true);
            while(scanner.hasNextLine())
            {
                Command command = CommandFactory.build(scanner.nextLine());
                if (command == null) continue;

                if (Exit.class.isAssignableFrom(command.getClass()))
                {
                    scanner.close();
                    return;
                }

                Response response = command.execute(store);
                writer.println(response.getValue());
            }
        }
        catch (IOException e)
        {
            logger.debug("IO error", e);
        }
        catch (Exception ex)
        {
            logger.debug("Unexpected error", ex);
        }
        try
        {
            logger.debug("Closing socket {}", socket);
            this.socket.close();
        }
        catch (IOException e)
        {
            logger.debug("An error closing the socket {}", socket, e);
        }
        logger.debug("Closed: {}", socket);
    }
}
