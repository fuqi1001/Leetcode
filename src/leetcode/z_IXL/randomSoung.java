package leetcode.z_IXL;

import java.util.Random;

/**
 * Created by qifu on 17/4/22.
 */
public class randomSoung {
    List<Sound> correct_sounds;
    Sound error_sound;
    Sound prev_used;

    public void playSound() {
        boolean correct = user.getAnswer();
        if(!correct) {
            play(error_sound);
            if(prev_used != null) {
                correct_sounds.add(prev_used);
                prev_used = null;
            }
        } else {
            Random r = new Random(correct_sounds.size());
            int ran_index = r.random();
            Sound correct_sound = correct_sounds.get(ran_index);
            play(correct_sound);
            correct_sounds.remove(correct_sound);
            if(prev_used != null) {
                correct_sounds.add(prev_used);
            }
            prev_used = correct_sound;
        }
    }
    /*
    正确的语音随机播放并且不重复
    1. 如果错了,把之前用过的语音可以添加回correct_sounds里面
    2. 如果正确, 选择随机语音播放,并且从correct_sounds list里剔除已播放的
        如果prev_used里保存了上一次用过的音乐  把它加回List里面
        更新Prev_used
     */
}
