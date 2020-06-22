public abstract class Computer {

    public abstract String getHardDisk();

    public abstract String getRam();

    public abstract String getCpu();

    @Override
    public String toString() {
        return "HardDisk Capacity : " + getHardDisk() + "\n"
                + "Ram Capacity :" + getRam() + "\n"
                + "Cpu :" + getCpu()
                ;
    }
}
