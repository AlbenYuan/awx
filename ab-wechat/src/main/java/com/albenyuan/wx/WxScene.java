package com.albenyuan.wx;

/**
 * @Author Alben Yuan
 * @Date 2017-12-13 13:52
 */

public class WxScene {
    public enum Scene {

        /**
         * 公众号
         */
        JS_API(1),

        /**
         * 小程序
         */
        WXA(2),

        /**
         * app
         */
        APP(3);

        private Integer value;

        private Scene(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static Scene getByValue(Integer value) {
            if (null != value) {
                for (Scene scene : Scene.values()) {
                    if (value.equals(scene.getValue())) {
                        return scene;
                    }
                }
            }
            return null;
        }

    }
}
