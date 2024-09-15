import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;


public class bitsortTest {
     public static void main(String[] args) {
        int n = 100000000;
        int[] samplearray = bitsort.initArray(n);
        System.out.println(n);
        ArrayList<Integer> sections = new ArrayList<>();
        sections.add(-1);
        sections.add(n - 1);
        long startTime = System.currentTimeMillis();
        for(int i = 31; i >= 0; i--) {
            bitsort.sort(samplearray, i, n, sections);
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);     
    }

    public static void sort(int[] samplearray, int bitIndex, int n, ArrayList<Integer> sections){

        for(int index = 0; index < sections.size() - 1; index++){
            int onesIndex = sections.get(index);
            int start = sections.get(index) + 1;
            int end = sections.get(index + 1);

            for(int i = start; i <= end; i++) {
                int bit = (samplearray[i] >> bitIndex) & 1;
                if(bit == 1) {
                    ++onesIndex;
                    int temp = samplearray[onesIndex];
                    samplearray[onesIndex] = samplearray[i];
                    samplearray[i] = temp;
                }
            }
            if(onesIndex >= start && onesIndex < end){
                sections.add(index + 1, onesIndex);
                index++;
            }
            
        }

    }

    public static int[] initArray(int n) {
        int[] list = new int[n];
        Random random = new Random();
        
        for (int i = 0; i < n; i++)
        {
            list[i] = random.nextInt(100);
        }
       return list;
    }

    public static void printArray(int[] input) {
        int n = input.length;
        for(int i = n-1; i >=0; i--) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("");
    }
    
}
