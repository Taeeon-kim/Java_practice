package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){ // 단일 instance 인스턴스 호출
        return instance;
    }

    private SingletonService(){ // 생성자를 Private으로 만들어서 외부 main에서 생성못하도록 막음
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
