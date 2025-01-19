package programmers.hash;

import java.util.HashMap;
import java.util.Arrays;

// class Solution {
//     public String solution(String[] participant, String[] completion) {
//         HashMap<String, Integer> res = new HashMap<>();
//         for (String s : completion) {
//             res.put(s, res.getOrDefault(s, 0) + 1);
//         }

//         for(String s : participant){

//             if(res.containsKey(s)&&res.get(s)>0){
//                 res.replace(s,res.get(s)-1);
//             }
//             else{
//                 return s;
//             }
//         }
//         return " ";
//     }
// }

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> res = new HashMap<>();
        for (String s : participant) {
            res.put(s, res.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            res.put(s, res.get(s) - 1);
        }

        for (String s : res.keySet()) {
            if (res.get(s) != 0) {
                return s;
            }
        }
        return " ";

    }
}