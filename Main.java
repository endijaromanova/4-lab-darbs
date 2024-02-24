// 231RDC001 Endija Romanova RDCM0 17. grupa

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("231RDC001 Endija Romanova");
		
		String fileName;
		System.out.println("input file name:");
		fileName = sc.nextLine();
		sc.close();
        FileReader fr = new FileReader(fileName);
        sc = new Scanner(fr);

        System.out.println("result: ");

        while (sc.hasNext()) {
            StringBuilder students = new StringBuilder();
            List<Integer> atzimes = new ArrayList<>();
            int skaits = 0;

            while(!sc.hasNextInt()) {
                students.append(sc.next()).append(" ");
            }
            String studentsStr = students.toString().trim();
            
            while(sc.hasNextInt()) {
                atzimes.add(sc.nextInt());
                skaits++;
            }
            
            if(skaits > 0) {
                double atzimeAVG = aprekinatAVG(atzimes);
                if(atzimeAVG <= 5) {
                    int paradi = paraduskaits(atzimes);
                    System.out.println(studentsStr + " " + paradi);
                }
            }
        }
        sc.close();
    }
    
    private static double aprekinatAVG(List<Integer> atzimes) {
        int summa = 0;
        for(int atzime : atzimes){
            summa += atzime;
        }
        return (double) summa / atzimes.size();
    }

    private static int paraduskaits(List<Integer> atzimes) { 
        int paradi = 0;
        for(int atzime : atzimes) {
            if(atzime < 4) {
                paradi++;
            }
        }
        return paradi;
    }
}