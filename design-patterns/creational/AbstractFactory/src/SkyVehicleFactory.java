public class SkyVehicleFactory implements VehicleFactory {


    public Vehicel getVehicel(VehicleType vehicleType) {
        return (VehicleType.Jet == vehicleType) ? new FighterJet() :
                (VehicleType.Helicopter == vehicleType) ? new Helicopter() : null;
    }
}
