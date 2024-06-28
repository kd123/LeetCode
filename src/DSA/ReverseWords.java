package DSA;

public class ReverseWords {

    public static void main(String[] args) {
        String sentence = "Reverse a sentence of words";
        String reversedSentence = reverseWords(sentence);
        System.out.println(reversedSentence);
    }

    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}
