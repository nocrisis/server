package com.questionaire.common.util;

import java.util.Random;

public class CalculateBeatsUtils {
    public static int getRandomBeats(int scoreLevel){
        if(scoreLevel == 0){
            return 0;
        }
        int max = 0, min = 0;
        switch (scoreLevel){
            case 1:min = 5000;max = 20000;break;
            case 2:min = 20001;max = 50000;break;
            case 3:min = 50001;max = 99999;break;
            case 4:min = 100000;max = 150000;break;
            default:break;
        }
        return new Random().nextInt(max)%(max-min+1)+min;
    }

    public static int getScoreLevel(int score){
        if(score<=0){
            return 0;
        }
        if(score>0 && score<=20){
            return 1;
        }
        else if(score>20 && score<=50){
            return 2;
        }
        else if(score>50 && score<=80){
            return 3;
        }
        return 4;
    }
}