public class FactoryMaker {

    public VehicleFactory geVehicleFactory(VehicleFactoryType factoryType) {

        return (VehicleFactoryType.Land == factoryType) ? new LandVehicleFactory() :
                (VehicleFactoryType.Sky == factoryType) ? new SkyVehicleFactory() : null;

    }
}
