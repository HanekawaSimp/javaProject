import java.util.*;

class Project {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<EmergencyCall> fireCalls = new TreeSet<>();
        TreeSet<EmergencyCall> policeCalls = new TreeSet<>();
        TreeSet<EmergencyCall> ambulanceCalls = new TreeSet<>();

        while (true) {
            System.out.println("Emergency Call System");
            System.out.println("Please choose an option:");
            System.out.println("a. Enter 1 to record a call");
            System.out.println("b. Enter 2 to remove a call");
            System.out.println("c. Enter 3 to generate a report");
            System.out.println("d. Enter 4 to quit");

            String choice = scanner.next();

            if (choice.equals("1")) {
                EmergencyCall call = new EmergencyCall();
                System.out.println("Enter the caller's name:");
                scanner.nextLine();
                call.setCallerName(scanner.nextLine());
                System.out.println("Enter a brief description of the emergency:");
                call.setDescription(scanner.nextLine());
                System.out.println("Enter 1 to request fire service, 2 to request police service, 3 to request ambulance service, or any combination of these to request multiple services:");
                int serviceType = scanner.nextInt();
                if (serviceType == 1) {
                    call.setDescription(call.getDescription());
                    fireCalls.add(call);
                }
                if (serviceType == 2) {
                    policeCalls.add(call);
                }
                if (serviceType == 3) {
                    ambulanceCalls.add(call);
                }
                if (serviceType == 12) {
                    EmergencyCall fireCall = new EmergencyCall();
                    fireCall.setCallerName(call.getCallerName());
                    fireCall.setDescription(call.getDescription());
                    fireCalls.add(fireCall);
                    EmergencyCall policeCall = new EmergencyCall();
                    policeCall.setCallerName(call.getCallerName());
                    policeCall.setDescription(call.getDescription());
                    policeCalls.add(policeCall);
                }
                if (serviceType == 13) {
                    EmergencyCall fireCall = new EmergencyCall();
                    fireCall.setCallerName(call.getCallerName());
                    fireCall.setDescription(call.getDescription());
                    fireCalls.add(fireCall);
                    EmergencyCall ambulanceCall = new EmergencyCall();
                    ambulanceCall.setCallerName(call.getCallerName());
                    ambulanceCall.setDescription(call.getDescription());
                    ambulanceCalls.add(ambulanceCall);
                }
                if (serviceType == 23) {
                    EmergencyCall policeCall = new EmergencyCall();
                    policeCall.setCallerName(call.getCallerName());
                    policeCall.setDescription(call.getDescription());
                    policeCalls.add(policeCall);
                    EmergencyCall ambulanceCall = new EmergencyCall();
                    ambulanceCall.setCallerName(call.getCallerName());
                    ambulanceCall.setDescription(call.getDescription());
                    ambulanceCalls.add(ambulanceCall);
                }
                if (serviceType == 123) {
                    EmergencyCall fireCall = new EmergencyCall();
                    fireCall.setCallerName(call.getCallerName());
                    fireCall.setDescription(call.getDescription());
                    fireCalls.add(fireCall);
                    EmergencyCall policeCall = new EmergencyCall();
                    policeCall.setCallerName(call.getCallerName());
                    policeCall.setDescription(call.getDescription());
                    policeCalls.add(policeCall);
                    EmergencyCall ambulanceCall = new EmergencyCall();
                    ambulanceCall.setCallerName(call.getCallerName());
                    ambulanceCall.setDescription(call.getDescription());
                    ambulanceCalls.add(ambulanceCall);
                }
            } else if (choice.equals("2")) {System.out.println("Enter 1 to remove a fire call, 2 to remove a police call, 3 to remove an ambulance call:");
            int serviceType = scanner.nextInt();
            System.out.println("Enter the index of the call to remove:");
            int index = scanner.nextInt() - 1;
            if (serviceType == 1) {
                fireCalls.remove(fireCalls.toArray()[index]);
            } else if (serviceType == 2) {
                policeCalls.remove(policeCalls.toArray()[index]);
            } else if (serviceType == 3) {
                ambulanceCalls.remove(ambulanceCalls.toArray()[index]);
            }
        } else if (choice.equals("3")) {
            System.out.println("Fire calls:");
            printCalls(fireCalls);
            System.out.println("Police calls:");
            printCalls(policeCalls);
            System.out.println("Ambulance calls:");
            printCalls(ambulanceCalls);
        } else if (choice.equals("4")) {
            break;
        }
    }
}

static void printCalls(TreeSet<EmergencyCall> calls) {
    int index = 1;
    for (EmergencyCall call : calls) {
        System.out.println(index + ". " + call.getCallerName() + ": " + call.getDescription());
        index++;
    }
}
}
class EmergencyCall implements Comparable<EmergencyCall> {
    String callerName;
    String description;

    void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    void setDescription(String description) {
        this.description = description;
    }
    
     String getCallerName() {
        return callerName;
    }

    String getDescription() {
        return description;
    }

    public int compareTo(EmergencyCall other) {
        return this.callerName.compareTo(other.callerName);
    }
    
}
