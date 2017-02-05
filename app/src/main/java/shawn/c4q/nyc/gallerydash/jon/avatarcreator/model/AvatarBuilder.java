package shawn.c4q.nyc.gallerydash.jon.avatarcreator.model;

import java.util.Random;

/**
 * Created by jonathancolon on 2/4/17.
 */

public class AvatarBuilder {
    private final static Random random = new Random();
    private static final int EYE_RANGE = 6;
    private static final int HAIR_RANGE = 63;
    private static final int SKINTONE_RANGE = 7;
    private static int GENDER_RANGE = 2;

    public static Avatar createAvatar(){
        Avatar avatar = new Avatar();
        avatar.setGender(randomGender());
        avatar.setSkintone(randomSkinTone());
        avatar.setEyeColor(randomEyeColor());
        avatar.setHairStyle(randomHairColor());
        return avatar;
    }

    private static int randomGender() {
        int gender = random.nextInt(GENDER_RANGE) + 1;
        return gender;
    }


    private static int randomEyeColor(){
        int eyeColor = random.nextInt(EYE_RANGE) + 1;
        return eyeColor;
    }

    private static int randomHairColor(){
        int hairColor = random.nextInt(HAIR_RANGE) + 1;
        return hairColor;
    }

    private static int randomSkinTone(){
        int skinTone = random.nextInt(SKINTONE_RANGE) + 1;
        return skinTone;
    }
}
