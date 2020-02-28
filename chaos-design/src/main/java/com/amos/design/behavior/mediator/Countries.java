package com.amos.design.behavior.mediator;

/**
 * DESCRIPTION: 国家's
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public interface Countries {

    class Usa extends BaseCountry {
        public Usa(BaseUn baseUn) {
            super(baseUn);
        }

        @Override
        public void dealer(String message) {
            getBaseUn().declare(message, this);
        }

        @Override
        public void receive(String message) {
            System.out.println("美国收到消息: " + message);
        }
    }

    class Iraq extends BaseCountry {
        public Iraq(BaseUn baseUn) {
            super(baseUn);
        }

        @Override
        public void dealer(String message) {
            getBaseUn().declare(message, this);
        }

        @Override
        public void receive(String message) {
            System.out.println("伊朗收到消息: " + message);
        }
    }

}
