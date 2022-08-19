package com.kito.server.user_command_line;



import com.kito.server.Config;
import com.kito.server.abstractions.AbstractMessage;
import com.kito.server.utils.SmartSplitter;
import com.kito.server.utils.TextSender;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс отвечающий за работу с пользователем в интерактивном режиме
 */
public class CommandListener {

    private boolean isRunning;
    private final InputStream commandsInputStream;

    /**
     * Конструктор
     */
    public CommandListener(InputStream dis) {
        TextSender.printText("Добро пожаловать в интерактивный режим работы с коллекцией, " +
                "введите help, чтобы узнать информацию о доступных командах");
        commandsInputStream = dis;
    }

    /**
     * Метод, читающий команды из System.in до тех пор, пока не возникнет команда exit
     */
    public void readCommands() {
        isRunning = true;
        while (isRunning) {
            try {
                String line = ((DataInputStream)commandsInputStream).readUTF();  //readUTF (done)
                if ("exit".equals(line)) {
                    isRunning = false;
                    continue;
                }
                String[] inputString = SmartSplitter.smartSplit(line).toArray(new String[0]);
                String commandName = inputString[0].toLowerCase();
                String[] commandArgs = Arrays.copyOfRange(inputString, 1, inputString.length);
                TextSender.printMessage((AbstractMessage) Config.getCommandManager().execute(commandName.toLowerCase(), commandArgs));
            } catch (NoSuchElementException e) {
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
