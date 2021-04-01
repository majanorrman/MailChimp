package generators;

import java.util.Random;

public class RandomGenerator {
	
	public RandomGenerator() {}
	
	public String getRandomString(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        
        while (sb.length() < length) { 
            int index = (int) (random.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        
        String saltStr = sb.toString();
        
        return saltStr;
	}
}
