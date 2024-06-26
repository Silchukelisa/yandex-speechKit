package org.tyt;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import syandex.cloud.api.ai.tts.v3.Speechkit;
import syandex.cloud.api.ai.tts.v3.SynthesizerGrpc;


import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
/*public class Client {
    private final SynthesizerGrpc.SynthesizerStub stub;

    public Client(String host, int port, String apiKey) {
        this.stub = ttsV3Client(host, port, apiKey);
    }

    private static SynthesizerGrpc.SynthesizerStub ttsV3Client(String host, int port, String apiKey) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .build();

        //Создаем объект Metadata, который будет содержать метаданные (заголовки) для gRPC запросов
        Metadata headers = new Metadata();
        headers.put(Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER), "Api-Key " + apiKey);
        //Генерируем случайный уникальный идентификатор запрса. Для тех. поддержки в случае проблем
        String requestId = UUID.randomUUID().toString();
        headers.put(Metadata.Key.of("x-client-request-id", Metadata.ASCII_STRING_MARSHALLER), requestId);
        return SynthesizerGrpc.newStub(channel).withInterceptors(MetadataUtils.newAttachHeadersInterceptor(headers));
    }

    public void synthesize(String text, File output) throws UnsupportedAudioFileException, IOException {
        Speechkit.UtteranceSynthesisRequest request = Speechkit.UtteranceSynthesisRequest
                .newBuilder()
                .setText(text)
                .setOutputAudioSpec(Speechkit.AudioFormatOptions
                        .newBuilder()
                        .setContainerAudio(Speechkit.ContainerAudio
                                .newBuilder()
                                .setContainerAudioType(Speechkit.ContainerAudio.ContainerAudioType.WAV)
                                .build()))
                .setLoudnessNormalizationType(Speechkit.UtteranceSynthesisRequest.LoudnessNormalizationType.LUFS)
                .addHints(Speechkit
                        .Hints
                        .newBuilder()
                        .setVoice("alexander")
                        .build())
                .build();

        TtsStreamObserver observer = new TtsStreamObserver();
        stub.utteranceSynthesis(request,observer);

        //Максимальная длительность переданного аудио за всю сессию
        byte[] bytes = observer.awaitResult(5000);

        // create audio stream with default settings
        var audioStream = AudioSystem.getAudioInputStream(new ByteArrayInputStream(bytes));

        // write results to file
        AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE,output);
    }

    static class TtsStreamObserver implements StreamObserver<Speechkit.UtteranceSynthesisResponse> {

        private static CountDownLatch count = new CountDownLatch(1);
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        @Override
        public void onNext(Speechkit.UtteranceSynthesisResponse utteranceSynthesisResponse) {
            if (utteranceSynthesisResponse.hasAudioChunk()) {
                try {
                    result.write(utteranceSynthesisResponse.getAudioChunk().getData().toByteArray());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("Streaming error occurred " + throwable);
            throwable.printStackTrace();
        }

        @Override
        public void onCompleted() {
            System.out.println("Tts stream completed");
            count.countDown();
        }

        byte[] awaitResult(int timeoutSeconds){
            try{
                //Заставляет текущий поток ждать, пока счеичик не достигнет нуля, если поток не прерван или не истечет указанное время ожидания.
                count.await(timeoutSeconds, TimeUnit.SECONDS);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            return result.toByteArray();
        }
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
        String text = "Приветики пистолетики";
        String apikey = System.getenv("API_KEY");
        Client client = new Client("tts.api.cloud.yandex.net", 443, apikey);
        client.synthesize(text, new File("result.wav"));
        System.out.println("end");
    }
}*/
