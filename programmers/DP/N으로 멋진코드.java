import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number)
            return 1;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 1; i < 9; i++) {
            map.put(i, new HashSet<>());
        }

        // N, NN, NNN, ... 저장
        for (int i = 1; i < 9; i++) {
            int NNN = Integer.parseInt(String.valueOf(N).repeat(i));
            if (NNN == number)
                return i;
            map.get(i).add(NNN);
        }

        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int itValue1 : map.get(j)) {
                    for (int itValue2 : map.get(i - j)) {
                        for (Operator o : Operator.values()) {
                            if (o == Operator.DIV && itValue2 == 0)
                                continue; // 0 나누기 방지
                            int result = o.calculate(itValue1, itValue2);
                            if (result == number)
                                return i;
                            map.get(i).add(result);
                        }
                    }
                }
            }
        }

        return -1;
    }

    enum Operator {
        PLUS {
            public int calculate(int i, int j) {
                return i + j;
            }
        },
        MINUS {
            public int calculate(int i, int j) {
                return i - j;
            }
        },
        MUL {
            public int calculate(int i, int j) {
                return i * j;
            }
        },
        DIV {
            public int calculate(int i, int j) {
                if (j == 0)
                    return 0;
                return i / j;
            }
        };

        public abstract int calculate(int i, int j);
    }
}
