import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

// [java-cmd-handler]
public class CmdHandler {
    public void handleCommand(Update update, TelegramClient telegramClient, String command, String response) {
        if (update.getMessage().getText().equals(command)) {
            SendMessage message = SendMessage.builder()
                    .chatId(update.getMessage().getChatId())
                    .text(response)
                    .build();
            try {
                telegramClient.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
