package Util;

import java.util.concurrent.ThreadLocalRandom;

public class DiceUtil {
    static public int getDiceValue(){
        return ThreadLocalRandom.current().nextInt(1,6+1);
    }
}
