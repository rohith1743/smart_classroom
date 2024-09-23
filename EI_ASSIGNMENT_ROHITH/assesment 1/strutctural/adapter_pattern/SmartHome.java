
interface SmartHomeDevice {
    void powerOn();
    void powerOff();
}


class SmartBulb implements SmartHomeDevice {
    private String bulbName;

    public SmartBulb(String bulbName) {
        this.bulbName = bulbName;
    }

    public void powerOn() {
        System.out.println(bulbName + " (Wi-Fi) is now illuminated.");
    }

    public void powerOff() {
        System.out.println(bulbName + " (Wi-Fi) is now turned off.");
    }
}


interface WirelessGadget {
    void connect();
    void disconnect();
}

class BluetoothLight implements WirelessGadget {
    private String lightName;

    public BluetoothLight(String lightName) {
        this.lightName = lightName;
    }

    public void connect() {
        System.out.println(lightName + " (Bluetooth) is now linked.");
    }

    public void disconnect() {
        System.out.println(lightName + " (Bluetooth) is now unlinked.");
    }
}


class WirelessDeviceAdapter implements SmartHomeDevice {
    private WirelessGadget wirelessGadget;

    public WirelessDeviceAdapter(WirelessGadget wirelessGadget) {
        this.wirelessGadget = wirelessGadget;
    }

    public void powerOn() {
        wirelessGadget.connect();
    }

    public void powerOff() {
        wirelessGadget.disconnect();
    }
}


public class SmartHome {
    public static void main(String[] args) {
        SmartHomeDevice kitchenBulb = new SmartBulb("Kitchen Light");
        kitchenBulb.powerOn();
        kitchenBulb.powerOff();

        SmartHomeDevice livingRoomLight = new WirelessDeviceAdapter(new BluetoothLight("Living Room Lamp"));
        livingRoomLight.powerOn();
        livingRoomLight.powerOff();
    }
}
