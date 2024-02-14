class RandomCount{

                   //Random serial Number
    public void generateRandomSerialNumber(String[] range) {
        long numberGiven = System.currentTimeMillis();
        numberGiven = Math.abs(numberGiven);
        for (int i = 0; i < range.length; i++) {
            String s = "";
            numberGiven = numberChanger(numberGiven, i);
            for (int j = 0; j < 3; j++) {
                numberGiven = Math.abs(numberGiven);
                int a = (int) (numberGiven % 10l);
                s = s + String.valueOf(a);
                System.out.print("");
                numberGiven = numberGiven / 10;
            }
            System.out.print("");
            System.out.print("");
            System.out.print("");
            range[i] = range[i]+s;
        }
    }
    //Random Department ID 
    public void generateRandomDepartmentId(String []range)
    {
        long numberGiven = System.currentTimeMillis();
        for(int i=0;i<range.length;i++)
        {
            String s = "";
            numberGiven = numberChanger(numberGiven, i);
            numberGiven = Math.abs(numberGiven);
            for(int j=0;j<3;j++)
            {
                int a = (int)(numberGiven%26l);
                s = s + String.valueOf((char)(a+97));
                System.out.print("");
                numberGiven = numberGiven/4;
            }
            System.out.print("");
            System.out.print("");
            System.out.print("");
            range[i] = range[i] + s;
        }
    }
    
   
    public void generateRandomYear(String[] range) {
        long numberGiven = System.currentTimeMillis();
        numberGiven = Math.abs(numberGiven);
        for (int i = 0; i < range.length; i++) {
            String s = "";
            numberGiven = numberChanger(numberGiven, i);
            for (int j = 0; j < 4; j++) {
                numberGiven = Math.abs(numberGiven);
                int a = (int) (numberGiven % 10l);
                s = s + String.valueOf(a);
                System.out.print("");
                numberGiven = numberGiven / 10;
            }
            System.out.print("");
            System.out.print("");
            System.out.print("");
            range[i] = s;
        }
    }
    
    
    public long numberChanger(long numberGiven,int i)
    {
        if(i % 4 == 0)
        {
            numberGiven = System.currentTimeMillis()+System.currentTimeMillis();
        }
        else if(i % 3 == 0)
        {
            numberGiven = System.nanoTime()+System.nanoTime();
        }
        else if(i % 5 == 0)
        {
            numberGiven = (numberGiven/2)+(long)Math.pow(i, 2);
        }
        else
        {
            numberGiven = numberGiven + i*i*i*i;
        }

        return numberGiven;
    }
}

class ValidateRegisterIdEx
{
     public double getValidRegistrationsCount(String []range,int length,int choice)
      {
        // int count =0;
        if(range == null )
        {
            return -1;
        }
        boolean isValid = true;
        long timeStart = System.nanoTime();
        for(int i=0;i<length;i++)
        {
            isValid = true;
            if(range[i] == null || range[i].length() != 10)
            {
                continue;
            }
            switch(choice)
            {
                case 1 :
                        if(!(isValidYear(range[i].substring(0,4))))
                        {
                            isValid= false;
                        }
                        break;
                case 2 : 
                        if(!(isValidYear1(range[i])))
                        {
                            isValid = false;
                        }
                        break;
                        case 3 :
                        if(!(isValidYear2(range[i].substring(0,4))))
                        {
                            isValid = false;
                        }
                        break;
                        case 4 :
                        if(!(isValidYear3(range[i].substring(0,4).toCharArray())))
                        {
                            isValid = false;
                        }
                        break;
                        default :
                        System.out.println("error");
                    }
                    
                    if(isValid)
                    {
                        // count++;
                    }
                }
                long timeEnd = System.nanoTime();
                double timeMillis = (double)(timeEnd - timeStart)/1000000d;
                
                return timeMillis;
            }
            


public static boolean isValidYear(String range)
{
    for(int i=0;i<4;i++)
        {
            if(!(Character.isDigit((int)range.charAt(i))))
            {
                return false;
            }
        }
        return true;
    }
    
   
    public static boolean isValidYear1(String range)
    {
        for(int i=0;i<4;i++)
        {
            int num = (int)(range.charAt(i)-48);
            // System.out.println(num);
            if(!(num >=0 && num <= 9))
            {
                return false;
            }
        }
        return true;
      }

      
      public static boolean isValidYear2(String range)
      {
        int i=0;
        int data = 0,temp =0;
        while(range.length() > i)
        {
            temp = range.charAt(i);
            data = data*10+temp;
            i++;
        }
        if(data > 0 && data <= 9999)
        {
            return true;
        }
        return false;
    }
    
  
      public static boolean isValidYear3(char  []range)
      {
        int i=0;
        while(range.length > i)
        {
            if(!Character.isDigit(range[i]))
            {
                return false;
            }
            i++;
        }
        return true;

      }


    public static boolean isValidSerialNumber(String s)
    {
        int data = Integer.parseInt(s);
            if(data < 1 && data > 50)
            {
                return false;
            }
            return true;
        }
        
        
    public static boolean isValidSerialNumber1(String s)
    {
        int enroll = 0;
        int i=0;
        while(s.length() > i)
        {
            int data = Character.getNumericValue(s.charAt(i));
            i++;
            enroll = enroll*10+data;
        }
        if(enroll >= 1 && enroll <= 50)
        {
            return true;
        }
        return false;
    }


}


class AssignExTwo{
    public static void printData(String[] range) {
        for (int i = 0; i < range.length; i++) {
            System.out.println(range[i]);
        }
    }

    public static void main(String[] args) {
        String range[] = new String[50000];
        RandomCount enroll = new RandomCount();
        enroll.generateRandomYear(range);
        enroll.generateRandomDepartmentId(range);
        enroll.generateRandomSerialNumber(range);
    
        
        ValidateRegisterIdEx list = new ValidateRegisterIdEx();
        int count =0;
        

        System.out.println("|------------------------------------------------------------------------------------------|");
        System.out.println("| Approch  :  |       50k\t\t|\t20k\t|\t10k\t|\t5k\t|");
        for(int i=1;i<=4;i++)
        {

            System.out.println("| Approch  :  |     "+list.getValidRegistrationsCount(range, 50000, i)+"\t\t|"+list.getValidRegistrationsCount(range, 20000, i)+"\t\t|"+list.getValidRegistrationsCount(range, 10000, i)+"\t\t|"+list.getValidRegistrationsCount(range, 5000, i)+"\t\t|");
        }
        System.out.println("|                                                                              \t|");
        System.out.println("|------------------------------------------------------------------------------------------|");

    //System.out.println("count : "+count);
    
    }
}
