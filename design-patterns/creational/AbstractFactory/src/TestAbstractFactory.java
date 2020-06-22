public class TestAbstractFactory {
    public static void main(String[] args) {

       FactoryMaker factoryMaker= new FactoryMaker();
        Vehicel car = factoryMaker.geVehicleFactory(VehicleFactoryType.Land).getVehicel(VehicleType.Car);
        Vehicel van = factoryMaker.geVehicleFactory(VehicleFactoryType.Land).getVehicel(VehicleType.Van);

        Vehicel helicopter = factoryMaker.geVehicleFactory(VehicleFactoryType.Sky).getVehicel(VehicleType.Helicopter);
        Vehicel jet = factoryMaker.geVehicleFactory(VehicleFactoryType.Sky).getVehicel(VehicleType.Jet);

        car.drive();
        van.drive();
        helicopter.drive();
        jet.drive();
    }
}
