public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // عد الحروف
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // بناء السلسلة
        StringBuilder result = new StringBuilder();

        while (true) {
            boolean added = false;

            // ابحث عن أكبر حرف يمكن استخدامه
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    // اجعل i نهائيًا للاستخدام داخل Lambda
                    final int charIndex = i;

                    // إذا تجاوزنا الحد، نبحث عن الحرف التالي الأصغر
                    if (result.length() >= repeatLimit &&
                            result.substring(result.length() - repeatLimit)
                                    .chars()
                                    .allMatch(ch -> ch == ('a' + charIndex))) {
                        // ابحث عن الحرف التالي الأصغر
                        boolean smallerAdded = false;
                        for (int j = i - 1; j >= 0; j--) {
                            if (count[j] > 0) {
                                result.append((char) ('a' + j));
                                count[j]--;
                                smallerAdded = true;
                                break;
                            }
                        }

                        // إذا لم نتمكن من إضافة حرف أصغر، نكسر
                        if (!smallerAdded) {
                            return result.toString();
                        }
                    } else {
                        // أضف الحرف الحالي
                        result.append((char) ('a' + i));
                        count[i]--;
                    }

                    added = true;
                    break;
                }
            }

            // إذا لم نتمكن من إضافة أي حرف، ننهي
            if (!added) {
                break;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.repeatLimitedString("cczazcc", 3)); // Output: "zzcccac"
        System.out.println(sol.repeatLimitedString("aababab", 2)); // Output: "bbabaa"
    }
}
