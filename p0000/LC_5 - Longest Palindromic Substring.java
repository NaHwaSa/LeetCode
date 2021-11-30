class Answer {
      int maxLen, mid;
      boolean type;

      public Answer(int maxLen, int mid, boolean type) {
          this.maxLen = maxLen;
          this.mid = mid;
          this.type = type;
      }
  }

class Solution {
    Answer answer = new Answer(1, 0, true);

    private void setMaxPalindromLen(String str, int mid) {
        int num = Math.min(mid, str.length()-mid-1);
        int cnt = 1;
        for (int i = 1; i <= num; i++) {
            if (str.charAt(mid-i) != str.charAt(mid+i)) break;
            cnt+=2;
        }
        if (answer.maxLen < cnt) answer = new Answer(cnt, mid, true);

        num = Math.min(mid+1, str.length()-mid-1);
        cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (str.charAt(mid-i+1) != str.charAt(mid+i)) break;
            cnt+=2;
        }
        if (answer.maxLen < cnt) answer = new Answer(cnt, mid, false);
    }

    public String longestPalindrome(String str) {
        if (str.length() == 1)
            return str;

        for (int mid = str.length()/2; mid >= 0; mid--) {
            if ((mid+1)*2 < answer.maxLen) continue;
            setMaxPalindromLen(str, mid);
        }

        for (int mid = str.length()/2+1; mid < str.length(); mid++) {
            if ((str.length() - mid+1)*2 <= answer.maxLen) continue;
            setMaxPalindromLen(str, mid);
        }

        StringBuilder res = new StringBuilder();
        for (int i = answer.mid - answer.maxLen/2 + (answer.type?0:1); i <= answer.mid + answer.maxLen/2; i++)
            res.append(str.charAt(i));

        return res.toString();
    }
}
