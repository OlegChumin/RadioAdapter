import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class WavPlayer {
    String audioFile = "C:\\Users\\tschu\\IdeaProjects\\demo\\RadioAdapter\\src\\main\\resources\\LookHereIsRadio.wav";

    AudioInputStream audioInputStream;

    {
        try {
            // загрузка аудиофайла
            audioInputStream = AudioSystem.getAudioInputStream(new File(audioFile));

            // Получение формата аудиофайла
            AudioFormat format = audioInputStream.getFormat();

            //Создаем данные для воспроизведения
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            // Получаем устройства для воспроизведения
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);

            line.open(format);
            line.start();
            // чтение аудиоданных
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                line.write(buffer, 0,  bytesRead);
            }
//            Thread.sleep(10_000);
//            line.stop();

        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
