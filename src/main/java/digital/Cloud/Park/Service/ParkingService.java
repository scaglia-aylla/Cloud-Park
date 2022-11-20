package digital.Cloud.Park.Service;

import digital.Cloud.Park.Model.Parking;
import digital.Cloud.Park.exception.ParkingNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id = getUUID();
        var id1 = getUUID();
        Parking parking = new Parking(id, "DMS-1212", "SC", "GOL", "VERMELHO");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll(){

        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {

        return UUID.randomUUID().toString().replace("-", "");
    }

    public ParkingService() {
    }

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if(parking == null) {
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parking);
        return parking;
    }

    public Parking exit(String id) {
        return null;
    }
}
