import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class project {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<EmergencyCall> fireCalls = new ArrayList<>();
        ArrayList<EmergencyCall> policeCalls = new ArrayList<>();
        ArrayList<EmergencyCall> ambulanceCalls = new ArrayList<>();
        
        while (true) {
            System.out.println("Enter 1 to record a call, 2 to remove a call, 3 to generate reports, or 4 to quit:");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                EmergencyCall call = new EmergencyCall();
                System.out.println("Enter the caller's name:");
                scanner.nextLine();
                call.setCallerName(scanner.nextLine());
                System.out.println("Enter a brief description of the emergency:");
                call.setDescription(scanner.nextLine());
                System.out.println("Enter 1 to request fire service, 2 to request police service, 3 to request ambulance service, or any combination of these (e.g. 12 for fire and police):");
                int serviceType = scanner.nextInt();
                if (serviceType % 10 == 1) {
                    fireCalls.add(call);
                }
                if (serviceType % 10 == 2) {
                    policeCalls.add(call);
                }
                if (serviceType % 10 == 3) {
                    ambulanceCalls.add(call);
                }
            } else if (choice == 2) {
                System.out.println("Enter 1 to remove a fire call, 2 to remove a police call, 3 to remove an ambulance call:");
                int serviceType = scanner.nextInt();
                System.out.println("Enter the index of the call to remove:");
                int index = scanner.nextInt() - 1;
                if (serviceType == 1) {
                    fireCalls.remove(index);
                } else if (serviceType == 2) {
                    policeCalls.remove(index);
                } else if (serviceType == 3) {
                    ambulanceCalls.remove(index);
                }
            } else if (choice == 3) {
                System.out.println("Fire calls:");
                printCalls(fireCalls);
                System.out.println("Police calls:");
                printCalls(policeCalls);
                System.out.println("Ambulance calls:");
                printCalls(ambulanceCalls);
            } else if (choice == 4) {
                break;
            }
        }
    }
    
    private static void printCalls(ArrayList<EmergencyCall> calls) {
        Collections.sort(calls);
        for (int i = 0; i < calls.size(); i++) {
            EmergencyCall call = calls.get(i);
            System.out.println((i + 1) + ". " + call.getCallerName() + ": " + call.getDescription());
        }
    }

}

class EmergencyCall implements Comparable<EmergencyCall> {
    private String callerName;
    private String description;

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCallerName() {
        return callerName;
    }

    public String getDescription() {
        return description;
    }

   
    public int compareTo(EmergencyCall other) {
        return this.callerName.compareTo(other.callerName);
    }
}