package org.game.eltsvv.IO.Console;

public class MessageConsole implements IMessageConsole {
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
