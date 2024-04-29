package org.game.eltsvv.IO.Console;

public class MessageService {
    IMessageConsole messageService;
    public MessageService(IMessageConsole _messageService) {
        messageService = _messageService;
    }
    public void sendToConsole(String message) {
        messageService.sendMessage(message);
    }
}
