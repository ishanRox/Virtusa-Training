public class TestFactory {
    public static void main(String[] args) {

        Computer pc = ComputerFactory.getComputer("pc", "12gb", "1tb", "ryzen");
        Computer server = ComputerFactory.getComputer("server", "12gb", "1tb", "ThreadDipper");
        Computer error = ComputerFactory.getComputer("ssdfsferver", "12gb", "1tb", "ThreadDipper");

        System.out.println(pc);
        System.out.println();
        System.out.println(server);
        System.out.println();
        System.out.println(error);

    }
}
