import java.util.Arrays;

public class Hello {
    public static void main(String[] args){

        int[] arr = new int[5];
        for(int i=0; i<arr.length; i++){
            arr[i] = i+1;
        }
    System.out.println("[변경전]");

        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]+",");
        }

        int[] tmp = new int[arr.length*2];
//        for(int i=0; i < arr.length; i++){
//            tmp[i] = arr[i];
//        }
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        arr = tmp;
        System.out.println("[변경후]");
        for(int i=0; i<arr.length;i++){
            System.out.println("arr["+i+"]:"+arr[i]);
        }

    }
}

class By {

}

class Array{
    int test (){
        return 1;
    }
}
