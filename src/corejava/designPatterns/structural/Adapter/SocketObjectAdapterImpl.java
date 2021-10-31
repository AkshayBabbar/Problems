package corejava.designPatterns.structural.Adapter;

public class SocketObjectAdapterImpl implements SocketAdapter {

    private Socket socket = new Socket();

    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get240Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 2);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }

}
