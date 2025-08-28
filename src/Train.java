public class Train {
    private int trainId;
    private String trainName;
    private String source;
    private String destination;
    private int totalseats;
    private int availableSeats;

    public Train(int trainId, String trainName, String source, String destination, int totalseats) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalseats = totalseats;
        this.availableSeats = totalseats;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(int totalseats) {
        this.totalseats = totalseats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public boolean bookSeat(int count){
        if(count <= availableSeats){
            availableSeats -= count;
            return true;
        }
        return false;
    }
    public void cancelSeat(int count){
        availableSeats += count;
    }

    @Override
    public String toString() {
        return trainId + " | " + trainName + " | " + source + " | " + destination + " | "+ " Seat Available: " + availableSeats;
    }
}
