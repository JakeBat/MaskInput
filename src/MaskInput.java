public class MaskInput {

  public static void main(String[] args) {
    System.out.println(masked("4242424242424242", '*', 0.5f, 8));
    System.out.println(masked("5555555555554444", '-', 0.5f, 4));
    System.out.println(masked("378282246310005", '.', 0.2f, 4));
    System.out.println(masked("3530111333300000", '$', 0.2f, 2));
    System.out.println(masked("4242 4242 4242 4242", '*', 0.4f, 8));
  }

  private static String masked(String input, char mask, float unmaskedFraction, int maxUnmasked) {
    StringBuilder noWhiteSpace = new StringBuilder();
    int length;
    for (int i = 0; i < input.length(); i++) {
      if (Character.toString(input.charAt(i)).equals(" ")) {
        continue;
      }
        noWhiteSpace.append(input.charAt(i));
    }
    length = noWhiteSpace.toString().length();
    float toMask = (((length * unmaskedFraction) > maxUnmasked) ? length - maxUnmasked : length - length * unmaskedFraction);
    for (int i = 0; i < toMask; i++) {
      noWhiteSpace.replace(i, i + 1, Character.toString(mask));
    }
    return noWhiteSpace.toString();
  }
}
