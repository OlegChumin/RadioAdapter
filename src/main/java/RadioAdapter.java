public class RadioAdapter {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new SimpleAmericanSocket();
        americanSocket.getPower();

        // получили americanSocket 110 вольт -> преобразовали в 220 вольт на выходе адаптера
        EuroSocket euroSocket = new SocketAdapter(americanSocket);
        Radio radio = new Radio();
        radio.listenMusic(euroSocket);
    }
}

// 220 вольт
interface EuroSocket {
   void getPower();
}

class SocketAdapter implements EuroSocket{

    AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        System.out.println("got americanSocket 110 volt");
        this.americanSocket = americanSocket;
        System.out.println("transform 110 volt to 220 volt");
    }

    @Override
    public void getPower() {
        System.out.println("get 220 volt");
    }
}

// 110 вольт
interface AmericanSocket {
    void getPower();
}

class SimpleAmericanSocket implements AmericanSocket {

    @Override
    public void getPower() {
        System.out.println("get 110 volt");
    }
}

// Radio работает только на 220 вольт
class Radio {
    public void listenMusic(EuroSocket euroSocket) {
        euroSocket.getPower();
        WavPlayer player = new WavPlayer();
    }
}