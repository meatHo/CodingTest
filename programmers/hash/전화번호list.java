
// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
//         String all = new String();
//         String temp = new String();

//         for (String s : phone_book) {
//             all=all.concat(s);
//             all=all.concat(" ");
//         }
// //119 97674223 1195524421
//         for (String s : phone_book) {
//             temp=all;
//             if (temp.contains(s)) {
//                 temp = temp.replaceFirst(s, " ");
//             }
//             if (temp.contains(s)) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }

// // 스트링을 그냥 다 이어 붙인다음에 contains로

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}