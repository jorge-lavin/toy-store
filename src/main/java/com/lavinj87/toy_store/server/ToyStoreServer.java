package com.lavinj87.toy_store.server;

import com.lavinj87.toy_store.InMemoryToyStore;
import com.lavinj87.toy_store.ToyStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * A server for a multi-player tic tac toe game. Loosely based on an example in
 * Deitel and Deitel’s “Java How to Program” book. For this project I created a
 * new application-level protocol called TTTP (for Tic Tac Toe Protocol), which
 * is entirely plain text. The messages of TTTP are:
 *
 * Client -> Server
 *     MOVE <n>
 *     QUIT
 *
 * Server -> Client
 *     WELCOME <char>
 *     VALID_MOVE
 *     OTHER_PLAYER_MOVED <n>
 *     OTHER_PLAYER_LEFT
 *     VICTORY
 *     DEFEAT
 *     TIE
 *     MESSAGE <text>
 */
public class ToyStoreServer
{
    private final static Logger logger = LogManager.getLogger(ToyStoreServer.class);

    private final static ToyStore store = new InMemoryToyStore();

    // TODO CommandLineParser ...
    // TODO Read port off args
    public static void main(String[] args) throws Exception {
        logger.info("Starting Toy Store Server ...");
        try (ServerSocket listener = new ServerSocket(58901))
        {
            Executor pool = Executors.newFixedThreadPool(200);
            while (true) {
                pool.execute(new SocketHandler(store, listener.accept()));
            }
        }
    }
}