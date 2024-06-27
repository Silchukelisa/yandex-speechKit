package org.tyt.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.tyt.synthesis.Synthesizer;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    private Synthesizer synthesizer;

    String text = "Привет! Это бот для синтеза речи. \n" + "Используй команду /text, чтоб озвучить желаемый текст.\n" +
            "Пример: /text Привет, поиграем в древний ужас?";
    private static final Logger LOG = LoggerFactory.getLogger(Bot.class);
    private static final String START = "/start";
    private static final String TEXT = "/text";

    public Bot(@Value("${telegram.bot-token}") String botToken) {
        super(botToken);
    }

    //обрабатываются все пользовательские команды
    @Override
    public void onUpdateReceived(Update update) {
        if(!update.hasMessage() || !update.getMessage().hasText()){
            return;
        }
        String[] message = update.getMessage().getText().split(" ", 2);
        Long chatId = update.getMessage().getChatId();
        System.out.println(message[1]);
        switch (message[0]){
            case START -> {
                 sendMessage(chatId,text);
            }
            case TEXT -> {
                try {
                    synthesizer.synthesize(message[1], new File("result.wav"));
                } catch (UnsupportedAudioFileException | IOException e) {
                    throw new RuntimeException(e);
                }
                sendMessage(chatId, new File("result.wav"));
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "SpeechKit_voice_bot";
    }

    private void sendMessage(Long chatId, File voiceFile){
        SendVoice sendVoice = new SendVoice();
        sendVoice.setChatId(chatId);
        sendVoice.setVoice(new InputFile(voiceFile));
        try{
            execute(sendVoice);
        } catch (TelegramApiException e){
            LOG.error("Ошибка отправки сообщения", e);
        }
    }
    private void sendMessage(Long chatId, String text){
        String chatIdStr = String.valueOf(chatId);
        var sendMessage = new SendMessage(chatIdStr,text);
        try{
            execute(sendMessage);
        } catch (TelegramApiException e){
            LOG.error("Ошибка отправки сообщения", e);
        }
    }
}
