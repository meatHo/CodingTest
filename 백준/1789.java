import java.util.*;
import java.io.*;

//1
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long target = Long.parseLong(br.readLine());

        long num = 0;
        long count = 0;
        while (target > num) {
            num++;
            target = target - num;
            count++;
        }
        System.out.println(count);

    }
}
// 4 -1 =3
// 3 -2 =1

import java.util.*;
import java.io.*;

// 1
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long target = Long.parseLong(br.readLine());

        long num = 0;
        long sum = 0;
        while (target >= sum) {
            num++;
            sum += num;
        }
        if (target == sum) {
            System.out.println(num);
        } else {
            System.out.println(num - 1);
        }

    }
}
// 4 -1 =3
// 3 -2 =1