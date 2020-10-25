import plane.ExperimentalPlane;
import model.ClassificationLevel;
import model.MilitaryType;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream().filter(p -> p instanceof PassengerPlane).map(p -> (PassengerPlane)p).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream().filter(p -> p instanceof  MilitaryPlane).map(p -> (MilitaryPlane)p).collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream().filter(p -> p instanceof  ExperimentalPlane).map(p -> (ExperimentalPlane)p).collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getUnclassifiedExperimentalPlanes() {
        return planes.stream().filter(p -> p instanceof ExperimentalPlane).map(p -> (ExperimentalPlane)p)
                .filter(p -> p.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED).collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return planes.stream().map(p -> (PassengerPlane)p).max(new Comparator<PassengerPlane>() {
            @Override
            public int compare(PassengerPlane o1, PassengerPlane o2) {
                return o1.getPassengersCapacity() - o2.getPassengersCapacity();
            }
        }).get();
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return planes.stream().filter(p -> p instanceof MilitaryPlane).map(p -> (MilitaryPlane)p)
                .filter(p -> p.getType() == MilitaryType.TRANSPORT).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return planes.stream().filter(p -> p instanceof MilitaryPlane).map(p -> (MilitaryPlane)p)
                .filter(p->p.getType() == MilitaryType.BOMBER).collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance()- o2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        planes.stream().forEachOrdered(p -> System.out.println(p.toString()));
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
