package controls;

import models.Audio;

public class MyFavorites {

    public void include (Audio audio) {
        if (audio.getClassification() >= 9) {
            System.out.println(audio.getTitle() + " é sucesso!");
        } else {
            System.out.println(audio.getTitle() + " é bom!");
        }
    }
}
