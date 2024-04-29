package org.game.eltsvv.MessageConsole;

public class MessageConsole implements IMessageConsole {
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
