/**
 * Programm zum Aufgabenblatt 6
 * 
 * Aufgabe 6a - PasswordGenerator
 * 
 * This is the PasswordGenerator class. The test class could be find in PasswordGeneratorTest.java.
 * 
 * @author Lisa Weickenmeier
 */

public class PasswordGenerator {
    private String password = "";

    /**
     * Method to create a password out of a sentence. 
     * Every first letter of a word is part of the password. 
     * The password switches between lower and upper case chars.
     * @param sentence as String
     * @return password as String
     */
    public void createPassword(String sentence){
        if(!sentence.isEmpty()){
            sentence = deleteAllInvalidChars(sentence);
            sentence = deleteAllDoubleSpaces(sentence);

            if(!sentence.isEmpty()){
                String[] words = sentence.split(" ");

                for(int i=0; i<words.length;i++){
                    String firstLetter = String.valueOf(words[i].charAt(0));
                    if(i%2==0){
                        firstLetter = firstLetter.toLowerCase();
                    }else{
                        firstLetter= firstLetter.toUpperCase();
                    }

                    this.password += firstLetter;
                }
            }else{
                System.err.println("Your sentence is invalid!");
            }
        }else{
            System.err.println("Your sentence is invalid!");
        }
    }

    /**
     * Method to print the private String password.
     */
    public void printPassword(){
        System.out.println("Password: " + password);
    }

    /**
     * This method deletes all invalid chars (numbers and special characters).
     * @param sentence as String
     * @return new sentence without invalid chars
     */
    private String deleteAllInvalidChars(String sentence){
        String newSentence = "";
        if(!sentence.isEmpty()){
            for(int i=0;i<sentence.length();i++){
                char letter = sentence.charAt(i);
                if(Character.isLetter(letter) || Character.isWhitespace(letter)){
                    newSentence += letter;
                }
            }
        }
        return newSentence;
    }

    /**
     * This method deletes all double spaces in the sentence.
     * @param sentence as String
     * @return new sentence without double spaces
     */
    private String deleteAllDoubleSpaces(String sentence){
        String newSentence = "";

        if(!sentence.isEmpty()){
            for(int i=0;i<sentence.length();i++){
                char letter = sentence.charAt(i);
                if(i==0){
                    if(!Character.isWhitespace(letter)){
                        newSentence += letter;
                    }
                }else if(!(Character.isWhitespace(letter) & Character.isWhitespace(sentence.charAt(i-1)))){
                    newSentence += letter;
                }
            }
        }
        return newSentence;
    }
}
