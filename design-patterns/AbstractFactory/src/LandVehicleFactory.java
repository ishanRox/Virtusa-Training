public class LandVehicleFactory implements VehicleFactory {


    public Vehicel getVehicel(VehicleType vehicleType) {
        return (VehicleType.Car == vehicleType) ? new Car() :
                (VehicleType.Van == vehicleType) ? new Van() : null;
    }
}
