class SY2022bit002 {

    // Approach 1: Using Integer.parseInt() Directly
    public static int isValidRegistrationApproach1(String[] registrations) {
        int count = 0;
        for (String registration : registrations) {
            int lastThreeDigits = Integer.parseInt(registration.substring(7));
            if (lastThreeDigits < 50) {
                count++;
            }
        }
        return count;
    }

    // Approach 2: Using Character Comparisons
    public static int isValidRegistrationApproach2(String[] registrations) {
        int count = 0;
        for (String registration : registrations) {
            boolean isValid = true;
            for (int i = registration.length() - 3; i < registration.length(); i++) {
                if (registration.charAt(i) >= '6'){
                    isValid = false;
                    break;
                }
            }
            if(registration.length()-2 > '5' && registration.length()-1 >'0'){
            	isValid = false;
                    break;
            }
            if (isValid) {
                count++;
            }
        }
        return count;
    }

    // Approach 3: Using String Comparison
    public static int isValidRegistrationApproach3(String[] registrations) {
        int count = 0;
        for (String registration : registrations) {
            String lastThreeDigits = registration.substring(7);
            if (lastThreeDigits.compareTo("050") < 0) {
                count++;
            }
        }
        return count;
    }

    

    public static int getValidRegistrationsCount(String[] registrations) {
        int count = 0;
        for (int i = 0; i < registrations.length; i++) {
            if (registrations[i].length() == 10) {       
                boolean flag = true;
                for(int j = 0; j < registrations[i].length();j++){
                    if(j < 4){
                        if(registrations[i].charAt(j) < '0' || registrations[i].charAt(j) > '9'){
                            flag = false;           
                            break;
                        }
                    }
                    if(j >= 7){
                        if(registrations[i].charAt(j) < '0' || registrations[i].charAt(j) > '9'){
                            flag = false;               
                            break;
                        }
                    }
                }
                if(flag){
                    int year = Integer.parseInt(registrations[i].substring(0, 4));    
                    if (year >= 2000 && year <= 2024) {                               
                        String dept = registrations[i].substring(4, 7);               
                        if (dept.equalsIgnoreCase("bit") || dept.equalsIgnoreCase("bcs") || dept.equalsIgnoreCase("bch") || dept.equalsIgnoreCase("bme")) {
                            // Call the appropriate approach specific method
                            count += isValidRegistrationApproach1(new String[] {registrations[i]});
                        }
                    }
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args){
        String[] a = {"2002bcs002","2002bit002","2005bit008","2021bit050","2002bcs049","2022bch050","2005bch098","2009bit051","2002bcs043"};
        getValidRegistrationsCount(a);
    }
}

