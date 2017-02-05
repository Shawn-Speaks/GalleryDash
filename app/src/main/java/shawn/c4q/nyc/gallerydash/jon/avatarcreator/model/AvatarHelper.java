package shawn.c4q.nyc.gallerydash.jon.avatarcreator.model;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import shawn.c4q.nyc.gallerydash.R;

import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BALD_BLACK;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BALD_BLONDE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BALD_BROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BALD_CHESTNUT;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BALD_GINGER;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BALD_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BALD_LITE_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BANGS_BLACK;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BANGS_BLONDE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BANGS_BROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BANGS_CHESTNUT;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BANGS_GINGER;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BANGS_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BANGS_LITE_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_BLACK;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_BLONDE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_BROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_CHESTNUT;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_GINGER;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_LIGHT_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_LONG_BLACK;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_LONG_BLONDE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_LONG_BROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_LONG_CHESTNUT;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_LONG_GINGER;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_LONG_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.BUN_LONG_LIGHT_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.COMBOVER_BLACK;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.COMBOVER_BLONDE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.COMBOVER_BROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.COMBOVER_CHESTNUT;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.COMBOVER_GINGER;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.COMBOVER_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.COMBOVER_LITE_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EMO_BLACK;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EMO_BLONDE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EMO_BROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EMO_CHESTNUT;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EMO_GINGER;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EMO_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EMO_LITE_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EYES_DARKBROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EYES_DARKGREEN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EYES_GREEN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EYES_LAVENDAR;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EYES_LIGHTBROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.EYES_STEELBLUE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.FEMALE_1;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.FEMALE_2;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.FEMALE_3;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.FEMALE_4;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.FEMALE_5;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.FEMALE_6;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.FEMALE_7;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.MALE_1;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.MALE_2;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.MALE_3;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.MALE_4;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.MALE_5;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.MALE_6;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.MALE_7;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NATURAL_BLACK;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NATURAL_BLONDE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NATURAL_BROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NATURAL_CHESTNUT;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NATURAL_GINGER;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NATURAL_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NATURAL_LITE_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NEICY_BLACK;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NEICY_BLONDE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NEICY_BROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NEICY_CHESTNUT;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NEICY_GINGER;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NEICY_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.NEICY_LITE_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.SPEAKS_BLACK;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.SPEAKS_BLONDE;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.SPEAKS_BROWN;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.SPEAKS_CHESTNUT;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.SPEAKS_GINGER;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.SPEAKS_GREY;
import static shawn.c4q.nyc.gallerydash.jon.avatarcreator.model.AvatarAttributes.SPEAKS_LITE_GREY;


public class AvatarHelper {

    Context context;
    //// TODO: 2/4/17 create fields/methods for clothing
    private ImageView eyeColorLayer;
    private ImageView skinToneLayer;
    private ImageView hairStyleLayer;
    private TextView nameLayer;

    public AvatarHelper(Context context) {
        this.context = context;
    }

    public void updateAvatarSpriteView(Avatar avatar) {
        eyeColorLayer = (ImageView) ((Activity) context).findViewById(R.id.eyes);
        skinToneLayer = (ImageView) ((Activity) context).findViewById(R.id.skintone);
        hairStyleLayer = (ImageView) ((Activity) context).findViewById(R.id.hair);

        setEyeLayer(avatar.getEyeColor());
        setFemaleSkintoneLayer(avatar.getSkintone());
//        setHairLayer(avatar.getHairStyle()); //todo activate hair generator

    }

    public void setEyeLayer(int eyeColor) {

        switch (eyeColor) {
            case 1:
                eyeColorLayer.setImageResource(EYES_DARKBROWN);
                break;
            case 2:
                eyeColorLayer.setImageResource(EYES_DARKGREEN);
                break;
            case 3:
                eyeColorLayer.setImageResource(EYES_GREEN);
                break;
            case 4:
                eyeColorLayer.setImageResource(EYES_LAVENDAR);
                break;
            case 5:
                eyeColorLayer.setImageResource(EYES_LIGHTBROWN);
                break;
            case 6:
                eyeColorLayer.setImageResource(EYES_STEELBLUE);
                break;
            default:
                Toast.makeText(context, "Failed to display eyes", Toast.LENGTH_SHORT).show();
        }
    }

    public void setFemaleSkintoneLayer(int skintone) {

        switch (skintone) {
            case 1:
                skinToneLayer.setImageResource(FEMALE_1);
                break;
            case 2:
                skinToneLayer.setImageResource(FEMALE_2);
                break;
            case 3:
                skinToneLayer.setImageResource(FEMALE_3);
                break;
            case 4:
                skinToneLayer.setImageResource(FEMALE_4);
                break;
            case 5:
                skinToneLayer.setImageResource(FEMALE_5);
                break;
            case 6:
                skinToneLayer.setImageResource(FEMALE_6);
                break;
            case 7:
                skinToneLayer.setImageResource(FEMALE_7);
                break;
        }
    }

    public void generateNewAvatarSprite() {
        eyeColorLayer = (ImageView) ((Activity) context).findViewById(R.id.eyes);
        skinToneLayer = (ImageView) ((Activity) context).findViewById(R.id.skintone);
        hairStyleLayer = (ImageView) ((Activity) context).findViewById(R.id.hair);

        Avatar avatar = AvatarBuilder.createAvatar();

        setEyeLayer(avatar.getEyeColor());
        setFemaleSkintoneLayer(avatar.getSkintone());
        setHairLayer(avatar.getHairStyle());
    }

    public void setMaleSkintoneLayer(int skintone) {

        switch (skintone) {
            case 1:
                skinToneLayer.setImageResource(MALE_1);
                break;
            case 2:
                skinToneLayer.setImageResource(MALE_2);
                break;
            case 3:
                skinToneLayer.setImageResource(MALE_3);
                break;
            case 4:
                skinToneLayer.setImageResource(MALE_4);
                break;
            case 5:
                skinToneLayer.setImageResource(MALE_5);
                break;
            case 6:
                skinToneLayer.setImageResource(MALE_6);
                break;
            case 7:
                skinToneLayer.setImageResource(MALE_7);
                break;
        }
    }

    //todo import hairstyles
    public void setHairLayer(int hairStyle) {

        switch (hairStyle) {
            case 1:
                hairStyleLayer.setImageResource(BALD_BLACK);
                break;
            case 2:
                hairStyleLayer.setImageResource(BALD_BLONDE);
                break;
            case 3:
                hairStyleLayer.setImageResource(BALD_BROWN);
                break;
            case 4:
                hairStyleLayer.setImageResource(BALD_GREY);
                break;
            case 5:
                hairStyleLayer.setImageResource(BALD_CHESTNUT);
                break;
            case 6:
                hairStyleLayer.setImageResource(BALD_GINGER);
                break;
            case 7:
                hairStyleLayer.setImageResource(BALD_LITE_GREY);
                break;
            case 8:
                hairStyleLayer.setImageResource(BANGS_BLACK);
                break;
            case 9:
                hairStyleLayer.setImageResource(BANGS_BLONDE);
                break;
            case 10:
                hairStyleLayer.setImageResource(BANGS_BROWN);
                break;
            case 11:
                hairStyleLayer.setImageResource(BANGS_CHESTNUT);
                break;
            case 12:
                hairStyleLayer.setImageResource(BANGS_GINGER);
                break;
            case 13:
                hairStyleLayer.setImageResource(BANGS_GREY);
                break;
            case 14:
                hairStyleLayer.setImageResource(BANGS_LITE_GREY);
                break;
            case 15:
                hairStyleLayer.setImageResource(BUN_BLACK);
                break;
            case 16:
                hairStyleLayer.setImageResource(BUN_BLONDE);
                break;
            case 17:
                hairStyleLayer.setImageResource(BUN_BROWN);
                break;
            case 18:
                hairStyleLayer.setImageResource(BUN_CHESTNUT);
                break;
            case 19:
                hairStyleLayer.setImageResource(BUN_GINGER);
                break;
            case 20:
                hairStyleLayer.setImageResource(BUN_LIGHT_GREY);
                break;
            case 21:
                hairStyleLayer.setImageResource(BUN_GREY);
                break;
            case 22:
                hairStyleLayer.setImageResource(BUN_LONG_BLACK);
                break;
            case 23:
                hairStyleLayer.setImageResource(BUN_LONG_BLONDE);
                break;
            case 24:
                hairStyleLayer.setImageResource(BUN_LONG_BROWN);
                break;
            case 25:
                hairStyleLayer.setImageResource(BUN_LONG_CHESTNUT);
                break;
            case 26:
                hairStyleLayer.setImageResource(BUN_LONG_GINGER);
                break;
            case 27:
                hairStyleLayer.setImageResource(BUN_LONG_GREY);
                break;
            case 28:
                hairStyleLayer.setImageResource(BUN_LONG_LIGHT_GREY);
                break;
            case 29:
                hairStyleLayer.setImageResource(NEICY_BLACK);
                break;
            case 30:
                hairStyleLayer.setImageResource(NEICY_BLONDE);
                break;
            case 31:
                hairStyleLayer.setImageResource(NEICY_BROWN);
                break;
            case 32:
                hairStyleLayer.setImageResource(NEICY_CHESTNUT);
                break;
            case 33:
                hairStyleLayer.setImageResource(NEICY_GINGER);
                break;
            case 34:
                hairStyleLayer.setImageResource(NEICY_GREY);
                break;
            case 35:
                hairStyleLayer.setImageResource(NEICY_LITE_GREY);
                break;
            case 36:
                hairStyleLayer.setImageResource(EMO_BLACK);
                break;
            case 37:
                hairStyleLayer.setImageResource(EMO_BLONDE);
                break;
            case 38:
                hairStyleLayer.setImageResource(EMO_BROWN);
                break;
            case 39:
                hairStyleLayer.setImageResource(EMO_CHESTNUT);
                break;
            case 40:
                hairStyleLayer.setImageResource(EMO_GINGER);
                break;
            case 41:
                hairStyleLayer.setImageResource(EMO_GREY);
                break;
            case 42:
                hairStyleLayer.setImageResource(EMO_LITE_GREY);
                break;
            case 43:
                hairStyleLayer.setImageResource(COMBOVER_BLACK);
                break;
            case 44:
                hairStyleLayer.setImageResource(COMBOVER_BLONDE);
                break;
            case 45:
                hairStyleLayer.setImageResource(COMBOVER_BROWN);
                break;
            case 46:
                hairStyleLayer.setImageResource(COMBOVER_CHESTNUT);
                break;
            case 47:
                hairStyleLayer.setImageResource(COMBOVER_GINGER);
                break;
            case 48:
                hairStyleLayer.setImageResource(COMBOVER_GREY);
                break;
            case 49:
                hairStyleLayer.setImageResource(COMBOVER_LITE_GREY);
                break;
            case 50:
                hairStyleLayer.setImageResource(SPEAKS_BLACK);
                break;
            case 51:
                hairStyleLayer.setImageResource(SPEAKS_BLONDE);
                break;
            case 52:
                hairStyleLayer.setImageResource(SPEAKS_BROWN);
                break;
            case 53:
                hairStyleLayer.setImageResource(SPEAKS_CHESTNUT);
                break;
            case 54:
                hairStyleLayer.setImageResource(SPEAKS_GINGER);
                break;
            case 55:
                hairStyleLayer.setImageResource(SPEAKS_GREY);
                break;
            case 56:
                hairStyleLayer.setImageResource(SPEAKS_LITE_GREY);
                break;
            case 57:
                hairStyleLayer.setImageResource(NATURAL_BLACK);
                break;
            case 58:
                hairStyleLayer.setImageResource(NATURAL_BLONDE);
                break;
            case 59:
                hairStyleLayer.setImageResource(NATURAL_BROWN);
                break;
            case 60:
                hairStyleLayer.setImageResource(NATURAL_CHESTNUT);
                break;
            case 61:
                hairStyleLayer.setImageResource(NATURAL_GINGER);
                break;
            case 62:
                hairStyleLayer.setImageResource(NATURAL_GREY);
                break;
            case 63:
                hairStyleLayer.setImageResource(NATURAL_LITE_GREY);
                break;
        }
    }
}
