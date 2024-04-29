package org.game.eltsvv.MessageConsole;

public class MessageService {
    IMessageConsole messageService;
    public MessageService(IMessageConsole _messageService) {
        messageService = _messageService;
    }
    public void sendToConsole(String message) {
        messageService.sendMessage(message);
    }
}
