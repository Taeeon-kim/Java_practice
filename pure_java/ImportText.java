import java.text.SimpleDateFormat;
import java.util.Date;


final class Singleton{
    private static Singleton s = new Singleton();

    private Singleton(){
        System.out.println("ASS: "+s);
    }

    public static Singleton getInstance(){
        if(s==null)
        {
            System.out.println("sss: "+s);
        }
        System.out.println("111: "+s);
        return s;
    }
}
 class ImportText {
    public static void main(String[] args){
//        Date today = new Date();
//        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
//        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
//
//        System.out.println("오늘 날짜는" + date.format(today));
//        System.out.println("오늘 시간는" + time.format(today));

        Singleton s= Singleton.getInstance();
        System.out.println("sss111111: "+s);
    }
}
