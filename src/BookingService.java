import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private List<Train> trainList = new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();

    public BookingService(){
        trainList.add(new Train(101,"Rajdhani Express","Delhi","kanpur",100));
        trainList.add(new Train(1010,"Rajdhani Express","Delhi","Nagpur",100));
        trainList.add(new Train(101,"Rajdhani Express","Delhi","kanpur",100));
        trainList.add(new Train(101,"Rajdhani Express","Delhi","kanpur",100));
        trainList.add(new Train(101,"Rajdhani Express","Delhi","kanpur",100));
    }
}
