package org.tyt.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

@Component
public class Bot extends TelegramLongPollingBot {

    private static final Logger LOG = LoggerFactory.getLogger(Bot.class);
    private static final String START = "/start";

    public Bot(@Value("${telegram.bot-token}") String botToken) {
        super(botToken);
    }

    //обрабатываются все пользовательские команды
    @Override
    public void onUpdateReceived(Update update) {
        if(!update.hasMessage() || !update.getMessage().hasText()){
            return;
        }
        String message = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        switch (message){
            case START :
                sendMessage(chatId,new File("result.wav"));
        }
    }

    @Override
    public String getBotUsername() {
        return "SpeechKit_voice_bot";
    }

    private void sendMessage(Long chatId, File voiceFile){
        //String chatIdStr = String.valueOf(chatId);
        SendVoice sendVoice = new SendVoice();
        sendVoice.setChatId(chatId);
        sendVoice.setVoice(new InputFile(voiceFile));
        try{
            execute(sendVoice);
        } catch (TelegramApiException e){
            LOG.error("Ошибка отправки сообщения", e);
        }
    }

}
