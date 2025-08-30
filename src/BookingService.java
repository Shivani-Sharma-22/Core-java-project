import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {

    private List<Train> trainList = new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();

    public BookingService(){
        trainList.add(new Train(101,"Rajdhani Express","Delhi","kanpur",100));
        trainList.add(new Train(102,"Shatabdi Express","Delhi","Nagpur",60));
        trainList.add(new Train(103,"Durunto Express","Agra","Itava",70));
        trainList.add(new Train(104,"Vande Bharat","Delhi","Goa",100));
        trainList.add(new Train(105,"Intercity Express","Delhi","Bengaluru",90));
        trainList.add(new Train(106,"Tejas Express","Delhi","Himachal Pradesh",80));
    }
    public List<Train> searchTrain(String source ,String destination){
        List<Train> res = new ArrayList<>();
        for(Train train:trainList){
            if(train.getSource().equalsIgnoreCase(source)&& train.getDestination().equalsIgnoreCase(destination) ){
                res.add(train);
            }
        }
        return res;
    }

    public Ticket bookTicket(User user,int trainId,int seatCount){
        for(Train train:trainList){
            if(train.getTrainId() == trainId){
                if(train.bookSeat(seatCount)){
                    Ticket ticket = new Ticket(user,train,seatCount);
                    ticketList.add(ticket);
                    return ticket;
                }
                else{
                    System.out.println("Not enough seat available");
                    return null;
                }
            }
        }
        System.out.println("Train Id not found");
        return null;
    }

    public List<Ticket> getTicketByUser(User user){
        List<Ticket> res = new ArrayList<>();
        for(Ticket ticket:ticketList){
            if(ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                res.add(ticket);
            }
        }
        return res;
    }

    public boolean cancelTicket(int ticketId,User user){
        Iterator<Ticket> iterator = ticketList.listIterator();
        while(iterator.hasNext()){
            Ticket ticket = iterator.next();
            if(ticket.getTicketId() == ticketId && ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName()))
            {
                Train train = ticket.getTrain();
                train.cancelSeat(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket" + ticketId + "Cancelled Successfully");
                return true;
            }
        }
        System.out.println("Ticket not found does not belong to current user");
        return false;
    }

    public void listAllTrains(){
        System.out.println("List of all train: ");
        for(Train train:trainList){
            System.out.println(train);
        }
    }
}
