public class Server extends Computer {

    String ram;
    String hardDiskCapasity;
    String cpu;

    public Server(String ram, String hardDiskCapasity, String cpu ){
        this.ram = ram;
        this.hardDiskCapasity = hardDiskCapasity;
        this.cpu = cpu;
    }

    @Override
    public String getHardDisk() {
        return hardDiskCapasity;
    }

    @Override
    public String getRam() {
        return ram;
    }

    @Override
    public String getCpu() {
        return cpu;
    }
}
