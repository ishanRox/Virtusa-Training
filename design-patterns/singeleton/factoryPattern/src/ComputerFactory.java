public class ComputerFactory {


    public static Computer getComputer(String type,String ram,String hardDisc,String cpu) {

        return (type.equalsIgnoreCase("pc"))? new Pc(ram,hardDisc,cpu):
                (type.equalsIgnoreCase("server"))?new Server(ram,hardDisc,cpu):null;
    }
}
