package helpers;

import java.util.Random;

public enum QuestionnaireRating {
	SANGAT_KURANG,KURANG_BAIK,CUKUP,BAIK,BAIK_SEKALI;
	
	private static final Random PRNG = new Random();

    public static QuestionnaireRating randomRating()  {
    	QuestionnaireRating[] rating = values();
        return rating[PRNG.nextInt(rating.length)];
    }
}
