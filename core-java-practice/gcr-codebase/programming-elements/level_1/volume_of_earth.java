public class volume_of_earth {
    public static void main(String[] args) {
        double radiusKm = 6378.0; // given radius in km
        double volumeKm3 = (4.0/3.0) * Math.PI * Math.pow(radiusKm, 3);
        double kmToMiles = 0.621371; // 1 km = 0.621371 miles
        double radiusMiles = radiusKm * kmToMiles;
        double volumeMiles3 = (4.0/3.0) * Math.PI * Math.pow(radiusMiles, 3);

        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
    }
}
